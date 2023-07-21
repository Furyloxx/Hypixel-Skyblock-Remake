package me.adarsh.godspunkycore.features.item;

import lombok.Getter;
import me.adarsh.godspunkycore.features.enchantment.Enchantment;
import me.adarsh.godspunkycore.features.enchantment.EnchantmentType;
import me.adarsh.godspunkycore.features.item.armor.LeatherArmorStatistics;
import me.adarsh.godspunkycore.features.potion.PotionColor;
import me.adarsh.godspunkycore.features.potion.PotionEffect;
import me.adarsh.godspunkycore.features.potion.PotionEffectType;
import me.adarsh.godspunkycore.features.reforge.Reforge;
import me.adarsh.godspunkycore.features.reforge.ReforgeType;
import me.adarsh.godspunkycore.util.SUtil;
import me.adarsh.godspunkycore.util.SerialNBTTagCompound;
import net.minecraft.server.v1_8_R3.Item;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

@Getter
public class SItem implements Cloneable, ConfigurationSerializable {
    private static final List<String> GLOBAL_NBT_TAGS = Arrays.asList("type", "rarity", "origin", "recombobulated");
    private static final List<String> GLOBAL_DATA_KEYS = Arrays.asList("type", "variant", "stack", "rarity", "origin", "recombobulated");

    private final SMaterial type;
    private final short variant;
    private ItemStack stack;
    private ItemLore lore;
    private Rarity rarity;
    private ItemOrigin origin;
    private boolean recombobulated;
    private NBTTagCompound data;

    protected SItem(SMaterial type, short variant, ItemStack stack, Rarity rarity, ItemOrigin origin, boolean recombobulated, NBTTagCompound data, boolean overwrite) {
        this.type = type;
        this.variant = variant;
        this.stack = stack;
        this.rarity = rarity;
        this.data = data;
        this.lore = new ItemLore(this);
        this.origin = origin;
        this.recombobulated = recombobulated;
        if (overwrite) {
            ItemMeta meta = this.stack.getItemMeta();
            if (!(type.getStatistics() instanceof LoreableMaterialStatistics))
                meta.setLore(this.lore.asBukkitLore());
            else
                meta.setLore(((LoreableMaterialStatistics) type.getStatistics()).getCustomLore(this));
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
            meta.spigot().setUnbreakable(true);
            this.stack.setItemMeta(meta);
            update();
        }
    }

    public void enchant(boolean enchant) {
        if (enchant) {
            if (stack.getItemMeta().hasEnchants())
                return;
            ItemMeta meta = stack.getItemMeta();
            meta.addEnchant(org.bukkit.enchantments.Enchantment.DURABILITY, 1, true);
            stack.setItemMeta(meta);
            return;
        }
        if (!stack.getItemMeta().hasEnchants())
            return;
        ItemMeta meta = stack.getItemMeta();
        meta.removeEnchant(org.bukkit.enchantments.Enchantment.DURABILITY);
        stack.setItemMeta(meta);
    }

    public boolean addEnchantment(EnchantmentType type, int level) {
        if (!isEnchantable())
            return false;
        List<Enchantment> enchantments = getEnchantments();
        Enchantment enchantment = new Enchantment(type, level);
        removeEnchantment(type);
        enchantments.add(enchantment);
        if (type.getVanilla() != null) {
            ItemMeta meta = stack.getItemMeta();
            meta.addEnchant(type.getVanilla(), level, true);
            stack.setItemMeta(meta);
        }
        NBTTagCompound es = data.getCompound("enchantments");
        for (Enchantment e : enchantments)
            es.setInt(e.getType().getNamespace(), e.getLevel());
        data.set("enchantments", es);
        update();
        return true;
    }

