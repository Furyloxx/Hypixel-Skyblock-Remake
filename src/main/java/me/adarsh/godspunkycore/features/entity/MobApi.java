package me.adarsh.godspunkycore.features.entity;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.PlayerInteractManager;
import net.minecraft.server.v1_8_R3.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.Entity;

import java.util.UUID;

public class MobApi {

    public static void createEntity(Entity entity, Location loc, String name, String texture, String signature) {
        GameProfile profile = new GameProfile(UUID.randomUUID(), name);
        profile.getProperties().put("textures", new Property("textures", texture, signature));
        WorldServer worldServer = ((CraftWorld) loc.getWorld()).getHandle();

        PlayerInteractManager interactManager = new PlayerInteractManager(worldServer);
        EntityPlayer temp = new EntityPlayer(((CraftServer) Bukkit.getServer()).getServer(), worldServer, profile, interactManager);
        PlayerDisguise mobDisguise = new PlayerDisguise(temp.getBukkitEntity().getName());
        mobDisguise.setEntity(entity);
        mobDisguise.startDisguise();

    }
}
