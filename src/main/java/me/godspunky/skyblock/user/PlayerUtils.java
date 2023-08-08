package me.godspunky.skyblock.user;

import com.google.common.util.concurrent.AtomicDouble;
import me.godspunky.skyblock.Repeater;
import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.config.Config;
import me.godspunky.skyblock.features.enchantment.Enchantment;
import me.godspunky.skyblock.features.enchantment.EnchantmentType;
import me.godspunky.skyblock.features.entity.EntityDrop;
import me.godspunky.skyblock.features.entity.EntityDropType;
import me.godspunky.skyblock.features.entity.EntityFunction;
import me.godspunky.skyblock.features.entity.SEntity;
import me.godspunky.skyblock.features.entity.nms.SlayerBoss;
import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.accessory.AccessoryFunction;
import me.godspunky.skyblock.features.item.armor.ArmorSet;
import me.godspunky.skyblock.features.item.armor.ender.EnderSet;
import me.godspunky.skyblock.features.item.pet.Pet;
import me.godspunky.skyblock.features.potion.ActivePotionEffect;
import me.godspunky.skyblock.features.potion.PotionEffectType;
import me.godspunky.skyblock.features.reforge.Reforge;
import me.godspunky.skyblock.features.region.Region;
import me.godspunky.skyblock.features.region.RegionType;
import me.godspunky.skyblock.features.skill.CombatSkill;
import me.godspunky.skyblock.features.skill.Skill;
import me.godspunky.skyblock.features.slayer.SlayerQuest;
import me.godspunky.skyblock.util.BlankWorldCreator;
import me.godspunky.skyblock.util.DefenseReplacement;
import me.godspunky.skyblock.util.Groups;
import me.godspunky.skyblock.util.SUtil;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.util.*;

public final class PlayerUtils {

    public static Skyblock skyblock;

    public static final Map<UUID, PlayerStatistics> STATISTICS_CACHE = new HashMap<>();

    private static final Map<UUID, List<SMaterial>> COOLDOWN_MAP = new HashMap<>();

    public static PlayerStatistics getStatistics(Player player) {
        PlayerInventory inv = player.getInventory();
        SItem helmet = SItem.find(inv.getHelmet());
        SItem chestplate = SItem.find(inv.getChestplate());
        SItem leggings = SItem.find(inv.getLeggings());
        SItem boots = SItem.find(inv.getBoots());
        SItem hand = SItem.find(inv.getItemInHand());
        List<SItem> items = Arrays.asList(helmet, chestplate, leggings, boots);

        PlayerStatistics statistics = PlayerStatistics.blank(player.getUniqueId());

        for (int i = 0; i < items.size(); i++) {
            SItem sItem = items.get(i);
            updateArmorStatistics(sItem, statistics, i);
        }

        updateSetStatistics(player, helmet, chestplate, leggings, boots, statistics);
        updateHandStatistics(hand, statistics);
        updatePetStatistics(statistics);
        updateInventoryStatistics(player, statistics);

        return statistics;
    }

