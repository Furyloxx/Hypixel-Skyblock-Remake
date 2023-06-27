package me.adarsh.godspunkycore.features.item.armor.miner;

import me.adarsh.godspunkycore.features.item.MaterialStatistics;
import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.armor.TickingSet;
import me.adarsh.godspunkycore.listener.PlayerListener;
import me.adarsh.godspunkycore.features.region.Region;
import me.adarsh.godspunkycore.user.DoublePlayerStatistic;
import me.adarsh.godspunkycore.user.PlayerStatistic;
import me.adarsh.godspunkycore.user.PlayerStatistics;
import me.adarsh.godspunkycore.user.PlayerUtils;
import me.adarsh.godspunkycore.util.Groups;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MinerSet implements TickingSet {
    @Override
    public String getName() {
        return "Regeneration";
    }

    @Override
    public String getDescription() {
        return "Regenerates 5% of your max Health every second if you have been out of combat for the last 8 seconds.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return MinerHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return MinerChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return MinerLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return MinerBoots.class;
    }

    @Override
    public void tick(Player owner, SItem helmet, SItem chestplate, SItem leggings, SItem boots, List<AtomicInteger> counters) {
        PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(owner.getUniqueId());
        DoublePlayerStatistic defense = statistics.getDefense();
        PlayerListener.CombatAction action = PlayerListener.getLastCombatAction(owner);
        counters.get(0).incrementAndGet();
        if ((action == null || (action.getTimeStamp() + 8000 <= System.currentTimeMillis() && helmet != null && chestplate != null && leggings != null && boots != null)) && counters.get(0).get() >= 2) {
            owner.setHealth(Math.min(owner.getMaxHealth(), owner.getHealth() + (owner.getMaxHealth() * 0.05)));
            counters.get(0).set(0);
        }
        Region region = Region.getRegionOfEntity(owner);
        if (region == null) return;
        if (!Groups.DEEP_CAVERNS_REGIONS.contains(region.getType())) return;
        if (helmet != null)
            defense.add(PlayerStatistic.MINER_BUFF, 45.0);
        if (chestplate != null)
            defense.add(PlayerStatistic.MINER_BUFF, 95.0);
        if (leggings != null)
            defense.add(PlayerStatistic.MINER_BUFF, 70.0);
        if (boots != null)
            defense.add(PlayerStatistic.MINER_BUFF, 45.0);
    }
}