    public boolean removeEnchantment(EnchantmentType type) {
        if (!isEnchantable())
            return false;
        List<Enchantment> enchantments = getEnchantments();
        boolean removeIf = enchantments.removeIf(e -> e.getType().equals(type));
        if (type.getVanilla() != null) {
            ItemMeta meta = stack.getItemMeta();
            meta.removeEnchant(type.getVanilla());
            stack.setItemMeta(meta);
        }
        NBTTagCompound es = new NBTTagCompound();
        for (Enchantment enchantment : enchantments)
            es.setInt(enchantment.getType().getNamespace(), enchantment.getLevel());
        data.set("enchantments", es);
        update();
        return removeIf;
    }

    public boolean hasEnchantment(EnchantmentType type) {
        if (!isEnchantable())
            return false;
        List<Enchantment> enchantments = getEnchantments();
        for (Enchantment enchantment : enchantments) {
            if (enchantment.getType() == type)
                return true;
        }
        return false;
    }

    public Enchantment getEnchantment(EnchantmentType type) {
        if (!isEnchantable())
            return null;
        List<Enchantment> enchantments = getEnchantments();
        for (Enchantment enchantment : enchantments) {
            if (enchantment.getType() == type)
                return enchantment;
        }
        return null;
    }

    public List<Enchantment> getEnchantments() {
        if (!isEnchantable())
            return null;
        NBTTagCompound es = data.hasKey("enchantments") ? data.getCompound("enchantments") : new NBTTagCompound();
        List<Enchantment> enchantments = new ArrayList<>();
        for (String key : es.c())
            enchantments.add(new Enchantment(EnchantmentType.getByNamespace(key), es.getInt(key)));
        return enchantments;
    }

    public boolean addPotionEffect(PotionEffect effect) {
        if (!isPotion())
            return false;
        List<PotionEffect> effects = getPotionEffects();
        removePotionEffect(effect.getType());
        effects.add(effect);
        NBTTagCompound es = data.getCompound("effects");
        for (PotionEffect e : effects)
            es.set(e.getType().getNamespace(), e.toCompound());
        data.set("effects", es);
        update();
        return true;
    }

    public boolean removePotionEffect(PotionEffectType type) {
        if (!isPotion())
            return false;
        List<PotionEffect> effects = getPotionEffects();
        boolean removeIf = effects.removeIf(e -> e.getType().equals(type));
        PotionColor top = SUtil.getTopColor(this);
        stack.setDurability(top != null ? (isSplashPotion() ? top.getSplashData() : top.getData()) : (short) 0);
        NBTTagCompound es = data.getCompound("effects");
        for (PotionEffect e : effects)
            es.set(e.getType().getNamespace(), e.toCompound());
        data.set("effects", es);
        update();
        return removeIf;
    }

    public PotionEffect getPotionEffect(PotionEffectType type) {
        if (!isPotion())
            return null;
        List<PotionEffect> effects = getPotionEffects();
        for (PotionEffect effect : effects) {
            if (effect.getType() == type)
                return effect;
        }
        return null;
    }

    public List<PotionEffect> getPotionEffects() {
        if (!isPotion())
            return null;
        NBTTagCompound es = data.hasKey("effects") ? data.getCompound("effects") : new NBTTagCompound();
        List<PotionEffect> effects = new ArrayList<>();
        for (String key : es.c())
            effects.add(PotionEffect.ofCompound(key, es.getCompound(key)));
        return effects;
    }

    public boolean isEnchantable() {
        return type.getGenericInstance() instanceof Enchantable;
    }

    public boolean isReforgable() {
        return type.getGenericInstance() instanceof Reforgable;
    }

    public boolean isPotion() {
        return type == SMaterial.WATER_BOTTLE;
    }

    public boolean isSplashPotion() {
        return isPotion() && data.getBoolean("splash");
    }

    public void setAnvilUses(int anvilUses) {
        if (!(type.getGenericInstance() instanceof Enchantable))
            throw new UnsupportedOperationException("You cannot set the anvil uses on an unenchantable item");
        data.setInt("anvil", anvilUses);
        update();
    }

