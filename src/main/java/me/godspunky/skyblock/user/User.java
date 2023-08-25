package me.godspunky.skyblock.user;

import boardinggamer.mcmoney.McMoneyAPI;
import com.google.common.util.concurrent.AtomicDouble;
import de.tr7zw.nbtapi.NBTItem;
import lombok.Getter;
import lombok.Setter;
import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.config.Config;
import me.godspunky.skyblock.features.auction.AuctionBid;
import me.godspunky.skyblock.features.auction.AuctionEscrow;
import me.godspunky.skyblock.features.auction.AuctionItem;
import me.godspunky.skyblock.features.collection.ItemCollection;
import me.godspunky.skyblock.features.collection.ItemCollectionReward;
import me.godspunky.skyblock.features.collection.ItemCollectionRewards;
import me.godspunky.skyblock.features.entity.SEntity;
import me.godspunky.skyblock.features.item.SItem;
import me.godspunky.skyblock.features.item.SMaterial;
import me.godspunky.skyblock.features.item.pet.Pet;
import me.godspunky.skyblock.features.potion.ActivePotionEffect;
import me.godspunky.skyblock.features.potion.PotionEffect;
import me.godspunky.skyblock.features.potion.PotionEffectType;
import me.godspunky.skyblock.features.region.Cuboid;
import me.godspunky.skyblock.features.region.Region;
import me.godspunky.skyblock.features.region.RegionType;
import me.godspunky.skyblock.features.skill.*;
import me.godspunky.skyblock.features.slayer.SlayerBossType;
import me.godspunky.skyblock.features.slayer.SlayerQuest;
import me.godspunky.skyblock.util.BukkitSerializeClass;
import me.godspunky.skyblock.util.SUtil;
import me.godspunky.skyblock.util.Sputnik;
import net.milkbowl.vault.economy.Economy;
import net.minecraft.server.v1_8_R3.EntityHuman;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftHumanEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class User {
    public static final int ISLAND_SIZE = 125;

    private static final Map<UUID, User> USER_CACHE = new HashMap<>();
    private static final Skyblock plugin = Skyblock.getPlugin();
    private static final File USER_FOLDER = new File(plugin.getDataFolder(), "./users");

    @Getter
    private UUID uuid;
    private final Config config;
    private final Map<ItemCollection, Integer> collections;
    private long coins;
    @Getter
    private long bankCoins;

    McMoneyAPI api;

    private boolean cooldownAPI = false;
    @Getter
    private Double islandX;
    @Getter
    private Double islandZ;

    @Getter
    private Region lastRegion;
    @Getter
    private final Map<SMaterial, Integer> quiver;
    @Getter
    private final Map<SMaterial, Integer> accessory;
    @Getter
    private final Map<SMaterial, Integer> potionbag;
    @Getter
    private final Map<SMaterial, Integer> chestpageone;
    @Getter
    private final List<ActivePotionEffect> effects;
    @Getter
    private double farmingXP;
    @Getter
    private double miningXP;
    @Getter
    private double combatXP;
    @Getter
    private double foragingXP;
    private final int[] highestSlayers;
    private final int[] slayerXP;
    @Getter
    @Setter
    private boolean permanentCoins;
    @Getter
    @Setter
    private SlayerQuest slayerQuest;
    @Getter
    private List<Pet.PetItem> pets;
    @Getter
    private AuctionSettings auctionSettings;
    @Getter
    @Setter
    private boolean auctionCreationBIN;

    @Getter
    @Setter
    private AuctionEscrow auctionEscrow;

    private User(UUID uuid) {
        this.uuid = uuid;
        this.api = McMoneyAPI.getInstance();
        this.collections = ItemCollection.getDefaultCollections();
        this.coins = 0;
        this.bankCoins = 0;
        this.islandX = null;
        this.islandZ = null;
        this.lastRegion = null;
        this.quiver = new HashMap<>();
        this.accessory = new HashMap<>();
        this.potionbag = new HashMap<>();
        this.chestpageone = new HashMap<>();
        this.effects = new ArrayList<>();
        this.farmingXP = 0.0;
        this.miningXP = 0.0;
        this.combatXP = 0.0;
        this.foragingXP = 0.0;
        this.highestSlayers = new int[3];
        this.slayerXP = new int[3];
        this.permanentCoins = false;
        this.pets = new ArrayList<>();
        this.auctionSettings = new AuctionSettings();
        this.auctionCreationBIN = false;
        this.auctionEscrow = new AuctionEscrow();
        if (!USER_FOLDER.exists()) USER_FOLDER.mkdirs();
        String path = uuid.toString() + ".yml";
        File configFile = new File(USER_FOLDER, path);
        boolean save = false;
        try {
            if (!configFile.exists()) {
                save = true;
                configFile.createNewFile();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        this.config = new Config(USER_FOLDER, path);
        USER_CACHE.put(uuid, this);
        if (save) save();
        load();
    }

    public void load() {
        this.uuid = UUID.fromString(config.getString("uuid"));
        if (config.contains("collections")) {
            for (String identifier : config.getConfigurationSection("collections").getKeys(false))
                this.collections.put(ItemCollection.getByIdentifier(identifier), config.getInt("collections." + identifier));
        }
        this.coins = (long) api.getMoney(getBukkitPlayer());
        this.bankCoins = config.getLong("bankCoins");
        this.islandX = config.contains("island.x") ? config.getDouble("island.x") : null;
        this.islandZ = config.contains("island.z") ? config.getDouble("island.z") : null;
        this.lastRegion = config.getString("lastRegion") != null ? Region.get(config.getString("lastRegion")) : null;

        if (config.contains("quiver")) {
            for (String m : config.getConfigurationSection("quiver").getKeys(false))
                this.quiver.put(SMaterial.getMaterial(m), config.getInt("quiver." + m));
        }
        if (config.contains("accessory")) {
            for (String m : config.getConfigurationSection("accessory").getKeys(false))
                this.accessory.put(SMaterial.getMaterial(m), config.getInt("accessory." + m));
        }
        if (config.contains("potionbag")) {
            for (String m : config.getConfigurationSection("potionbag").getKeys(false))
                this.potionbag.put(SMaterial.getMaterial(m), config.getInt("potionbag." + m));
        }
        if (config.contains("chestpageone")) {
            for (String m : config.getConfigurationSection("chestpageone").getKeys(false))
                this.chestpageone.put(SMaterial.getMaterial(m), config.getInt("chestpageone." + m));
        }

        if (config.contains("effects")) {
            for (String key : config.getConfigurationSection("effects").getKeys(false)) {
                this.effects.add(new ActivePotionEffect(new PotionEffect(PotionEffectType.getByNamespace(key),
                        config.getInt("effects." + key + ".level"), config.getLong("effects." + key + ".duration")),
                        config.getLong("effects." + key + ".remaining")));
            }
        }
        this.farmingXP = config.getDouble("xp.farming");
        this.miningXP = config.getDouble("xp.mining");
        this.combatXP = config.getDouble("xp.combat");
        this.foragingXP = config.getDouble("xp.foraging");
        this.highestSlayers[0] = config.getInt("slayer.revenantHorror.highest");
        this.highestSlayers[1] = config.getInt("slayer.tarantulaBroodfather.highest");
        this.highestSlayers[2] = config.getInt("slayer.svenPackmaster.highest");
        this.slayerXP[0] = config.getInt("xp.slayer.revenantHorror");
        this.slayerXP[1] = config.getInt("xp.slayer.tarantulaBroodfather");
        this.slayerXP[2] = config.getInt("xp.slayer.svenPackmaster");
        this.permanentCoins = config.getBoolean("permanentCoins");
        this.slayerQuest = (SlayerQuest) config.get("slayer.quest");
        if (config.contains("pets")) {
            this.pets = (List<Pet.PetItem>) config.getList("pets");
        }
        this.auctionSettings = (AuctionSettings) config.get("auction.settings");
        if (this.auctionSettings == null)
            this.auctionSettings = new AuctionSettings();
        this.auctionCreationBIN = config.getBoolean("auction.creationBIN");
        this.auctionEscrow = (AuctionEscrow) config.get("auction.escrow");
        if (this.auctionEscrow == null)
            this.auctionEscrow = new AuctionEscrow();
    }

    public void save() {
        config.set("uuid", uuid.toString());
        config.set("collections", null);
        for (Map.Entry<ItemCollection, Integer> entry : collections.entrySet())
            config.set("collections." + entry.getKey().getIdentifier(), entry.getValue());
        //config.set("coins", coins);
        config.set("bankCoins", bankCoins);
        config.set("island.x", islandX);
        config.set("island.z", islandZ);
        if (lastRegion != null)
            config.set("lastRegion", lastRegion.getName());
        config.set("quiver", null);
        for (Map.Entry<SMaterial, Integer> entry : quiver.entrySet())
            config.set("quiver." + entry.getKey().name().toLowerCase(), entry.getValue());
        config.set("accessory", null);
        for (Map.Entry<SMaterial, Integer> entry : accessory.entrySet())
            config.set("accessory." + entry.getKey().name().toLowerCase(), entry.getValue());
        config.set("potionbag", null);
        for (Map.Entry<SMaterial, Integer> entry : potionbag.entrySet())
            config.set("potionbag." + entry.getKey().name().toLowerCase(), entry.getValue());
        config.set("chestpageone", null);
        for (Map.Entry<SMaterial, Integer> entry : chestpageone.entrySet())
            config.set("chestpageone." + entry.getKey().name().toLowerCase(), entry.getValue());
        config.set("effects", null);
        for (ActivePotionEffect effect : effects) {
            PotionEffectType type = effect.getEffect().getType();
            config.set("effects." + type.getNamespace() + ".level", effect.getEffect().getLevel());
            config.set("effects." + type.getNamespace() + ".duration", effect.getEffect().getDuration());
            config.set("effects." + type.getNamespace() + ".remaining", effect.getRemaining());
        }
        config.set("xp.farming", farmingXP);
        config.set("xp.mining", miningXP);
        config.set("xp.combat", combatXP);
        config.set("xp.foraging", foragingXP);
        config.set("slayer.revenantHorror.highest", highestSlayers[0]);
        config.set("slayer.tarantulaBroodfather.highest", highestSlayers[1]);
        config.set("slayer.svenPackmaster.highest", highestSlayers[2]);
        config.set("xp.slayer.revenantHorror", slayerXP[0]);
        config.set("xp.slayer.tarantulaBroodfather", slayerXP[1]);
        config.set("xp.slayer.svenPackmaster", slayerXP[2]);
        config.set("permanentCoins", permanentCoins);
        config.set("slayer.quest", slayerQuest);
        config.set("pets", pets);
        config.set("auction.settings", auctionSettings);
        config.set("auction.creationBIN", auctionCreationBIN);
        config.set("auction.escrow", auctionEscrow);
        config.save();
    }

    public void saveInventory() {
        if (Bukkit.getPlayer(this.uuid) == null)
            return;
        Object a = null;
        PlayerInventory piv = Bukkit.getPlayer(this.uuid).getInventory();
        a = getPureListFrom(piv);
        this.config.set("database.inventory", a);
        this.config.save();
    }

    public String getPureListFrom(Inventory piv) {
        ItemStack[] ist = piv.getContents();
        List<ItemStack> arraylist = Arrays.asList(ist);
        for (int i = 0; i < ist.length; i++) {
            ItemStack stack = ist[i];
            if (stack != null) {
                NBTItem nbti = new NBTItem(stack);
                if (nbti.hasKey("dontSaveToProfile").booleanValue())
                    arraylist.remove(i);
            }
        }
        ItemStack[] arrl = (ItemStack[])arraylist.toArray();
        return BukkitSerializeClass.itemStackArrayToBase64(arrl);
    }

    public void saveArmor() {
        if (Bukkit.getPlayer(this.uuid) == null)
            return;
        Object a = null;
        a = BukkitSerializeClass.itemStackArrayToBase64(Bukkit.getPlayer(this.uuid).getInventory().getArmorContents());
        this.config.set("database.armor", a);
        this.config.save();
    }

    public void saveEnderChest() {
        if (Bukkit.getPlayer(this.uuid) == null)
            return;
        Object a = null;
        Inventory inv = Bukkit.getPlayer(this.uuid).getEnderChest();
        a = getPureListFrom(inv);
        this.config.set("database.enderchest", a);
        this.config.save();
    }


    public void loadPlayerData() throws IllegalArgumentException, IOException {
        Player player = Bukkit.getPlayer(this.uuid);
        if (this.config.getString("database.inventory") != null) {
            player.getInventory().setContents(BukkitSerializeClass.itemStackArrayFromBase64(this.config.getString("database.inventory")));
        } else {
            player.getInventory().setContents(new ItemStack[player.getInventory().getSize()]);
        }
        if (this.config.getString("database.enderchest") != null) {
            player.getEnderChest().setContents(BukkitSerializeClass.itemStackArrayFromBase64(this.config.getString("database.enderchest")));
        } else {
            player.getInventory().setContents(new ItemStack[player.getEnderChest().getSize()]);
        }
        if (this.config.getString("database.armor") != null) {
            player.getInventory().setArmorContents(BukkitSerializeClass.itemStackArrayFromBase64(this.config.getString("database.armor")));
        } else {
            player.getInventory().setContents(new ItemStack[(player.getInventory().getArmorContents()).length]);
        }
        if (this.config.contains("configures.slot_selected"))
            player.getInventory().setHeldItemSlot(this.config.getInt("configures.slot_selected"));
    }


    public void saveLastSlot() {
        if (Bukkit.getPlayer(this.uuid) == null)
            return;
        this.config.set("configures.slot_selected", Integer.valueOf(Bukkit.getPlayer(this.uuid).getInventory().getHeldItemSlot()));
        this.config.save();
    }

    public void saveAttributesForAPI() {
        if (Bukkit.getPlayer(this.uuid) == null)
            return;
        PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(getUuid());
        if (statistics == null)
            return;
        Double visualcap = Double.valueOf(statistics.getCritChance().addAll().doubleValue() * 100.0D);
        if (visualcap.doubleValue() > 100.0D)
            visualcap = Double.valueOf(100.0D);
        this.config.set("apistats.health", Integer.valueOf(statistics.getMaxHealth().addAll().intValue()));
        this.config.set("apistats.defense", Integer.valueOf(statistics.getDefense().addAll().intValue()));
        this.config.set("apistats.strength", Integer.valueOf(statistics.getStrength().addAll().intValue()));
        this.config.set("apistats.crit_chance", Integer.valueOf(visualcap.intValue()));
        this.config.set("apistats.speed", Integer.valueOf(Double.valueOf(statistics.getSpeed().addAll().doubleValue() * 100.0D).intValue()));
        this.config.set("apistats.crit_damage", Integer.valueOf(Double.valueOf(statistics.getCritDamage().addAll().doubleValue() * 100.0D).intValue()));
        this.config.set("apistats.intelligence", Integer.valueOf(statistics.getIntelligence().addAll().intValue()));
        this.config.set("apistats.magic_find", Integer.valueOf(Double.valueOf(statistics.getMagicFind().addAll().doubleValue() * 100.0D).intValue()));
        this.config.set("apistats.ferocity", Integer.valueOf(statistics.getFerocity().addAll().intValue()));
        this.config.save();
    }

    public void saveAllVanillaInstances() {
        if (Bukkit.getPlayer(this.uuid) == null)
            return;
        saveArmor();
        saveEnderChest();
        saveInventory();
        saveLastSlot();
        saveAttributesForAPI();
    }

    public void syncSavingData() {
        (new BukkitRunnable() {
            public void run() {
                User.this.save();
                User.this.saveAllVanillaInstances();
            }
        }).runTask(plugin);
    }

    public HashMap<SMaterial , Integer> getchestpage1(){
        return (HashMap<SMaterial, Integer>) chestpageone;
    }

    public void setIslandLocation(double x, double z) {
        this.islandX = x;
        this.islandZ = z;
    }

    public boolean isCooldownAPI() {
        return this.cooldownAPI;
    }

    public void setCooldownAPI(boolean cooldownAPI) {
        this.cooldownAPI = cooldownAPI;
    }

    public void setLastRegion(Region lastRegion) {
        this.lastRegion = lastRegion;
    }

    public void addCoins(long coins) {
        api.addMoney(getBukkitPlayer() , coins);
    }

    public Player getBukkitPlayer() {
        return Bukkit.getPlayer(uuid);
    }

    public void subCoins(long coins) {
        api.removeMoney(getBukkitPlayer() , coins);
    }

    public void setCoins(long coins) {
        api.setMoney(getBukkitPlayer() , coins);
    }

    public void addBankCoins(long bankCoins) {
        this.bankCoins += bankCoins;
    }
    public Long getCoins(){
        return (long) api.getMoney(getBukkitPlayer());
    }

    public void subBankCoins(long bankCoins) {
        this.bankCoins -= bankCoins;
    }

    public void setBankCoins(long bankCoins) {
        this.bankCoins = bankCoins;
    }

    public void addToCollection(ItemCollection collection, int amount) {
        int prevTier = collection.getTier(getCollection(collection));
        int i = collections.getOrDefault(collection, 0);
        collections.put(collection, i + amount);
        updateCollection(collection, prevTier);
    }

    public void addToCollection(ItemCollection collection) {
        addToCollection(collection, 1);
    }

    public void setCollection(ItemCollection collection, int amount) {
        int prevTier = collection.getTier(getCollection(collection));
        collections.put(collection, amount);
        updateCollection(collection, prevTier);
    }

    public void zeroCollection(ItemCollection collection) {
        int prevTier = collection.getTier(getCollection(collection));
        collections.put(collection, 0);
        updateCollection(collection, prevTier);
    }



    private void updateCollection(ItemCollection collection, int prevTier) {
        int tier = collection.getTier(getCollection(collection));
        if (prevTier != tier) {
            Player player = Bukkit.getPlayer(uuid);
            if (player != null)
                player.playSound(player.getLocation(), Sound.LEVEL_UP, 1f, 2f);
            StringBuilder builder = new StringBuilder();
            builder.append(ChatColor.YELLOW).append(ChatColor.BOLD).append("------------------------------------------\n");
            builder.append(ChatColor.GOLD).append(ChatColor.BOLD).append("  COLLECTION LEVEL UP ").append(ChatColor.RESET)
                    .append(ChatColor.YELLOW).append(collection.getName()).append(" ");
            if (prevTier != 0)
                builder.append(ChatColor.DARK_GRAY).append(SUtil.toRomanNumeral(prevTier)).append("➜");
            builder.append(ChatColor.YELLOW).append(SUtil.toRomanNumeral(tier)).append("\n");
            ItemCollectionRewards rewards = collection.getRewardsFor(tier);
            if (rewards != null && rewards.size() != 0) {
                builder.append(" \n");
                builder.append(ChatColor.GREEN).append(ChatColor.BOLD).append("  REWARD");
                if (rewards.size() != 1)
                    builder.append("S");
                builder.append(ChatColor.RESET);
                for (ItemCollectionReward reward : rewards) {
                    reward.onAchieve(player);
                    builder.append("\n    ").append(reward.toRewardString());
                }
            }
            builder.append(ChatColor.YELLOW).append(ChatColor.BOLD).append("------------------------------------------");
            send(builder.toString());
        }
    }

    public int getCollection(ItemCollection collection) {
        return collections.get(collection);
    }

    public boolean hasCollection(ItemCollection collection, int tier) {
        return collection.getTier(getCollection(collection)) >= tier;
    }

    public void addToQuiver(SMaterial material, int amount) {
        int i = quiver.getOrDefault(material, 0);
        setQuiver(material, i + amount);
    }

    public void addToAccessory(SMaterial material, int amount) {
        int i = accessory.getOrDefault(material, 0);
        setAccessory(material, i + amount);
    }

    public void addToPotionbag(SMaterial material, int amount) {
        int i = potionbag.getOrDefault(material, 0);
        setPotionbag(material, i + amount);
    }

    public void addToChestPageOne(SMaterial material, int amount) {
        int i = chestpageone.getOrDefault(material, 0);
        setChestpageone(material, i + amount);
    }

    public void addToQuiver(SMaterial material) {
        addToQuiver(material, 1);
    }
    public void addToAccessory(SMaterial material) {
        addToAccessory(material, 1);
    }
    public void addToPotionbag(SMaterial material) {
        addToPotionbag(material, 1);
    }
    public void addToChestPageOne(SMaterial material) {
        addToChestPageOne(material, 1);
    }

    public void setQuiver(SMaterial material, int amount) {
        if (amount == 0) {
            quiver.remove(material);
            return;
        }
        quiver.put(material, amount);
    }
    public void setAccessory(SMaterial material, int amount) {
        if (amount == 0) {
            accessory.remove(material);
            return;
        }
        accessory.put(material, amount);
    }
    public void setPotionbag(SMaterial material, int amount) {
        if (amount == 0) {
            potionbag.remove(material);
            return;
        }
        potionbag.put(material, amount);
    }
    public void setChestpageone(SMaterial material, int amount) {
        if (amount == 0) {
            chestpageone.remove(material);
            return;
        }
        chestpageone.put(material, amount);
    }

    public int getQuiver(SMaterial material) {
        return quiver.get(material);
    }
    public int getAccessory(SMaterial material) {
        return accessory.get(material);
    }
    public int getPotionbag(SMaterial material) {
        return potionbag.get(material);
    }
    public int getChestPageOne(SMaterial material) {
        return chestpageone.get(material);
    }

    public void subFromQuiver(SMaterial material, int amount) {
        if (!quiver.containsKey(material)) return;
        setQuiver(material, quiver.get(material) - amount);
    }
    public void subFromAccessory(SMaterial material, int amount) {
        if (!accessory.containsKey(material)) return;
        setAccessory(material, accessory.get(material) - amount);
    }
    public void subFromPotionbag(SMaterial material, int amount) {
        if (!potionbag.containsKey(material)) return;
        setPotionbag(material, potionbag.get(material) - amount);
    }
    public void subFromChestPageOne(SMaterial material, int amount) {
        if (!chestpageone.containsKey(material)) return;
        setChestpageone(material, chestpageone.get(material) - amount);
    }

    public void subFromQuiver(SMaterial material) {
        subFromQuiver(material, 1);
    }

    public void subFromAccessory(SMaterial material) {
        subFromAccessory(material, 1);
    }

    public void subFromPotionbag(SMaterial material) {
        subFromPotionbag(material, 1);
    }

    public void subFromChestPageOne(SMaterial material) {
        subFromChestPageOne(material, 1);
    }

    public boolean hasQuiverItem(SMaterial material) {
        return quiver.containsKey(material);
    }

    public boolean hasAccessoryItem(SMaterial material) {
        return accessory.containsKey(material);
    }
    public boolean hasPotionbagItem(SMaterial material) {
        return potionbag.containsKey(material);
    }
    public boolean hasChestPageOneItem(SMaterial material) {
        return chestpageone.containsKey(material);
    }

    public void clearQuiver() {
        quiver.clear();
    }
    public void clearAccessory() {
        accessory.clear();
    }
    public void clearPotionBag() {
        potionbag.clear();
    }
    public void clearChestPageOne() {
        chestpageone.clear();
    }

    public void addPet(SItem item) {
        pets.add(new Pet.PetItem(item.getType(), item.getRarity(), item.getData().getDouble("xp")));
    }

    public void equipPet(Pet.PetItem pet) {
        for (Pet.PetItem p : pets) {
            if (p.isActive()) {
                p.setActive(false);
                break;
            }
        }
        pet.setActive(true);
    }



    public void removePet(Pet.PetItem pet) {
        for (Iterator<Pet.PetItem> iter = pets.iterator(); iter.hasNext(); ) {
            Pet.PetItem p = iter.next();
            if (pet.equals(p)) {
                iter.remove();
                break;
            }
        }
    }

    public Pet.PetItem getActivePet() {
        for (Pet.PetItem pet : pets) {
            if (pet.isActive())
                return pet;
        }
        return null;
    }

    public Pet getActivePetClass() {
        Pet.PetItem item = getActivePet();
        if (item == null) return null;
        return (Pet) item.getType().getGenericInstance();
    }

    public double getSkillXP(Skill skill) {
        if (skill instanceof FarmingSkill)
            return farmingXP;
        if (skill instanceof MiningSkill)
            return miningXP;
        if (skill instanceof CombatSkill)
            return combatXP;
        if (skill instanceof ForagingSkill)
            return foragingXP;
        return 0.0;
    }

    public void setSkillXP(Skill skill, double xp) {
        double prev = 0.0;
        if (skill instanceof FarmingSkill) {
            prev = this.farmingXP;
            this.farmingXP = xp;
        }
        if (skill instanceof MiningSkill) {
            prev = this.miningXP;
            this.miningXP = xp;
        }
        if (skill instanceof CombatSkill) {
            prev = this.combatXP;
            this.combatXP = xp;
        }
        if (skill instanceof ForagingSkill) {
            prev = this.foragingXP;
            this.foragingXP = xp;
        }
        skill.onSkillUpdate(this, prev);
    }

    public void addSkillXP(Skill skill, double xp) {
        setSkillXP(skill, getSkillXP(skill) + xp);
    }

    public int getHighestRevenantHorror() {
        return highestSlayers[0];
    }

    public void setHighestRevenantHorror(int tier) {
        highestSlayers[0] = tier;
    }

    public int getHighestTarantulaBroodfather() {
        return highestSlayers[1];
    }

    public void setHighestTarantulaBroodfather(int tier) {
        highestSlayers[1] = tier;
    }

    public int getHighestSvenPackmaster() {
        return highestSlayers[2];
    }

    public void setHighestSvenPackmaster(int tier) {
        highestSlayers[2] = tier;
    }

    public int getZombieSlayerXP() {
        return slayerXP[0];
    }

    public void setZombieSlayerXP(int xp) {
        slayerXP[0] = xp;
    }

    public int getSpiderSlayerXP() {
        return slayerXP[1];
    }

    public void setSpiderSlayerXP(int xp) {
        slayerXP[1] = xp;
    }

    public int getWolfSlayerXP() {
        return slayerXP[2];
    }

    public void setWolfSlayerXP(int xp) {
        slayerXP[2] = xp;
    }

    public void setSlayerXP(SlayerBossType.SlayerMobType type, int xp) {
        slayerXP[type.ordinal()] = xp;
    }

    public int getSlayerXP(SlayerBossType.SlayerMobType type) {
        return slayerXP[type.ordinal()];
    }


    public int getSlayerCombatXPBuff() {
        int buff = 0;
        for (int highest : highestSlayers)
            buff += (highest == 4 ? 5 : highest);
        return buff;
    }

    public void startSlayerQuest(SlayerBossType type) {
        Player player = Bukkit.getPlayer(uuid);
        if (player == null) return;
        this.slayerQuest = new SlayerQuest(type, System.currentTimeMillis());
        player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1f, 2f);
        player.sendMessage("  " + ChatColor.DARK_PURPLE + ChatColor.BOLD + "SLAYER QUEST STARTED!");
        player.sendMessage("   " + ChatColor.DARK_PURPLE + ChatColor.BOLD + "→ " + ChatColor.GRAY + "Slay " + ChatColor.RED +
                SUtil.commaify(type.getSpawnXP()) + " Combat XP" + ChatColor.GRAY + " worth of " + type.getType().getPluralName() + ".");
    }

    public void failSlayerQuest() {
        if (slayerQuest == null) return;
        if (slayerQuest.getDied() != 0) return;
        Player player = Bukkit.getPlayer(uuid);
        if (player == null) return;
        slayerQuest.setDied(System.currentTimeMillis());
        if (slayerQuest.getEntity() != null) {
            slayerQuest.getEntity().remove();
            slayerQuest.getEntity().getFunction().onDeath(slayerQuest.getEntity(), slayerQuest.getEntity().getEntity(), player);
        }
        SUtil.delay(() ->
        {
            player.sendMessage("  " + ChatColor.RED + ChatColor.BOLD + "SLAYER QUEST FAILED!");
            player.sendMessage("   " + ChatColor.DARK_PURPLE + ChatColor.BOLD + "→ " + ChatColor.GRAY +
                    "You died! What a noob!");
        }, 2);
    }

    public void send(String message) {
        Player player = Bukkit.getPlayer(uuid);
        if (player == null) return;
        player.sendMessage(message);
    }

    // this deals TRUE TRUE damage
    public void damageEntity(LivingEntity entity, double damage) {
        Player player = Bukkit.getPlayer(uuid);
        if (player == null) return;
        entity.damage(0.00001);
        PlayerUtils.handleSpecEntity(entity, player, new AtomicDouble(damage));
        entity.setHealth(Math.max(0.0, entity.getHealth() - damage));
    }

    public void damageEntity(LivingEntity entity) {
        Player player = Bukkit.getPlayer(uuid);
        if (player == null) return;
        entity.damage(0.0, player);
    }

    public void damage(double d, EntityDamageEvent.DamageCause cause, Entity entity) {
        Player player = Bukkit.getPlayer(uuid);
        if (player == null) return;
        if (player.getGameMode() == GameMode.CREATIVE || player.getGameMode() == GameMode.SPECTATOR) return;
        EntityHuman human = ((CraftHumanEntity) player).getHandle();
        PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(player.getUniqueId());
        double trueDefense = statistics.getTrueDefense().addAll();
        d = d - (d * (trueDefense / (trueDefense + 100)));
        if ((player.getHealth() + human.getAbsorptionHearts()) - d <= 0.0) {
            kill(cause, entity);
            return;
        }
        float ab = (float) Math.max(0.0, human.getAbsorptionHearts() - d);
        double actual = Math.max(0.0, d - human.getAbsorptionHearts());
        human.setAbsorptionHearts(ab);
        player.setHealth(Math.max(0.0, player.getHealth() - actual));
    }

    public void damage(double d) {
        damage(d, EntityDamageEvent.DamageCause.CUSTOM, null);
    }

    public void kill(EntityDamageEvent.DamageCause cause, Entity entity) {
        Player player = Bukkit.getPlayer(uuid);
        if (player == null) return;
        player.setHealth(player.getMaxHealth());
        for (int i = 0; i < player.getInventory().getSize(); i++) {
            ItemStack stack = player.getInventory().getItem(i);
            SItem sItem = SItem.find(stack);
            if (sItem == null) continue;
            if (sItem.getType() == SMaterial.REMNANT_OF_THE_EYE && (lastRegion.getType() == RegionType.THE_END || lastRegion.getType() == RegionType.DRAGONS_NEST)) {
                player.getInventory().setItem(i, new ItemStack(Material.AIR));
                if (cause == EntityDamageEvent.DamageCause.VOID)
                    sendToSpawn();
                player.sendMessage(ChatColor.DARK_PURPLE + "Your Remnant of the Eye saved you from certain death!");
                return;
            }
        }
        player.setVelocity(new Vector(0, 0, 0));
        player.setFallDistance(0.0f);
        sendToSpawn();
        clearPotionEffects();
        String name = null;
        if (entity != null) {
            SEntity sEntity = SEntity.findSEntity(entity);
            name = sEntity != null ? sEntity.getStatistics().getEntityName() : entity.getCustomName();
        }
        String message = "You died.";
        String out = "%s died.";
        switch (cause) {
            case VOID: {
                message = "You fell into the void.";
                out = "%s fell into the void.";
                break;
            }
            case FALL: {
                message = "You fell to your death.";
                out = "%s fell to their death.";
                break;
            }
            case ENTITY_ATTACK: {
                message = "You were killed by " + name + ChatColor.GRAY + ".";
                out = "%s was killed by " + name + ChatColor.GRAY + ".";
                break;
            }
            case ENTITY_EXPLOSION: {
                message = "You were killed by " + name + ChatColor.GRAY + "'s explosion.";
                out = "%s was killed by " + name + ChatColor.GRAY + "'s explosion.";
                break;
            }
            case FIRE:
            case LAVA: {
                message = "You burned to death.";
                out = "%s burned to death.";
                break;
            }
            case MAGIC: {
                message = "You died by magic.";
                out = "%s was killed by magic.";
                break;
            }
            case POISON: {
                message = "You died by poisoning.";
                out = "%s was killed by poisoning.";
                break;
            }
            case LIGHTNING: {
                message = "You were struck by lightning and died.";
                out = "%s was struck by lightning and killed.";
                break;
            }
        }
        if (slayerQuest != null && slayerQuest.getKilled() == 0)
            failSlayerQuest();
        player.playSound(player.getLocation(), Sound.HURT_FLESH, 1f, 1f);
        player.sendMessage(ChatColor.RED + " ☠ " + ChatColor.GRAY + message);
        SUtil.broadcastExcept(ChatColor.RED + " ☠ " + ChatColor.GRAY + String.format(out, player.getName()), player);
        if ((isOnIsland() && cause == EntityDamageEvent.DamageCause.VOID) || permanentCoins)
            return;
        if (player.getWorld().getName().startsWith("Dungeon_"))
            return;
        int piggyIndex = PlayerUtils.getSpecItemIndex(player, SMaterial.PIGGY_BANK);
        if (piggyIndex != -1 && coins >= 20000) {
            SItem cracked = SItem.of(SMaterial.CRACKED_PIGGY_BANK);
            SItem piggy = SItem.find(player.getInventory().getItem(piggyIndex));
            if (piggy.getReforge() != null)
                cracked.setReforge(piggy.getReforge());
            player.getInventory().setItem(piggyIndex, cracked.getStack());
            player.sendMessage(ChatColor.RED + "You died and your piggy bank cracked!");
            return;
        }
        player.playSound(player.getLocation(), Sound.ZOMBIE_METAL, 1f, 2f);
        int crackedPiggyIndex = PlayerUtils.getSpecItemIndex(player, SMaterial.CRACKED_PIGGY_BANK);
        if (crackedPiggyIndex != -1 && coins >= 20000) {
            SItem broken = SItem.of(SMaterial.BROKEN_PIGGY_BANK);
            SItem crackedPiggy = SItem.find(player.getInventory().getItem(crackedPiggyIndex));
            if (crackedPiggy.getReforge() != null)
                broken.setReforge(crackedPiggy.getReforge());
            player.getInventory().setItem(crackedPiggyIndex, broken.getStack());
            long sub = (long) (coins * 0.25);
            player.sendMessage(ChatColor.RED + "You died, lost " + SUtil.commaify(sub) + " coins, and your piggy bank broke!");
            coins -= sub;
            save();
            return;
        }
        long sub = coins / 2;
        player.sendMessage(ChatColor.RED + "You died and lost " + SUtil.commaify(sub) + " coins!");
        coins -= sub;
        save();
    }

    public void addPotionEffect(PotionEffect effect) {
        effects.add(new ActivePotionEffect(effect, effect.getDuration()));
    }

    public void removePotionEffect(PotionEffectType type) {
        for (ActivePotionEffect effect : effects) {
            if (effect.getEffect().getType() == type)
                effect.setRemaining(0);
        }
    }

    public ActivePotionEffect getPotionEffect(PotionEffectType type) {
        for (ActivePotionEffect effect : effects) {
            if (effect.getEffect().getType() == type)
                return effect;
        }
        return null;
    }

    public boolean hasPotionEffect(PotionEffectType type) {
        return effects.stream().filter(effect -> effect.getEffect().getType() == type).toArray().length != 0;
    }

    public void clearPotionEffects() // this kind of "sets them up" to be cleared rather than actually clearing them
    {
        Player player = Bukkit.getPlayer(uuid);
        if (player != null) {
            for (org.bukkit.potion.PotionEffect effect : player.getActivePotionEffects())
                player.removePotionEffect(effect.getType());
        }
        for (ActivePotionEffect effect : effects)
            effect.setRemaining(0);
    }

    public boolean isOnIsland() {
        Player player = Bukkit.getPlayer(uuid);
        if (player == null) {
            return false;
        }
        World world = Bukkit.getWorld("islands");
        if (world == null)
            return false;
        User user = User.getUser(player.getUniqueId());
        double x = player.getLocation().getX();
        double z = player.getLocation().getZ();
        if (islandX == null && islandZ == null) return false;
        Location loc1 = new Location(world, islandX, 100, islandZ);
        loc1.add(100, 100, 100);
        Location loc2 = new Location(world, islandX, 100, islandZ);
        loc2.subtract(100, 100, 100);
        Cuboid cuboid = new Cuboid(loc1, loc2);
        return cuboid.contains(player.getLocation());
    }

    public boolean isOnUserIsland() {
        Player player = Bukkit.getPlayer(uuid);
        if (player == null)
            return false;
        World world = Bukkit.getWorld("islands");
        if (world == null)
            return false;
        User user = User.getUser(player.getUniqueId());
        double x = player.getLocation().getX();
        double z = player.getLocation().getZ();
        Location loc1 = new Location(world, islandX, 100, islandZ);
        loc1.add(100, 100, 100);
        Location loc2 = new Location(world, islandX, 100, islandZ);
        loc2.subtract(100, 100, 100);
        Cuboid cuboid = new Cuboid(loc1, loc2);
        return !cuboid.contains(player.getLocation());
    }

    public boolean isOnIsland(Block block) {
        return isOnIsland(block.getLocation());
    }

    public boolean isOnIsland(Location location) {
        Player player = Bukkit.getPlayer(uuid);
        World world = Bukkit.getWorld("islands");
        if (world == null)
            return false;
        double x = location.getX();
        double z = location.getZ();
        return world.getUID().equals(location.getWorld().getUID());
    }


    public List<AuctionItem> getBids() {
        return AuctionItem.getAuctions().stream().filter((item) ->
        {
            for (AuctionBid bid : item.getBids()) {
                if (bid.getBidder().equals(uuid) && item.getParticipants().contains(uuid))
                    return true;
            }
            return false;
        }).collect(Collectors.toList());
    }

    public List<AuctionItem> getAuctions() {
        return AuctionItem.getAuctions().stream().filter((item) -> item.getOwner().getUuid().equals(uuid) && item.getParticipants().contains(uuid)).collect(Collectors.toList());
    }

    public void sendToSpawn() {
        Player player = Bukkit.getPlayer(uuid);
        World w1 = Bukkit.getWorld("world");
        if (player == null) return;
        if (player.getWorld() == Bukkit.getWorld("islands")) {
            World world = Bukkit.getWorld("islands");
            player.teleport(world.getHighestBlockAt(SUtil.blackMagic(islandX),
                    SUtil.blackMagic(islandZ)).getLocation().add(0.5, 1.0, 0.5));
        }
        if (player.getWorld().getName().startsWith("Dungeon_")){
            player.teleport(new Location(Bukkit.getWorld("Dungeon_" + player.getUniqueId()) , 2 , 100 , -1));
        }

        else {
            if (lastRegion != null) {
                switch (lastRegion.getType()) {
                    case BANK:
                    case FARM:
                    case RUINS:
                    case FOREST:
                    case LIBRARY:
                    case COAL_MINE:
                    case COAL_MINE_CAVES:
                    case MOUNTAIN:
                    case VILLAGE:
                    case HIGH_LEVEL:
                    case BLACKSMITH:
                    case AUCTION_HOUSE:
                    case WILDERNESS:
                    case BAZAAR_ALLEY:
                    case COLOSSEUM:
                    case GRAVEYARD:
                        player.teleport(new Location(w1, -101, 71, -56));
                        break;
                    case GOLD_MINE:
                        player.teleport(new Location(player.getWorld(), -4.5, 74.0, -272.5, 180.0f, 0.0f));
                        break;
                    case DEEP_CAVERN:
                    case GUNPOWDER_MINES:
                    case LAPIS_QUARRY:
                    case PIGMENS_DEN:
                    case SLIMEHILL:
                    case DIAMOND_RESERVE:
                    case OBSIDIAN_SANCTUARY:
                        player.teleport(new Location(player.getWorld(), -4.0, 157.0, -490.5, 180.0f, 0.0f));
                        break;
                    case THE_END:
                    case THE_END_NEST:
                    case DRAGONS_NEST:
                        player.teleport(new Location(player.getWorld(), -498.5, 101.0, -275.0, 90.0f, 0.0f));
                        break;
                    case SPIDERS_DEN:
                    case SPIDERS_DEN_HIVE:
                        player.teleport(new Location(player.getWorld(), -200.5, 84.0, -231.5, 130.0f, 0.0f));
                        break;
                    case BIRCH_PARK:
                    case SPRUCE_WOODS:
                    case DARK_THICKET:
                    case SAVANNA_WOODLAND:
                    case JUNGLE_ISLAND:
                        player.teleport(new Location(player.getWorld(), -276.5, 82.0, -13.5, 90.0f, 0.0f));
                        break;
                    case HOWLING_CAVE:
                        player.teleport(new Location(player.getWorld(), -331.5, 90.0, -55.5, 100.0f, 25.0f));
                        break;
                    case BLAZING_FORTRESS:
                        player.teleport(new Location(player.getWorld(), -310.0, 83.0, -379.5, -180.0f, 0.0f));
                        break;
                    default:
                        player.teleport(player.getWorld().getSpawnLocation());
                        break;
                }
            } else
                player.teleport(player.getWorld().getSpawnLocation());
        }
    }





    public static User getUser(UUID uuid) {
        if (uuid == null) return null;
        if (USER_CACHE.containsKey(uuid)) return USER_CACHE.get(uuid);
        return new User(uuid);
    }

    public static Collection<User> getCachedUsers() {
        return USER_CACHE.values();
    }

}