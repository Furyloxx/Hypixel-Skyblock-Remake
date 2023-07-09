package me.adarsh.godspunkycore.util;

import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

import java.util.List;
import java.util.Random;

public class BlankWorldCreator extends org.bukkit.WorldCreator {

    public BlankWorldCreator(String name) {
        super(name);
        this.generator(new BlankChunkGenerator());
    }

    private class BlankChunkGenerator extends ChunkGenerator {

        @Override
        public List<BlockPopulator> getDefaultPopulators(World world) {
            return super.getDefaultPopulators(world);
        }

        @Override
        public boolean canSpawn(World world, int x, int z) {
            return true;
        }

        @Override
        public byte[][] generateBlockSections(World world, Random random, int x, int z, BiomeGrid biomes) {
            return new byte[world.getMaxHeight() / 16][];
        }

        @Override
        public byte[] generate(World world, Random random, int x, int z) {
            return new byte[32768];
        }
    }
}