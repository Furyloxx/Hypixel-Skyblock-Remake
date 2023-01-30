package me.adarsh.godspunkycore.item.armor;

import me.adarsh.godspunkycore.item.SItem;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public interface TickingSet extends ArmorSet
{
    void tick(Player owner, SItem helmet, SItem chestplate, SItem leggings, SItem boots, List<AtomicInteger> counters);
}