package me.adarsh.godspunkycore.util;

import com.comphenix.protocol.wrappers.WrappedSignedProperty;
import com.google.common.util.concurrent.AtomicDouble;
import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.user.PlayerUtils;
import me.libraryaddict.disguise.disguisetypes.FlagWatcher;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import net.minecraft.server.v1_8_R3.EntityItem;
import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntity;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Sputnik {

    public static Object[] calculateDamage(final Player player, final Player damager, final ItemStack weapon, final LivingEntity damaged, final boolean isBow) {
        final PlayerUtils.DamageResult result = PlayerUtils.getDamageDealt(weapon, player, (Entity)damaged, isBow);
        float displayDmg = new AtomicDouble(result.getFinalDamage()).floatValue();

        return new Object[] { new AtomicDouble(result.getFinalDamage()).floatValue(), result.didCritDamage(), displayDmg };
    }
    public static PlayerDisguise applyPacketNPC(Entity entity, String skinURLorUsername, String URL_2, boolean isURLSkin) {
        PlayerDisguise playerDisguise = new PlayerDisguise("");
        try {
            Method m = FlagWatcher.class.getDeclaredMethod("setValue", Integer.TYPE, Object.class);
            m.setAccessible(true);
            try {
                m.invoke(playerDisguise.getWatcher(), 10, (byte)127);
            } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        playerDisguise.setShowName(false);
        if (isURLSkin && URL_2 != null) {
            playerDisguise.getGameProfile().getProperties().put("textures", new WrappedSignedProperty("textures", skinURLorUsername, URL_2));
        } else {
            playerDisguise.setSkin(skinURLorUsername);
        }
        playerDisguise.setEntity(entity);
        playerDisguise.startDisguise();
        return playerDisguise;
    }
    public static void showFakeItem(Location loc, ItemStack material, Player p) {
        EntityItem item = new EntityItem(((CraftWorld) loc.getWorld()).getHandle());
        item.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0.0f, 0.0f);
        item.setItemStack(CraftItemStack.asNMSCopy(material));
        PacketPlayOutSpawnEntity packet = new PacketPlayOutSpawnEntity(item, 2);
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
    }
    public static String trans(String content) {
        return ChatColor.translateAlternateColorCodes('&', content);
    }

    public static ArmorStand spawnDialougeBox(final Entity e, final double yoffset) {
        ArmorStand as = e.getWorld().spawn(e.getLocation().add(0.0, yoffset, 0.0), ArmorStand.class);
        as.setVisible(false);
        as.setMarker(true);
        as.setCustomNameVisible(false);
        as.setGravity(false);
        new BukkitRunnable() {

            public void run() {
                if (e.isDead()) {
                    SUtil.delay(() -> as.remove(), 20L);
                    this.cancel();
                    return;
                }
                if (as.isDead()) {
                    this.cancel();
                    return;
                }
                as.teleport(e.getLocation().add(0.0, yoffset, 0.0));
            }
        }.runTaskTimer(Skyblock.getPlugin(), 0L, 1L);
        return as;
    }




}
