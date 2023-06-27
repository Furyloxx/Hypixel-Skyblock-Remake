package me.adarsh.godspunkycore.features.item.accessory;

import me.adarsh.godspunkycore.features.item.*;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class AutoRecombobulator implements AccessoryStatistics, MaterialFunction {
    @Override
    public String getURL() {
        return "5dff8dbbab15bfbb11e23b1f50b34ef548ad9832c0bd7f5a13791adad0057e1b";
    }

    @Override
    public String getDisplayName() {
        return "Auto Recombobulator";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ACCESSORY;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.ACCESSORY;
    }

    @Override
    public boolean isStackable() {
        return false;
    }

    @Override
    public void onKill(Entity damaged, Player damager, SItem item) {
        if (SUtil.random(1, 100) == 1)
            item.setRecombobulated(true);
    }
}
