package me.adarsh.godspunkycore.entity.den;

import me.adarsh.godspunkycore.entity.*;
import me.adarsh.godspunkycore.item.SMaterial;
import me.adarsh.godspunkycore.slayer.SlayerQuest;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public abstract class BaseSpider implements EntityStatistics, EntityFunction {
    @Override
    public void onDeath(SEntity sEntity, Entity killed, Entity damager) {
        if (!(damager instanceof Player)) return;
        Player player = (Player) damager;
        User user = User.getUser(player.getUniqueId());
        SlayerQuest quest = user.getSlayerQuest();
        if (quest == null) return;
        if (quest.getSpawned() != 0) return;
        Location k = killed.getLocation().clone();
        if (SUtil.random(0, 10) == 0 && quest.getType().getTier() >= 3) {
            SlayerQuest.playMinibossSpawn(k, player);
            SUtil.delay(() -> new SEntity(k, SEntityType.TARANTULA_VERMIN).setTarget(player), 12);
            return;
        }
        if (SUtil.random(0, 18) == 0 && quest.getType().getTier() >= 4) {
            SlayerQuest.playMinibossSpawn(k, player);
            SUtil.delay(() -> new SEntity(k, SEntityType.TARANTULA_BEAST).setTarget(player), 12);
            return;
        }
        if (SUtil.random(0, 50) == 0 && quest.getType().getTier() >= 4) {
            SlayerQuest.playMinibossSpawn(k, player);
            SUtil.delay(() -> new SEntity(k, SEntityType.MUTANT_TARANTULA).setTarget(player), 12);
        }
    }

    @Override
    public List<EntityDrop> drops() {
        return Arrays.asList(new EntityDrop(SMaterial.STRING, EntityDropType.GUARANTEED, 1.0),
                new EntityDrop(SMaterial.SPIDER_EYE, EntityDropType.OCCASIONAL, 0.5));
    }
}