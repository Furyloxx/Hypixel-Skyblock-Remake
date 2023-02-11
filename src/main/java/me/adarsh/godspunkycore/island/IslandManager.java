package me.adarsh.godspunkycore.island;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.schematic.MCEditSchematicFormat;
import me.adarsh.godspunkycore.Spectaculation;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

@SuppressWarnings("deprecation")
public class IslandManager {

    public static final String ISLAND_PREFIX = "island-";

    public static World getIsland(Player player) {
        return Bukkit.getWorld("island-" + player.getUniqueId());
    }



    public static void createIsland(Player player) {
        File worldFile = new File(Bukkit.getWorldContainer(), ISLAND_PREFIX + player.getUniqueId().toString());
        if (worldFile.exists()) {
            Bukkit.createWorld(new WorldCreator(worldFile.getName()));
            Location loc2 = new Location(IslandManager.getIsland(player), 0, 100, 0);
            player.teleport(loc2);
            return;
        }

        WorldCreator creator = new WorldCreator(ISLAND_PREFIX + player.getUniqueId().toString()).type(WorldType.FLAT).generator(new ChunkGenerator() {
            @Override
            public byte[] generate(World world, Random random, int x, int z) {
                return new byte[32768];
            }
        });

        World world = Bukkit.createWorld(creator);

        player.teleport(new Location(world, 0, 100, 0));

        Vector loc = new Vector(player.getLocation().getX(), 100, player.getLocation().getZ());

        WorldEditPlugin we = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
        File schematic = new File(Spectaculation.getPlugin(Spectaculation.class).getDataFolder() + File.separator + "private_island.schematic");
        EditSession session = we.getWorldEdit().getEditSessionFactory().getEditSession(new BukkitWorld(world), 1000000);

        try {
            MCEditSchematicFormat.getFormat(schematic).load(schematic).paste(session, loc, false);
        } catch (MaxChangedBlocksException
                 | com.sk89q.worldedit.data.DataException | IOException ex) {
            ex.printStackTrace();
        }

        world.setGameRuleValue("keepInventory", "true");
        world.setGameRuleValue("naturalRegeneration", "false");
        world.setGameRuleValue("doMobSpawning", "false");
        world.setGameRuleValue("fireSpread", "false");

        new BukkitRunnable() {
            @Override
            public void run() {
                world.getBlockAt(new Location(world, 0, 100, 36)).setType(Material.PORTAL);
                world.getBlockAt(new Location(world, 0, 101, 36)).setType(Material.PORTAL);
                world.getBlockAt(new Location(world, 0, 102, 36)).setType(Material.PORTAL);
                world.getBlockAt(new Location(world, 0, 103, 36)).setType(Material.PORTAL);
                world.getBlockAt(new Location(world, 0, 104, 36)).setType(Material.PORTAL);
                world.getBlockAt(new Location(world, -1, 100, 36)).setType(Material.PORTAL);
                world.getBlockAt(new Location(world, -1, 101, 36)).setType(Material.PORTAL);
                world.getBlockAt(new Location(world, -1, 102, 36)).setType(Material.PORTAL);
                world.getBlockAt(new Location(world, -1, 103, 36)).setType(Material.PORTAL);
                world.getBlockAt(new Location(world, -1, 104, 36)).setType(Material.PORTAL);
                world.getBlockAt(new Location(world, -2, 100, 36)).setType(Material.PORTAL);
                world.getBlockAt(new Location(world, -2, 101, 36)).setType(Material.PORTAL);
                world.getBlockAt(new Location(world, -2, 102, 36)).setType(Material.PORTAL);
                world.getBlockAt(new Location(world,-2, 103, 36)).setType(Material.PORTAL);
                world.getBlockAt(new Location(world, -2, 104, 36)).setType(Material.PORTAL);
            }
        }.runTaskLater(Spectaculation.getPlugin(Spectaculation.class), 5);

        world.save();
    }
}
