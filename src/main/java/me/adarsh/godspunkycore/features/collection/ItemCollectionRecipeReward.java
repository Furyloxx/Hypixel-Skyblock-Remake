package me.adarsh.godspunkycore.features.collection;

import me.adarsh.godspunkycore.features.item.SMaterial;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ItemCollectionRecipeReward extends ItemCollectionReward {
    private final SMaterial material;

    public ItemCollectionRecipeReward(SMaterial material) {
        super(Type.RECIPE);
        this.material = material;
    }

    @Override
    public void onAchieve(Player player) {
        // TODO
    }

    public String toRewardString() {
        return ChatColor.GRAY + material.getDisplayName(material.getData()) + ChatColor.GRAY + " Recipe";
    }
}