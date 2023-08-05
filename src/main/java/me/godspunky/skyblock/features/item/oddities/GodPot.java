package me.godspunky.skyblock.features.item.oddities;

import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.potion.PotionEffect;
import me.godspunky.skyblock.features.potion.PotionEffectType;
import me.godspunky.skyblock.user.PlayerUtils;
import me.godspunky.skyblock.user.User;
import me.godspunky.skyblock.util.SUtil;
import me.godspunky.skyblock.util.Sputnik;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
public class GodPot implements SkullStatistics, MaterialFunction, Ability {
    public String getURL() {
        return "60226d4c1d30fbebecae939da900603e4cd0fed8592a1bb3e11f9ac92391a45a";
    }

    public String getDisplayName() {
        return "God Potion";
    }

    public Rarity getRarity() {
        return Rarity.SPECIAL;
    }

    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }

    public String getAbilityName() {
        return "Drink!";
    }

    public String getAbilityDescription() {
        return Sputnik.trans("&7Consume this potion give the player &a24 hours &7of positive effects!");
    }

    public int getAbilityCooldownTicks() {
        return 0;
    }

    public int getManaCost() {
        return 0;
    }

    public boolean displayUsage() {
        return false;
    }

    public boolean isStackable() {
        return false;
    }

    private boolean bool = true;

    public void onAbilityUse(final Player player, SItem sItem) {
        SUtil.delay(() -> this.bool = false, 35L);
        ArrayList<PotionEffect> effects = new ArrayList<>();
        effects.add(new PotionEffect(PotionEffectType.ARCHERY, 4, 1728000L));
        effects.add(new PotionEffect(PotionEffectType.CRITICAL, 6, 1728000L));
        effects.add(new PotionEffect(PotionEffectType.STRENGTH, 8, 1728000L));
        if (!player.getWorld().getName().contains("arena")) {
            effects.add(new PotionEffect(PotionEffectType.JUMP_BOOST, 4, 1728000L));
            effects.add(new PotionEffect(PotionEffectType.RABBIT, 6, 1728000L));
        }
        effects.add(new PotionEffect(PotionEffectType.RESISTANCE, 8, 1728000L));
        effects.add(new PotionEffect(PotionEffectType.SPEED, 8, 1728000L));
        effects.add(new PotionEffect(PotionEffectType.HASTE, 4, 1728000L));
        effects.add(new PotionEffect(PotionEffectType.SPIRIT, 4, 1728000L));
        effects.add(new PotionEffect(PotionEffectType.TRUE_RESISTANCE, 4, 1728000L));
        effects.add(new PotionEffect(PotionEffectType.STAMINA, 4, 1728000L));
        User user = User.getUser(player.getUniqueId());
        (new BukkitRunnable() {
            public void run() {
                if (!GodPot.this.bool) {
                    player.getWorld().playEffect(player.getLocation().add(0.0D, 0.5D, 0.0D), Effect.EXPLOSION_HUGE, 0);
                    player.getWorld().playEffect(player.getLocation().add(0.0D, 0.5D, 0.0D), Effect.EXPLOSION_HUGE, 0);
                    player.sendMessage(Sputnik.trans("&a&lSIP! &eThe &cGod Potion &egrants you powers for &924 hours&e!"));
                    cancel();
                    return;
                }
                for (int i = 0; i < 100; i++) {
                    double r = SUtil.random(0.0D, 1.0D);
                    player.getWorld().playEffect(player.getLocation().add(0.0D, r, 0.0D), Effect.POTION_SWIRL, 0);
                }
            }
        }).runTaskTimer(Skyblock.getPlugin(), 0L, 1L);
        for (PotionEffect effect : effects) {
            user.removePotionEffect(effect.getType());
            PlayerUtils.updatePotionEffects(user, PlayerUtils.STATISTICS_CACHE.get(user.getUuid()));
            if (effect.getType().getOnDrink() != null)
                effect.getType().getOnDrink().accept(effect, player);
            user.addPotionEffect(effect);
        }
        player.setItemInHand(null);
    }
}