    public static PlayerStatistics updateHandStatistics(SItem hand, PlayerStatistics statistics) {
        double hpbwea = 0.0;
        double a = 0.0;
        Player player = Bukkit.getPlayer(statistics.getUuid());
        User user = User.getUser(player.getUniqueId());
        Pet.PetItem active = user.getActivePet();
        int level = 0;
        Pet pet = (Pet) SMaterial.GUNGA_PET.getGenericInstance();
        DoublePlayerStatistic strength = statistics.getStrength();
        DoublePlayerStatistic intelligence = statistics.getIntelligence();
        DoublePlayerStatistic speed = statistics.getSpeed();
        DoublePlayerStatistic critChance = statistics.getCritChance();
        DoublePlayerStatistic critDamage = statistics.getCritDamage();
        DoublePlayerStatistic ferocity = statistics.getFerocity();
        DoublePlayerStatistic magicFind = statistics.getMagicFind();
        DoublePlayerStatistic defense = statistics.getDefense();
        DoublePlayerStatistic trueDefense = statistics.getTrueDefense();
        statistics.zeroAll(4);
        if (hand != null && hand.getType().getStatistics().getType() != GenericItemType.ARMOR && hand.getType().getStatistics().getType() != GenericItemType.ACCESSORY) {
            Reforge reforge = hand.getReforge() == null ? Reforge.blank() : hand.getReforge();
            strength.set(4, reforge.getStrength().getForRarity(hand.getRarity()));
            critDamage.set(4, reforge.getCritDamage().getForRarity(hand.getRarity()));
            critChance.set(4, reforge.getCritChance().getForRarity(hand.getRarity()));
            intelligence.set(4, reforge.getIntelligence().getForRarity(hand.getRarity()));
            PlayerBoostStatistics handStatistics = hand.getType().getBoostStatistics();
            if (handStatistics != null) {
                strength.add(4, handStatistics.getBaseStrength());
                critDamage.add(4, handStatistics.getBaseCritDamage());
                critChance.add(4, handStatistics.getBaseCritChance());
                intelligence.add(4, handStatistics.getBaseIntelligence());
            }
        } else {
            strength.zero(4);
            intelligence.zero(4);
            critChance.zero(4);
            critDamage.zero(4);
            intelligence.zero(4);
            speed.zero(4);
            ferocity.zero(4);
        }

        if (hand != null && hand.getEnchantment(EnchantmentType.CHIMERA) != null) {
            double lvl = hand.getEnchantment(EnchantmentType.CHIMERA).getLevel();
            if (active != null) {
                level = Pet.getLevel(active.getXp(), active.getRarity());
                pet = (Pet) active.getType().getGenericInstance();
                a = 20.0 * lvl / 100.0;
            }
        }
        if (hand != null && hand.getDataInt("hpb") > 0) {
            hpbwea = hand.getDataInt("hpb") * 2;
        }
        strength.add(4, hpbwea);


        defense.add(4, a * (pet.getPerDefense() * (double) level));
        strength.add(4, a * (pet.getPerStrength() * (double) level));
        intelligence.add(4, a * (pet.getPerIntelligence() * (double) level));
        speed.add(4, a * (pet.getPerSpeed() * (double) level));
        critChance.add(4, a * (pet.getPerCritChance() * (double) level));
        critDamage.add(4, a * (pet.getPerCritDamage() * (double) level));
        magicFind.add(4, a * (pet.getPerMagicFind() * (double) level));
        trueDefense.add(4, a * (pet.getPerTrueDefense() * (double) level));
        PlayerUtils.updateHealth(Bukkit.getPlayer(statistics.getUuid()), statistics);
        return statistics;
    }

    public static PlayerStatistics updateArmorStatistics(SItem piece, PlayerStatistics statistics, int slot) {
        DoublePlayerStatistic health = statistics.getMaxHealth(),
                defense = statistics.getDefense(),
                strength = statistics.getStrength(),
                intelligence = statistics.getIntelligence();
        DoublePlayerStatistic speed = statistics.getSpeed(),
                critChance = statistics.getCritChance(), critDamage = statistics.getCritDamage();
        statistics.zeroAll(slot);
        if (piece != null) {
            Reforge reforge = piece.getReforge() == null ? Reforge.blank() : piece.getReforge();
            strength.set(slot, reforge.getStrength().getForRarity(piece.getRarity()));
            critDamage.set(slot, reforge.getCritDamage().getForRarity(piece.getRarity()));
            critChance.set(slot, reforge.getCritChance().getForRarity(piece.getRarity()));
            intelligence.set(slot, reforge.getIntelligence().getForRarity(piece.getRarity()));
            defense.set(slot, reforge.getDefence().getForRarity(piece.getRarity()));
            health.set(slot, reforge.getHealth().getForRarity(piece.getRarity()));
            speed.set(slot, reforge.getSpeed().getForRarity(piece.getRarity()));
            PlayerBoostStatistics pieceStatistics = piece.getType().getBoostStatistics();

            if (pieceStatistics != null)
                addBoostStatistics(statistics, slot, pieceStatistics);

            if (piece.isEnchantable()) {
                for (Enchantment enchantment : piece.getEnchantments()) {
                    if (enchantment.getType() == EnchantmentType.GROWTH)
                        health.add(slot, 15.0 * enchantment.getLevel());
                }
            }
            TickingMaterial tickingMaterial = piece.getType().getTickingInstance();
            if (tickingMaterial != null)
                statistics.tickItem(slot, tickingMaterial.getInterval(), () -> tickingMaterial.tick(piece, Bukkit.getPlayer(statistics.getUuid())));
        }
        updateHealth(Bukkit.getPlayer(statistics.getUuid()), statistics);
        return statistics;
    }