    public void setKills(Integer kills) {
        if (!type.getStatistics().displayKills())
            throw new UnsupportedOperationException("You cannot display kills on this item");
        data.setInt("kills", kills);
        update();
    }

    public void setRarity(Rarity rarity, boolean instanceUpdate) {
        this.rarity = rarity;
        update(instanceUpdate);
    }

    public void setRarity(Rarity rarity) {
        setRarity(rarity, true);
    }

    public void setAmount(int amount) {
        this.stack.setAmount(amount);
    }

    public void upgradeRarity() {
        this.rarity = this.rarity.upgrade();
        update();
    }

    public void downgradeRarity() {
        this.rarity = this.rarity.downgrade();
        update();
    }

    public void setReforge(Reforge reforge) {
        if (!(type.getGenericInstance() instanceof Reforgable))
            throw new UnsupportedOperationException("You cannot set the reforge of an unreforgable item");
        data.setString("reforge", ReforgeType.getByClass(reforge.getClass()).name());
        update();
    }
    public void setValue(Long value)
    {
        data.setLong("itemValue" , value);
        update();
    }
    public void setPrice(Long value)
    {
        data.setLong("price" , value);
        update();
    }
    public Long getPrice() {
        if (!data.hasKey("price")){
            return null;
         }
        else{
            return data.getLong("price");
        }
    }
    public Long getValue() {
        if (!data.hasKey("itemValue")) {
            return null;
        }

        else {
            return data.getLong("itemValue");
        }
    }


    public void setOrigin(ItemOrigin origin) {
        this.origin = origin;
        update();
    }

    public void setRecombobulated(boolean recombobulated) {
        this.recombobulated = recombobulated;
        if (recombobulated)
            setRarity(type.getStatistics().getRarity().upgrade());
        else
            setRarity(type.getStatistics().getRarity());
        update();
    }
    public void addHotBook(int value){
        setDataInt("hotBook" ,value + getHotBooks());
    }
    public Integer getHotBooks() {
        if (hasDataFor("hotBook")) {
            return getDataInt("hotBook");
        }
        return 0;
    }

    public Reforge getReforge() {
        if (!(type.getGenericInstance() instanceof Reforgable))
            return null;
        if (!data.hasKey("reforge"))
            return null;
        return ReforgeType.getReforgeType(data.getString("reforge")).getReforge();
    }

    public String getFullName() {
        return this.rarity.getColor() +
                (data.hasKey("reforge") ? ReforgeType.getReforgeType(data.getString("reforge")).getReforge().getName() + " " : "") +
                this.getType().getDisplayName(variant);
    }

    public String getDataString(String key) {
        return data.getString(key);
    }

    public int getDataInt(String key) {
        return data.getInt(key);
    }

    public long getDataLong(String key) {
        return data.getLong(key);
    }

    public NBTTagCompound getDataCompound(String key) {
        return data.getCompound(key);
    }

    public void setDataString(String key, String value) {
        data.setString(key, value);
        update();
    }

    public void setDataInt(String key, int value) {
        data.setInt(key, value);
        update();
    }

    public void setDataDouble(String key, double value) {
        data.setDouble(key, value);
        update();
    }

    public void setDataFloat(String key, float value) {
        data.setFloat(key, value);
        update();
    }

    public void setDataLong(String key, long value) {
        data.setLong(key, value);
        update();
    }

    public void setDataBoolean(String key, boolean value) {
        data.setBoolean(key, value);
        update();
    }

    public void setDataCompound(String key, NBTTagCompound value) {
        data.set(key, value);
        update();
    }

    public void removeData(String key) {
        data.remove(key);
        update();
    }

    public boolean hasDataFor(String key) {
        return data.hasKey(key);
    }

    public void setDisplayName(String name) {
        Reforge reforge = null;
        if (data.hasKey("reforge"))
            reforge = ReforgeType.getReforgeType(data.getString("reforge")).getReforge();
        ItemMeta meta = stack.getItemMeta();
        if (reforge == null)
            meta.setDisplayName(this.rarity.getColor() + name);
        else
            meta.setDisplayName(this.rarity.getColor() + reforge.getName() + " " + name);
        stack.setItemMeta(meta);
    }

