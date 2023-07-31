// 
// Decompiled by Procyon v0.5.36
// 

package me.godspunky.skyblock.util;

import net.minecraft.server.v1_8_R3.EntityFireworks;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityStatus;
import net.minecraft.server.v1_8_R3.World;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

public class SSU extends EntityFireworks {
    Player[] players;
    boolean gone;

    public SSU(World world, Player... p) {
        super(world);
        this.players = null;
        this.gone = false;
        this.players = p;
        this.a(0.25f, 0.25f);
    }

    public void t_() {
        if (this.gone) {
            return;
        }
        if (!this.world.isClientSide) {
            this.gone = true;
            if (this.players != null) {
                if (this.players.length > 0) {
                    for (Player player : this.players) {
                        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutEntityStatus(this, (byte) 17));
                    }
                } else {
                    this.world.broadcastEntityEffect(this, (byte) 17);
                }
            }
            this.die();
        }
    }

    public static void spawn(Location location, FireworkEffect effect, Player... players) {
        try {
            SSU firework = new SSU(((CraftWorld) location.getWorld()).getHandle(), players);
            FireworkMeta meta = ((Firework) firework.getBukkitEntity()).getFireworkMeta();
            meta.addEffect(effect);
            ((Firework) firework.getBukkitEntity()).setFireworkMeta(meta);
            firework.setPosition(location.getX(), location.getY(), location.getZ());
            if (((CraftWorld) location.getWorld()).getHandle().addEntity(firework)) {
                firework.setInvisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