    public static PlayerStatistics updatePetStatistics(PlayerStatistics statistics) {
        Player player = Bukkit.getPlayer(statistics.getUuid());
        User user = User.getUser(player.getUniqueId());
        Pet.PetItem active = user.getActivePet();
        DoublePlayerStatistic health = statistics.getMaxHealth(),
                defense = statistics.getDefense(),
                strength = statistics.getStrength(),
                intelligence = statistics.getIntelligence();
        DoublePlayerStatistic speed = statistics.getSpeed(),
                critChance = statistics.getCritChance(), critDamage = statistics.getCritDamage(),
                magicFind = statistics.getMagicFind(), trueDefense = statistics.getTrueDefense();
        if (active != null) {
            int level = Pet.getLevel(active.getXp(), active.getRarity());
            Pet pet = (Pet) active.getType().getGenericInstance();
            health.set(PlayerStatistic.PET, pet.getPerHealth() * level);
            defense.set(PlayerStatistic.PET, pet.getPerDefense() * level);
            strength.set(PlayerStatistic.PET, pet.getPerStrength() * level);
            intelligence.set(PlayerStatistic.PET, pet.getPerIntelligence() * level);
            speed.set(PlayerStatistic.PET, pet.getPerSpeed() * level);
            critChance.set(PlayerStatistic.PET, pet.getPerCritChance() * level);
            critDamage.set(PlayerStatistic.PET, pet.getPerCritDamage() * level);
            magicFind.set(PlayerStatistic.PET, pet.getPerMagicFind() * level);
            trueDefense.set(PlayerStatistic.PET, pet.getPerTrueDefense() * level);
        } else
            statistics.zeroAll(PlayerStatistic.PET);
        updateHealth(player, statistics);
        return statistics;
    }

    public static PlayerStatistics updateSetStatistics(Player player, SItem helmet, SItem chestplate, SItem leggings, SItem boots, PlayerStatistics statistics) {
        DoublePlayerStatistic health = statistics.getMaxHealth(),
                defense = statistics.getDefense(),
                strength = statistics.getStrength(),
                intelligence = statistics.getIntelligence();
        DoublePlayerStatistic speed = statistics.getSpeed(),
                critChance = statistics.getCritChance(), critDamage = statistics.getCritDamage(),
                magicFind = statistics.getMagicFind();
        if (helmet != null && chestplate != null && leggings != null && boots != null) {
            ArmorSet set = SMaterial.findArmorSet(helmet.getType(),
                    chestplate.getType(),
                    leggings.getType(),
                    boots.getType());
            statistics.setArmorSet(set);
            if (set != null) {
                PlayerBoostStatistics boost = set.whileHasFullSet(player);
                if (boost != null) {
                    health.set(PlayerStatistic.SET, boost.getBaseHealth());
                    defense.set(PlayerStatistic.SET, boost.getBaseDefense());
                    strength.set(PlayerStatistic.SET, boost.getBaseStrength());
                    intelligence.set(PlayerStatistic.SET, boost.getBaseIntelligence());
                    speed.set(PlayerStatistic.SET, boost.getBaseSpeed());
                    critChance.set(PlayerStatistic.SET, boost.getBaseCritChance());
                    critDamage.set(PlayerStatistic.SET, boost.getBaseCritDamage());
                    magicFind.set(PlayerStatistic.SET, boost.getBaseMagicFind());
                }
            }
            User user = User.getUser(statistics.getUuid());
            Region region = Region.getRegionOfEntity(player);
            if (set instanceof EnderSet && region.getType() == RegionType.THE_END) {
                double health1 = statistics.getMaxHealth().addAll();
                double defense1 = statistics.getDefense().addAll();
                double strength1 = statistics.getStrength().addAll();
                double intelligence1 = statistics.getIntelligence().addAll();
                double speed1 = statistics.getSpeed().addAll();
                double critChance1 = statistics.getCritChance().addAll();
                double critDamage1 = statistics.getCritDamage().addAll();
                double magicFind1 = statistics.getMagicFind().addAll();
                double trueDefense1 = statistics.getTrueDefense().addAll();
                defense.add(5, defense1);
                health.add(5 , health1);
                strength.add(5, strength1);
                intelligence.add(5, intelligence1);
                speed.add(5, speed1);
                critChance.add(5, critChance1);
                critDamage.add(5, critDamage1);
                magicFind.add(5, magicFind1);
            }


        } else {
            statistics.setArmorSet(null);
            health.zero(PlayerStatistic.SET);
            defense.zero(PlayerStatistic.SET);
            strength.zero(PlayerStatistic.SET);
            intelligence.zero(PlayerStatistic.SET);
            speed.zero(PlayerStatistic.SET);
            critChance.zero(PlayerStatistic.SET);
            critDamage.zero(PlayerStatistic.SET);
            magicFind.zero(PlayerStatistic.SET);
        }
        updateHealth(player, statistics);
        return statistics;
    }

