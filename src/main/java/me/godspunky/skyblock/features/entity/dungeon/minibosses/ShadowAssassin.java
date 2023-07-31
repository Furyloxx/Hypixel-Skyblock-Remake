package me.godspunky.skyblock.features.entity.dungeon.minibosses;

import me.godspunky.skyblock.features.entity.*;
import me.godspunky.skyblock.features.item.SItem;
import me.godspunky.skyblock.features.item.SMaterial;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;

public class ShadowAssassin implements ZombieStatistics, EntityStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "Shadow Assassin";
    }

    @Override
    public double getEntityMaxHealth() {
        return 500000;
    }

    @Override
    public double getDamageDealt() {
        return 3280;
    }

    @Override
    public double getXPDropped() {
        return 115;
    }

    @Override
    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(SItem.of(SMaterial.STONE_SWORD).getStack(),
                null,
                null,
                null,
                SItem.of(SMaterial.SHADOW_ASSASSIN_BOOTS).getStack()
        );
    }

    @Override
    public double getMovementSpeed() {
        return 0.4;
    }

    @Override
    public void onDeath(SEntity sEntity, Entity killed, Entity damager) {
        SEntityType type = SEntityType.BONZO_PHASE_1;
        World world = damager.getWorld();// and now finding something to do ;-;
        Location loc = new Location(world, 111,80,218);
        sEntity = new SEntity(loc , type);
        damager.sendMessage(ChatColor.translateAlternateColorCodes('&',"&4[BOSS] &cBonzo: &fYou little brat!!"));
    }

}
