package me.adarsh.godspunkycore.features.item;

import me.adarsh.godspunkycore.util.SUtil;
import net.minecraft.server.v1_8_R3.NBTTagCompound;

public interface Rune extends SkullStatistics, MaterialFunction, ItemData {
    @Override
    default NBTTagCompound getData() {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setByte("level", (byte) 1);
        return compound;
    }

    @Override
    default void onInstanceUpdate(SItem instance) {
        byte level = instance.getData().getByte("level");
        instance.setDisplayName(getDisplayName() + " " + SUtil.toRomanNumeral(level));
    }
}