    public static PlayerStatistics updateInventoryStatistics(Player player, PlayerStatistics statistics) {
        DoublePlayerStatistic health = statistics.getMaxHealth(),
                defense = statistics.getDefense(),
                strength = statistics.getStrength(),
                intelligence = statistics.getIntelligence();
        DoublePlayerStatistic speed = statistics.getSpeed(),
                critChance = statistics.getCritChance(), critDamage = statistics.getCritDamage(),
                magicFind = statistics.getMagicFind();
        PlayerInventory inventory = player.getInventory();
        List<SMaterial> materials = new ArrayList<>();
        for (int i = 0; i < inventory.getSize(); i++) {
            ItemStack stack = inventory.getItem(i);
            SItem sItem = SItem.find(stack);
            int slot = PlayerStatistic.ADD_FOR_INVENTORY + i;
            if (sItem != null) {
                if (materials.contains(sItem.getType())) continue;
                if (sItem.getType().getStatistics().getType() != GenericItemType.ACCESSORY) continue;
                materials.add(sItem.getType());
                if (sItem.getType().getFunction() instanceof AccessoryFunction)
                    ((AccessoryFunction) sItem.getType().getFunction()).update(sItem, player, slot);
            }
            statistics.zeroAll(slot);
            if (sItem == null)
                continue;
            Reforge reforge = sItem.getReforge() == null ? Reforge.blank() : sItem.getReforge();
            strength.set(slot, reforge.getStrength().getForRarity(sItem.getRarity()));
            critDamage.set(slot, reforge.getCritDamage().getForRarity(sItem.getRarity()));
            critChance.set(slot, reforge.getCritChance().getForRarity(sItem.getRarity()));
            intelligence.set(slot, reforge.getIntelligence().getForRarity(sItem.getRarity()));
            defense.set(slot, reforge.getDefence().getForRarity(sItem.getRarity()));
            health.set(slot, reforge.getHealth().getForRarity(sItem.getRarity()));
            speed.set(slot, reforge.getSpeed().getForRarity(sItem.getRarity()));
            PlayerBoostStatistics sItemStatistics = sItem.getType().getBoostStatistics();
            if (sItemStatistics != null)
                addBoostStatistics(statistics, slot, sItemStatistics);
        }
        updateHealth(player, statistics);
        return statistics;
    }

    public static PlayerStatistics updatePotionEffects(User user, PlayerStatistics statistics) {
        DoublePlayerStatistic health = statistics.getMaxHealth(),
                defense = statistics.getDefense(),
                strength = statistics.getStrength(),
                intelligence = statistics.getIntelligence();
        DoublePlayerStatistic speed = statistics.getSpeed(),
                critChance = statistics.getCritChance(), critDamage = statistics.getCritDamage(),
                magicFind = statistics.getMagicFind();
        for (int i = 0; i < user.getEffects().size(); i++) {
            ActivePotionEffect effect = user.getEffects().get(i);
            int slot = PlayerStatistic.ADD_FOR_POTION_EFFECTS + i;
            health.zero(slot);
            defense.zero(slot);
            strength.zero(slot);
            intelligence.zero(slot);
            speed.zero(slot);
            critChance.zero(slot);
            critDamage.zero(slot);
            magicFind.zero(slot);
            if (!effect.getEffect().getType().isInstant()) {
                if (effect.getRemaining() > 0 && effect.getEffect().getType().getStatsUpdate() != null)
                    effect.getEffect().getType().getStatsUpdate().accept(statistics, slot, effect.getEffect().getLevel());
            } else
                effect.setRemaining(0);
        }
        user.getEffects().removeIf(effect -> effect.getRemaining() <= 0);
        return statistics;
    }

