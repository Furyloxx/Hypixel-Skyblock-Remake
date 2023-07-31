package me.godspunky.skyblock.features.potion;

import lombok.Getter;
import lombok.Setter;
import me.godspunky.skyblock.util.SUtil;

@Getter
public class ActivePotionEffect {
    private final PotionEffect effect;
    @Setter
    private long remaining;

    public ActivePotionEffect(PotionEffect effect, long remaining) {
        this.effect = effect;
        this.remaining = remaining;
    }

    public String getRemainingDisplay() {
        return SUtil.getFormattedTime(remaining);
    }
}