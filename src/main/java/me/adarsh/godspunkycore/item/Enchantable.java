package me.adarsh.godspunkycore.item;

import net.minecraft.server.v1_8_R3.NBTTagCompound;

public interface Enchantable extends ItemData
{
    @Override
    default NBTTagCompound getData()
    {
        return new NBTTagCompound();
    }
}