    public static PlayerStatistics boostPlayer(PlayerStatistics statistics, PlayerBoostStatistics boostStatistics, long ticks) {
        if (statistics == null) return null;
        DoublePlayerStatistic health = statistics.getMaxHealth(),
                defense = statistics.getDefense(),
                strength = statistics.getStrength(),
                intelligence = statistics.getIntelligence();
        DoublePlayerStatistic speed = statistics.getSpeed(),
                critChance = statistics.getCritChance(), critDamage = statistics.getCritDamage(),
                magicFind = statistics.getMagicFind();
        health.add(PlayerStatistic.BOOST, boostStatistics.getBaseHealth());
        defense.add(PlayerStatistic.BOOST, boostStatistics.getBaseDefense());
        strength.add(PlayerStatistic.BOOST, boostStatistics.getBaseStrength());
        intelligence.add(PlayerStatistic.BOOST, boostStatistics.getBaseIntelligence());
        speed.add(PlayerStatistic.BOOST, boostStatistics.getBaseSpeed());
        critChance.add(PlayerStatistic.BOOST, boostStatistics.getBaseCritChance());
        critDamage.add(PlayerStatistic.BOOST, boostStatistics.getBaseCritDamage());
        magicFind.add(PlayerStatistic.BOOST, boostStatistics.getBaseMagicFind());
        updateHealth(Bukkit.getPlayer(statistics.getUuid()), statistics);
        new BukkitRunnable() {
            public void run() {
                health.sub(PlayerStatistic.BOOST, boostStatistics.getBaseHealth());
                defense.sub(PlayerStatistic.BOOST, boostStatistics.getBaseDefense());
                strength.sub(PlayerStatistic.BOOST, boostStatistics.getBaseStrength());
                intelligence.sub(PlayerStatistic.BOOST, boostStatistics.getBaseIntelligence());
                speed.sub(PlayerStatistic.BOOST, boostStatistics.getBaseSpeed());
                critChance.sub(PlayerStatistic.BOOST, boostStatistics.getBaseCritChance());
                critDamage.sub(PlayerStatistic.BOOST, boostStatistics.getBaseCritDamage());
                magicFind.sub(PlayerStatistic.BOOST, boostStatistics.getBaseMagicFind());
                updateHealth(Bukkit.getPlayer(statistics.getUuid()), statistics);
            }
        }.runTaskLater(Skyblock.getPlugin(), ticks);
        return statistics;
    }

    public static DamageResult getDamageDealt(ItemStack weapon, Player player, Entity damaged, boolean arrowHit) {
        int damage = 0;
        double enchantBonus = 0.0;
        double potionBonus = 0.0;
        PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(player.getUniqueId());
        double critDamage = statistics.getCritDamage().addAll();
        SItem sItem = SItem.find(weapon);
        if (sItem != null) {
            if (sItem.getType().getStatistics().getType() != GenericItemType.RANGED_WEAPON || arrowHit) {
                PlayerBoostStatistics playerBoostStatistics = sItem.getType().getBoostStatistics();
                if (playerBoostStatistics != null)
                    damage = playerBoostStatistics.getBaseDamage();
                if (sItem.getType() == SMaterial.EMERALD_BLADE)
                    damage += SUtil.roundTo(2.5 * SUtil.quadrt(User.getUser(player.getUniqueId()).getCoins()), 1);
                if (sItem.getType() != SMaterial.ENCHANTED_BOOK && sItem.isEnchantable()) {
                    for (Enchantment enchantment : sItem.getEnchantments()) {
                        EnchantmentType type = enchantment.getType();
                        int level = enchantment.getLevel();
                        if (type == EnchantmentType.SHARPNESS && !arrowHit)
                            enchantBonus += (double) (level * 5) / 100.0;
                        if (type == EnchantmentType.FIRE_ASPECT && sItem.getType().getStatistics().getType() == GenericItemType.WEAPON)
                            damaged.setFireTicks((2 + level) * 20);
                        if (type == EnchantmentType.POWER && arrowHit)
                            enchantBonus += (double) (level * 8) / 100.0;
                        if (type == EnchantmentType.FLAME && arrowHit)
                            damaged.setFireTicks(level * 3 * 20);
                        if (type == EnchantmentType.SMITE && !arrowHit && Groups.UNDEAD_MOBS.contains(damaged.getType()))
                            enchantBonus += (double) (level * 8) / 100.0;
                        if (type == EnchantmentType.BANE_OF_ARTHROPODS && !arrowHit && Groups.ARTHROPODS.contains(damaged.getType()))
                            enchantBonus += (double) (level * 8) / 100.0;
                        if (type == EnchantmentType.CRITICAL)
                            critDamage += (double) (level * 10) / 100.0;
                    }
                }
                for (ActivePotionEffect effect : User.getUser(player.getUniqueId()).getEffects()) {
                    PotionEffectType type = effect.getEffect().getType();
                    int level = effect.getEffect().getLevel();
                    if (type == PotionEffectType.ARCHERY && arrowHit)
                        potionBonus += SUtil.getOrDefault(Arrays.asList(12.5, 25.0, 50.0, 75.0), level - 1, (level * 25.0) - 25.0) / 100.0;
                }
            }
        }

        int combatLevel = Skill.getLevel(User.getUser(player.getUniqueId()).getCombatXP(), false);
        double weaponBonus = 0.0; // TEMPORARY
        double armorBonus = 1.0; // TEMPORARY
        int critChanceMul = (int) (statistics.getCritChance().addAll() * 100);
        int chance = SUtil.random(0, 100);
        if (chance > critChanceMul)
            critDamage = 0.0;

        double baseDamage = (5 + damage +
                ((double) statistics.getStrength().addAll() / 5.0)) * (1 + ((double) statistics.getStrength().addAll() / 100.0));

        double damageMultiplier = 1 + (combatLevel * 0.04) + enchantBonus + weaponBonus;
        double finalCritDamage = critDamage;
        double finalDamage = baseDamage * damageMultiplier * armorBonus * (1 + finalCritDamage);
        double finalPotionBonus = potionBonus;
        return new DamageResult() {
            @Override
            public double getFinalDamage() {
                return finalDamage + (finalDamage * finalPotionBonus);
            }

            @Override
            public boolean didCritDamage() {
                return finalCritDamage != 0.0;
            }
        };
    }

