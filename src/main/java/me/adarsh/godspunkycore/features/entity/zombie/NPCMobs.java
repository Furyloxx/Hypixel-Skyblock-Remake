package me.adarsh.godspunkycore.features.entity.zombie;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.util.Sputnik;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import net.minecraft.server.v1_8_R3.AttributeInstance;
import net.minecraft.server.v1_8_R3.GenericAttributes;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftZombie;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

public interface NPCMobs {
    default PlayerDisguise onEntitySpawn(LivingEntity entity, String url1, String url2, boolean apl1) {
        ((CraftZombie)entity).setBaby(false);
        AttributeInstance followRange = ((CraftLivingEntity)entity).getHandle().getAttributeInstance(GenericAttributes.FOLLOW_RANGE);
        followRange.setValue(40.0D);
        PlayerDisguise pl = Sputnik.applyPacketNPC((Entity)entity, url1, url2, apl1);
        entity.setMetadata("SlayerBoss", (MetadataValue)new FixedMetadataValue((Plugin) Skyblock.getPlugin(), Boolean.valueOf(true)));
        entity.setMetadata("LD", (MetadataValue)new FixedMetadataValue((Plugin)Skyblock.getPlugin(), Boolean.valueOf(true)));
        return pl;
    }
}
