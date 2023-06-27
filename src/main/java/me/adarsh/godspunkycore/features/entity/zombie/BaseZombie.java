package me.adarsh.godspunkycore.features.entity.zombie;

import me.adarsh.godspunkycore.features.entity.EntityFunction;
import me.adarsh.godspunkycore.features.entity.SEntity;
import me.adarsh.godspunkycore.features.entity.SEntityType;
import me.adarsh.godspunkycore.features.entity.ZombieStatistics;
import me.adarsh.godspunkycore.features.slayer.SlayerQuest;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public abstract class BaseZombie implements ZombieStatistics, EntityFunction {
    @Override
    public void onDeath(SEntity sEntity, Entity killed, Entity damager) {
        if (!(damager instanceof Player)) return;
        Player player = (Player) damager;
        User user = User.getUser(player.getUniqueId());
        SlayerQuest quest = user.getSlayerQuest();
        if (quest == null) return;
        if (quest.getSpawned() != 0) return;
        Location k = killed.getLocation().clone();
        if (SUtil.random(0, 8) == 0 && quest.getType().getTier() >= 3) {
            SlayerQuest.playMinibossSpawn(k, player);
            SUtil.delay(() -> new SEntity(k, SEntityType.REVENANT_SYCOPHANT).setTarget(player), 12);
            return;
        }
        if (SUtil.random(0, 16) == 0 && quest.getType().getTier() >= 4) {
            SlayerQuest.playMinibossSpawn(k, player);
            SUtil.delay(() -> new SEntity(k, SEntityType.REVENANT_CHAMPION).setTarget(player), 12);
            return;
        }
        if (SUtil.random(0, 45) == 0 && quest.getType().getTier() >= 4) {
            SlayerQuest.playMinibossSpawn(k, player);
            SUtil.delay(() -> new SEntity(k, SEntityType.DEFORMED_REVENANT).setTarget(player), 12);
        }
    }
}