    public static void useAbility(Player player, SItem sItem) {
        Ability ability = sItem.getType().getAbility();
        if (ability != null) {
            AbilityActivation activation = ability.getAbilityActivation();
            if (activation != AbilityActivation.NO_ACTIVATION) {
                UUID uuid = player.getUniqueId();
                if (COOLDOWN_MAP.containsKey(uuid) && COOLDOWN_MAP.get(uuid).contains(sItem.getType()))
                    player.sendMessage(ChatColor.RED + "You currently have a cooldown for this ability!");
                else {
                    int mana = Repeater.MANA_MAP.get(uuid);
                    int cost = getFinalManaCost(player, sItem, ability.getManaCost());
                    int resMana = mana - cost;
                    if (resMana >= 0) {
                        Repeater.MANA_MAP.remove(uuid);
                        Repeater.MANA_MAP.put(uuid, resMana);
                        try {
                            ability.onAbilityUse(player, sItem);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        if (ability.displayUsage()) {
                            long c = System.currentTimeMillis();
                            Repeater.DEFENSE_REPLACEMENT_MAP.put(player.getUniqueId(), new DefenseReplacement() {
                                @Override
                                public String getReplacement() {
                                    return ChatColor.AQUA + "-" + cost + " Mana (" + ChatColor.GOLD + ability.getAbilityName() + ChatColor.AQUA + ")";
                                }

                                @Override
                                public long getEnd() {
                                    return c + 4000;
                                }
                            });
                        }
                        if (ability.getAbilityCooldownTicks() != 0) {
                            if (COOLDOWN_MAP.containsKey(uuid))
                                COOLDOWN_MAP.get(uuid).add(sItem.getType());
                            else
                                COOLDOWN_MAP.put(uuid, new ArrayList<>(Arrays.asList(sItem.getType())));
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    COOLDOWN_MAP.get(uuid).remove(sItem.getType());
                                    if (COOLDOWN_MAP.get(uuid).size() == 0)
                                        COOLDOWN_MAP.remove(uuid);
                                }
                            }.runTaskLater(Skyblock.getPlugin(), ability.getAbilityCooldownTicks());
                        }
                    } else {
                        player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, -4f);
                        player.sendMessage(ChatColor.RED + "You don't have enough mana!");
                    }
                }
            }
        }
    }

    public static void updateHealth(Player player, PlayerStatistics statistics) {
        if (player == null) return;
        boolean fill = player.getHealth() == player.getMaxHealth();
        player.setMaxHealth(statistics.getMaxHealth().addAll());
        if (fill)
            player.setHealth(player.getMaxHealth());
    }

    public static List<SItem> getAccessories(Player player) {
        List<SItem> accessories = new ArrayList<>();
        List<SMaterial> types = new ArrayList<>();
        for (ItemStack stack : player.getInventory()) {
            SItem sItem = SItem.find(stack);
            if (sItem == null) continue;
            if (sItem.getType().getStatistics().getType() != GenericItemType.ACCESSORY) continue;
            if (types.contains(sItem.getType())) continue;
            accessories.add(sItem);
            types.add(sItem.getType());
        }
        return accessories;
    }

    public static boolean hasItem(Player player, SMaterial material) {
        for (ItemStack stack : player.getInventory()) {
            SItem sItem = SItem.find(stack);
            if (sItem == null) continue;
            if (sItem.getType() == material)
                return true;
        }
        return false;
    }


    public static void sendToIsland(Player player) {
        World world = Bukkit.getWorld("islands");
        if (world == null)
            world = new BlankWorldCreator("islands").createWorld();
        User user = User.getUser(player.getUniqueId());
        if (user.getIslandX() == null) {
            Config config = Skyblock.getPlugin().config;

            double xOffset = config.getDouble("islands.x");
            double zOffset = config.getDouble("islands.z");
            if (xOffset < -25000000.0 || xOffset > 25000000.0)
                zOffset += User.ISLAND_SIZE * 2.0;
            File file = new File("plugins/GodSpunkySkyblockCore/private_island.schematic");
            SUtil.pasteSchematic(file, new Location(world, 7.0 + xOffset, 100.0, 7.0 + zOffset), true);
            SUtil.setBlocks(new Location(world, 7.0 + xOffset, 104.0, 43.0 + zOffset),
                    new Location(world, 5.0 + xOffset, 100.0, 43.0 + zOffset), Material.PORTAL, false);
            user.setIslandLocation(7.5 + xOffset, 7.5 + zOffset);
            user.save();
            if (xOffset > 0)
                xOffset = xOffset * -1.0;
            else if (xOffset <= 0) {
                if (xOffset != 0)
                    xOffset = xOffset * -1.0;
                xOffset += User.ISLAND_SIZE * 2.0;
            }
            config.set("islands.x", xOffset);
            config.set("islands.z", zOffset);
            config.save();
        }
        World finalWorld = world;
        player.teleport(finalWorld.getHighestBlockAt(SUtil.blackMagic(user.getIslandX()),
                SUtil.blackMagic(user.getIslandZ())).getLocation().add(0.5, 1.0, 0.5));
    }

    public static PotionEffect getPotionEffect(Player player, org.bukkit.potion.PotionEffectType type) {
        for (PotionEffect effect : player.getActivePotionEffects()) {
            if (effect.getType().getName().equals(type.getName()))
                return effect;
        }
        return null;
    }

    public static void replacePotionEffect(Player player, PotionEffect add) {
        PotionEffect effect = getPotionEffect(player, add.getType());
        if (effect != null && effect.getAmplifier() > add.getAmplifier())
            return;
        player.removePotionEffect(add.getType());
        player.addPotionEffect(add);
    }

    public static void handleSpecEntity(Entity entity, Player damager, AtomicDouble finalDamage) {
        SEntity sEntity = SEntity.findSEntity(entity);
        if (sEntity != null) {
            EntityFunction function = sEntity.getFunction();
            if (damager != null)
                sEntity.addDamageFor(damager, finalDamage.get());
            if (((LivingEntity) entity).getHealth() - finalDamage.get() <= 0.0) {
                if (damager != null)
                    damager.playSound(damager.getLocation(), Sound.SUCCESSFUL_HIT, 1f, 1f);
                User user = User.getUser(damager.getUniqueId());
                Skill.reward(CombatSkill.INSTANCE, sEntity.getStatistics().getXPDropped(), damager);
                SlayerQuest quest = user.getSlayerQuest();
                if (quest != null && sEntity.getSpecType().getCraftType() == quest.getType().getType().getEntityType()) {
                    if (sEntity.getGenericInstance() instanceof SlayerBoss &&
                            ((SlayerBoss) sEntity.getGenericInstance()).getSpawnerUUID().equals(damager.getUniqueId())) {
                        quest.setKilled(System.currentTimeMillis());
                        damager.playSound(damager.getLocation(), Sound.LEVEL_UP, 1f, 2f);
                        damager.sendMessage("  " + ChatColor.GOLD + ChatColor.BOLD + "NICE! SLAYER BOSS SLAIN!");
                        damager.sendMessage("   " + ChatColor.DARK_PURPLE + ChatColor.BOLD + "→ " + ChatColor.GRAY +
                                "Talk to Maddox to claim your " + quest.getType().getType().getName() + " Slayer XP!");
                    } else {
                        quest.setXp(quest.getXp() + sEntity.getStatistics().getXPDropped());
                        quest.setLastKilled(sEntity.getSpecType());
                        if (quest.getXp() >= quest.getType().getSpawnXP() && quest.getSpawned() == 0) {
                            Location location = entity.getLocation().clone().add(0, 1, 0);
                            quest.setSpawned(System.currentTimeMillis());
                            SlayerQuest.playBossSpawn(location, damager);
                            SUtil.delay(() -> quest.setEntity(new SEntity(location, quest.getType().getSpecType(), quest.getType().getTier(), damager.getUniqueId())), 28);
                        }
                    }
                }
                boolean rare = false;
                for (EntityDrop drop : SUtil.shuffle(function.drops())) {
                    EntityDropType type = drop.getType();
                    double r = SUtil.random(0.0, 1.0);
                    double magicFind = STATISTICS_CACHE.get(damager.getUniqueId()).getMagicFind().addAll() / 100.0;
                    double c = drop.getDropChance() + magicFind;
                    if (r > c) continue;
                    if (rare && type != EntityDropType.GUARANTEED) continue;
                    ItemStack stack = drop.getStack();
                    SItem sItem = SItem.find(stack);
                    if (sItem == null)
                        sItem = SItem.of(stack);
                    sItem.setOrigin(ItemOrigin.MOB);
                    MaterialStatistics s = sItem.getType().getStatistics();
                    String name = sItem.getRarity().getColor() + sItem.getType().getDisplayName(sItem.getVariant());
                    MaterialFunction f = sItem.getType().getFunction();
                    if (f != null) {
                        if (s.getType() != GenericItemType.ACCESSORY)
                            f.onKill(entity, damager, sItem);
                    }
                    if (damager != null) {
                        for (SItem accessory : PlayerUtils.getAccessories(damager)) {
                            if (accessory.getType().getStatistics().getType() == GenericItemType.ACCESSORY)
                                accessory.getType().getFunction().onKill(entity, damager, sItem);
                        }
                    }
                    if (type != EntityDropType.GUARANTEED && type != EntityDropType.COMMON && damager != null) {
                        damager.sendMessage(type.getColor() + "" + ChatColor.BOLD +
                                (type == EntityDropType.CRAZY_RARE ? "CRAZY " : "") + "RARE DROP!  " +
                                ChatColor.GRAY + "(" + name + ChatColor.GRAY + ")" + (magicFind != 0.0 ? ChatColor.AQUA +
                                " (+" + (int) (magicFind * 10000) + "% Magic Find!)" : ""));
                    }
                    if (drop.getOwner() == null)
                        entity.getWorld().dropItem(entity.getLocation(), stack);
                    else
                        SUtil.spawnPersonalItem(stack, entity.getLocation(), drop.getOwner());
                    if (type != EntityDropType.GUARANTEED)
                        rare = true;
                }
                function.onDeath(sEntity, entity, damager);
            }
        }
    }

    public static boolean takeMana(Player player, int amount) {
        int n = Repeater.MANA_MAP.get(player.getUniqueId()) - amount;
        if (n < 0)
            return false;
        Repeater.MANA_MAP.put(player.getUniqueId(), n);
        return true;
    }

    public static int getFinalManaCost(Player player, SItem sItem, int cost) {
        PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(player.getUniqueId());
        int manaPool = 100 + SUtil.blackMagic(statistics.getIntelligence().addAll());
        int updated = cost;
        ArmorSet set = PlayerUtils.STATISTICS_CACHE.get(player.getUniqueId()).getArmorSet();
        if (set != null) {
            if (set.equals(SMaterial.WISE_DRAGON_SET))
                updated /= 2;
        }
        Enchantment ultimateWise = sItem.getEnchantment(EnchantmentType.ULTIMATE_WISE);
        if (ultimateWise != null)
            updated = Math.max(0, ((Long) Math.round(updated - updated * (((double) ultimateWise.getLevel()) / 10.0))).intValue());
        if (cost == -1)
            updated = manaPool;
        if (cost == -2)
            updated = manaPool / 2;
        return updated;
    }

    public static int getSpecItemIndex(Player player, SMaterial type) {
        PlayerInventory inventory = player.getInventory();
        for (int i = 0; i < inventory.getSize(); i++) {
            SItem item = SItem.find(inventory.getItem(i));
            if (item != null && item.getType() == type)
                return i;
        }
        return -1;
    }

    public static void addBoostStatistics(PlayerStatistics statistics, int slot, PlayerBoostStatistics boostStatistics) {
        if (boostStatistics == null)
            return;
        DoublePlayerStatistic health = statistics.getMaxHealth(),
                defense = statistics.getDefense(),
                strength = statistics.getStrength(),
                intelligence = statistics.getIntelligence();
        DoublePlayerStatistic speed = statistics.getSpeed(),
                critChance = statistics.getCritChance(), critDamage = statistics.getCritDamage(),
                magicFind = statistics.getMagicFind();
        health.add(slot, boostStatistics.getBaseHealth());
        defense.add(slot, boostStatistics.getBaseDefense());
        strength.add(slot, boostStatistics.getBaseStrength());
        speed.add(slot, boostStatistics.getBaseSpeed());
        intelligence.add(slot, boostStatistics.getBaseIntelligence());
        critDamage.add(slot, boostStatistics.getBaseCritDamage());
        critChance.add(slot, boostStatistics.getBaseCritChance());
        magicFind.add(slot, boostStatistics.getBaseMagicFind());
    }

    public interface DamageResult {
        double getFinalDamage();

        boolean didCritDamage();
    }
}