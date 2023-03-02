package me.adarsh.godspunkycore.item.orb;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.PlayerBoostStatistics;
import me.adarsh.godspunkycore.item.Rarity;
import me.adarsh.godspunkycore.user.PlayerStatistics;
import me.adarsh.godspunkycore.user.PlayerUtils;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class OverfluxPowerOrb extends PowerOrb {
    @Override
    public String getAbilityDescription() {
        return "Place an orb for 60s buffing up to 5 players within 18 blocks. Costs 50% of max mana. Only one orb applies per player.";
    }

    @Override
    public String getURL() {
        return "84859d0adfc93be19bb441e6edfd43f6bfe6912723033f963d009a11c4824510";
    }

    @Override
    public String getDisplayName() {
        return "Overflux Power Orb";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EPIC;
    }

    @Override
    public String getBuffName() {
        return "Overflux";
    }

    @Override
    public String getBuffDescription() {
        return "Grants +100% base mana regen. Heals 2.5% of max ❤ per second. Increases all heals by +5%. Grants +25 Strength";
    }

    @Override
    protected void buff(Player player) {
        player.setHealth(Math.min(player.getMaxHealth(), player.getHealth() + (player.getMaxHealth() * 0.025)));
        PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(player.getUniqueId());
        PlayerUtils.boostPlayer(statistics, new PlayerBoostStatistics() {
            @Override
            public String getDisplayName() {
                return null;
            }

            @Override
            public Rarity getRarity() {
                return null;
            }

            @Override
            public GenericItemType getType() {
                return null;
            }

            @Override
            public double getBaseStrength() {
                return 25;
            }
        }, 20);
        statistics.boostManaRegeneration(1.0, 20);
        statistics.boostHealthRegeneration(0.05, 20);
    }

    @Override
    protected long getOrbLifeTicks() {
        return 60 * 20;
    }

    @Override
    protected void playEffect(Location location) {
        location.getWorld().spigot().playEffect(location, Effect.COLOURED_DUST, 0, 1,
                102.0f / 255.0f, 9.0f / 255.0f, 2.0f / 255.0f, 1, 0, 64);
    }
}