    public void update(boolean instanceUpdate) {
        net.minecraft.server.v1_8_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(this.stack);
        if (nmsStack == null)
            return;
        NBTTagCompound compound = nmsStack.getTag() != null ? nmsStack.getTag() : new NBTTagCompound();
        compound.remove("type");
        compound.remove("variant");
        compound.remove("enchantments");
        compound.remove("anvil");
        compound.remove("rarity");
        compound.remove("kills");
        compound.remove("reforge");
        compound.remove("origin");
        compound.remove("recombobulated");

        for (String key : data.c()) {
            compound.remove(key);
            if (!data.get(key).isEmpty())
                compound.set(key, data.get(key));
        }
        compound.remove("amount");
        compound.setString("type", type.name());
        if (variant != 0)
            compound.setShort("variant", variant);
        if (this.rarity != type.getStatistics().getRarity())
            compound.setString("rarity", rarity.name());
        if (origin != ItemOrigin.UNKNOWN)
            compound.setString("origin", origin.name());
        if (this.recombobulated)
            compound.setBoolean("recombobulated", true);
        if (!this.getType().getStatistics().isStackable() && !compound.hasKey("uuid"))
            compound.setString("uuid", UUID.randomUUID().toString());
        nmsStack.setTag(compound);
        stack.setItemMeta(CraftItemStack.getItemMeta(nmsStack));
        ItemMeta meta = stack.getItemMeta();
        MaterialStatistics statistics = type.getStatistics();
        Reforge reforge = null;
        if (data.hasKey("reforge"))
            reforge = ReforgeType.getReforgeType(data.getString("reforge")).getReforge();
        if (reforge == null)
            meta.setDisplayName(this.rarity.getColor() + type.getDisplayName(variant));
        else
            meta.setDisplayName(this.rarity.getColor() + reforge.getName() + " " + type.getDisplayName(variant));
        if (isPotion() && getPotionEffects().size() > 0)
            stack.setDurability(isSplashPotion() ? SUtil.getTopColor(this).getSplashData() : SUtil.getTopColor(this).getData());
        if (!(statistics instanceof LoreableMaterialStatistics))
            meta.setLore(lore.asBukkitLore());
        else
            meta.setLore(((LoreableMaterialStatistics) statistics).getCustomLore(this));
        stack.setItemMeta(meta);
        if (type.getGenericInstance() instanceof Enchantable || statistics.isEnchanted())
            enchant(data.getCompound("enchantments").c().size() != 0 || statistics.isEnchanted());
        MaterialFunction function = type.getFunction();
        if (function != null && instanceUpdate)
            type.getFunction().onInstanceUpdate(this);
    }

    public void update() {
        update(true);
    }

    public static SItem of(SMaterial specMaterial, short variant, ItemOrigin origin) {
        ItemStack stack = new ItemStack(specMaterial.getCraftMaterial(), 1, variant);
        MaterialStatistics statistics = specMaterial.getStatistics();
        if (specMaterial.getCraftMaterial() == Material.SKULL_ITEM &&
                statistics instanceof SkullStatistics) {
            stack.setDurability((short) 3);
            SUtil.getSkull(((SkullStatistics) statistics).getURL(), stack, specMaterial);
        }
        if (statistics instanceof LeatherArmorStatistics)
            SUtil.applyColorToLeatherArmor(stack, Color.fromRGB(((LeatherArmorStatistics) statistics).getColor()));
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(statistics.getRarity().getColor() + specMaterial.getDisplayName(variant));
        stack.setItemMeta(meta);
        return new SItem(specMaterial, variant, stack,
                statistics.getRarity(), origin, false,
                specMaterial.getItemData() != null ? specMaterial.getItemData().getData() : new NBTTagCompound(),
                true);
    }

