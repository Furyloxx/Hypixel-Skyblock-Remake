package me.godspunky.skyblock.features.item.axe;

import me.godspunky.skyblock.features.item.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Location; 

public class TreeCapitator implements ToolStatistics, MaterialFunction, Listener {

    private final List<Location> blockList = new ArrayList<>();
    private Map<UUID, Long> cooldowns = new HashMap<>();

    @Override
    public String getDisplayName() {
        return "Tree Capitator";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EPIC;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.TOOL;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.AXE;
    }

    @Override
    public String getLore() {
        return "A forceful Gold Axe which can break a large amount of logs in a single hit!";
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.getBlock().getType() == Material.LOG || event.getBlock().getType() == Material.LOG_2) {
            Player player = event.getPlayer();
            UUID uuid = player.getUniqueId();

            if (isOnCooldown(uuid)) {
                player.sendMessage("You are on cooldown!");
                return;
            }

            Block block = event.getBlock();

            for (int x = -4; x <= 4; x++) {
                for (int y = -4; y <= 4; y++) {
                    for (int z = -4; z <= 4; z++) {
                        Block loopBlock = block.getWorld().getBlockAt(block.getX() + x, block.getY() + y, block.getZ() + z);
                        if (loopBlock.getType() == Material.LOG || loopBlock.getType() == Material.LOG_2) {
                            ItemStack itemStack = new ItemStack(loopBlock.getType());
                            loopBlock.getWorld().dropItemNaturally(loopBlock.getLocation(), itemStack);
                            loopBlock.setType(Material.AIR);
                            
                        } else {
             
                            return;
                        }
                    }
                }
            }

            setCooldown(uuid, 2);
        }
    }

    private boolean isOnCooldown(UUID uuid) {
        return cooldowns.containsKey(uuid) && cooldowns.get(uuid) > System.currentTimeMillis();
    }

    private void setCooldown(UUID uuid, int seconds) {
        cooldowns.put(uuid, System.currentTimeMillis() + (seconds * 1000));
    }
}