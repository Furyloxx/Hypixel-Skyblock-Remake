package me.godspunky.skyblock.features.item;

import net.minecraft.server.v1_8_R3.NBTTagCompound;

public interface Ownable extends ItemData {
    @Override
    default NBTTagCompound getData() {
        return new NBTTagCompound();
    }
}