    public static SItem of(SMaterial specMaterial, ItemOrigin origin) {
        return of(specMaterial, specMaterial.getData(), origin);
    }

    public static SItem of(SMaterial specMaterial, short variant) {
        return of(specMaterial, variant, ItemOrigin.UNKNOWN);
    }

    public static SItem of(SMaterial specMaterial) {
        return of(specMaterial, specMaterial.getData());
    }

    public static SItem of(ItemStack stack, ItemOrigin origin) {
        if (stack == null)
            return null;
        SMaterial material = SMaterial.getSpecEquivalent(stack.getType(), stack.getDurability());
        if (material == null)
            return null;
        if (Item.getById(material.getCraftMaterial().getId()) == null)
            return null;
        SItem n = of(material, stack.getDurability(), origin);
        n.getStack().setAmount(stack.getAmount());
        return n;
    }

    public static SItem of(ItemStack stack) {
        return of(stack, ItemOrigin.UNKNOWN);
    }

    public static boolean isSpecItem(ItemStack stack) {
        if (stack == null) return false;
        net.minecraft.server.v1_8_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(stack);
        if (nmsStack == null) return false;
        if (!nmsStack.hasTag()) return false;
        NBTTagCompound compound = nmsStack.getTag();
        return compound.hasKey("type");
    }

    @Override
    public SItem clone() {
        return new SItem(type, variant, stack.clone(), rarity, origin, recombobulated, data, true);
    }

    public boolean equals(Object o) {
        if (!(o instanceof SItem)) return false;
        SItem item = (SItem) o;
        return type == item.type && variant == item.variant && stack.equals(item.stack) && rarity == item.rarity && origin == item.origin &&
                recombobulated == item.recombobulated && data.equals(item.data);
    }

    public NBTTagCompound toCompound() {
        NBTTagCompound compound = new NBTTagCompound();
        for (String key : data.c()) {
            compound.remove(key);
            compound.set(key, data.get(key));
        }
        compound.setString("type", type.name());
        if (variant != 0)
            compound.setShort("variant", variant);
        compound.setInt("amount", stack.getAmount());
        if (this.rarity != type.getStatistics().getRarity())
            compound.setString("rarity", rarity.name());
        if (origin != ItemOrigin.UNKNOWN)
            compound.setString("origin", origin.name());
        if (this.recombobulated)
            compound.setBoolean("recombobulated", true);
        if (!this.getType().getStatistics().isStackable() && !compound.hasKey("uuid"))
            compound.setString("uuid", UUID.randomUUID().toString());
        return compound;
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("type", type.name());
        map.put("variant", variant);
        map.put("amount", stack.getAmount());
        map.put("rarity", rarity.name());
        map.put("origin", origin.name());
        map.put("recombobulated", recombobulated);
        for (String k : data.c()) {
            if (k.equals("display"))
                continue;
            if (data.get(k) instanceof NBTTagCompound) {
                SerialNBTTagCompound serial = new SerialNBTTagCompound(data.getCompound(k));
                for (Map.Entry<String, Object> entry : serial.serialize().entrySet())
                    map.put(k + "." + entry.getKey(), entry.getValue());
                continue;
            }
            map.put(k, SUtil.getObjectFromCompound(data, k));
        }
        return map;
    }

    public static SItem deserialize(Map<String, Object> map) {
        NBTTagCompound data = new NBTTagCompound();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (GLOBAL_DATA_KEYS.contains(entry.getKey()))
                continue;
            String key = entry.getKey();
            String[] dir = entry.getKey().split("\\.");
            if (dir.length >= 2) {
                key = dir[dir.length - 1];
                NBTTagCompound track = data;
                for (int i = 0; i < dir.length - 1; i++) {
                    if (!track.hasKey(dir[i]))
                        track.set(dir[i], new NBTTagCompound());
                    track = track.getCompound(dir[i]);
                }
                track.set(key, SUtil.getBaseFromObject(entry.getValue()));
                continue;
            }
            data.set(key, SUtil.getBaseFromObject(entry.getValue()));
        }
        SMaterial material = SMaterial.getMaterial((String) map.get("type"));
        short variant = ((Integer) map.get("variant")).shortValue();
        return new SItem(material, variant, new ItemStack(material.getCraftMaterial(), (int) map.get("amount"), variant),
                Rarity.getRarity((String) map.get("rarity")), ItemOrigin.valueOf((String) map.get("origin")), (boolean) map.get("recombobulated"),
                data, true);
    }

    @Override
    public String toString() {
        return "SItem{type=" + type.name() + ", variant=" + variant + ", stack=" + stack.toString() + ", rarity=" + rarity.name() + ", origin=" +
                origin.name() + ", recombobulated=" + recombobulated + ", data=" + data.toString() + "}";
    }

    public static SItem find(ItemStack stack) {
        if (stack == null) return null;
        if (!isSpecItem(stack)) return null;
        net.minecraft.server.v1_8_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(stack);
        NBTTagCompound compound = nmsStack.getTag();
        if (compound == null) return null;
        return of(compound, stack);
    }

    public static SItem of(NBTTagCompound compound) {
        SMaterial type = SMaterial.getMaterial(compound.getString("type"));
        ItemStack stack = new ItemStack(type.getCraftMaterial(), compound.hasKey("amount") ? compound.getInt("amount") : 1, type.getData());
        MaterialStatistics statistics = type.getStatistics();
        if (type.getCraftMaterial() == Material.SKULL_ITEM &&
                statistics instanceof SkullStatistics) {
            stack.setDurability((short) 3);
            SUtil.getSkull(((SkullStatistics) statistics).getURL(), stack, type);
        }
        if (statistics instanceof LeatherArmorStatistics)
            SUtil.applyColorToLeatherArmor(stack, Color.fromRGB(((LeatherArmorStatistics) statistics).getColor()));
        ItemMeta meta = stack.getItemMeta();
        short variant = compound.hasKey("variant") ? compound.getShort("variant") : 0;
        meta.setDisplayName(statistics.getRarity().getColor() + type.getDisplayName(variant));
        stack.setItemMeta(meta);
        NBTTagCompound data = new NBTTagCompound();
        for (String key : compound.c()) {
            if (GLOBAL_NBT_TAGS.contains(key))
                continue;
            data.set(key, compound.get(key));
        }
        return new SItem(type, variant, stack,
                compound.hasKey("rarity") ? Rarity.getRarity(compound.getString("rarity")) : statistics.getRarity(),
                compound.hasKey("origin") ? ItemOrigin.valueOf(compound.getString("origin")) : ItemOrigin.UNKNOWN,
                compound.getBoolean("recombobulated"),
                data,
                true);
    }

    public static SItem convert(ItemStack stack) {
        return SUtil.setSItemAmount(SItem.of(SMaterial.getSpecEquivalent(stack.getType(), stack.getDurability())), stack.getAmount());
    }

    private static SItem of(NBTTagCompound compound, ItemStack stack) {
        SMaterial type = SMaterial.getMaterial(compound.getString("type"));
        NBTTagCompound data = new NBTTagCompound();
        for (String key : compound.c()) {
            if (GLOBAL_NBT_TAGS.contains(key))
                continue;
            data.set(key, compound.get(key));
        }
        return new SItem(type, compound.hasKey("variant") ? compound.getShort("variant") : 0, stack,
                (compound.hasKey("rarity") ? Rarity.getRarity(compound.getString("rarity")) : type.getStatistics().getRarity()),
                compound.hasKey("origin") ? ItemOrigin.valueOf(compound.getString("origin")) : ItemOrigin.UNKNOWN,
                compound.hasKey("recombobulated"), data, false);
    }

    public boolean getDataBoolean(final String key) {
        return this.data.getBoolean(key);
    }
}