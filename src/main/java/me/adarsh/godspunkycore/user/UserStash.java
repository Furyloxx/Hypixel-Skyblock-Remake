package me.adarsh.godspunkycore.user;

import me.adarsh.godspunkycore.util.SUtil;
import me.adarsh.godspunkycore.util.Sputnik;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserStash
{
    private UUID user;
    private User u;

    public static UserStash getStash(final UUID u) {
        return new UserStash(u);
    }

    public UserStash(final UUID uuid) {
        this.user = uuid;
        this.u = User.getUser(this.user);
    }

    public void sendNotificationMessage() {
        if (!this.haveStashedItems()) {
            return;
        }
        this.u.sendClickableMessage("&eYou have &a" + SUtil.commaify(this.getStashQuantity()) + " &eitems stashed away!!!", new TextComponent[] { new TextComponent(Sputnik.trans("&eClick to pickup your items!")) }, "/pickupstash");
        this.u.sendClickableMessage("&6Click here &eto pick them up!", new TextComponent[] { new TextComponent(Sputnik.trans("&eClick to pickup your items!")) }, "/pickupstash");
    }

    public boolean haveStashedItems() {
        return this.u.getStashedItems().size() > 0;
    }

    public int getStashQuantity() {
        int quant = 0;
        for (final ItemStack items : this.u.getStashedItems()) {
            quant += items.getAmount();
        }
        return quant;
    }

    public void addItemInStash(final ItemStack i) {
        final List<ItemStack> modifiableList = new ArrayList<ItemStack>(this.u.getStashedItems());
        modifiableList.add(i);
        this.u.setStashedItems(modifiableList);
        this.u.send("&cAn item didn't fit into your inventory and was added to your item stash! Use /pickupstash to get it back!");
    }

    public void pickUpStash() {
        long picked = 0L;
        if (!this.haveStashedItems()) {
            this.u.send("&cYour stash is already empty!");
            return;
        }
        if (Sputnik.isFullInv(this.u.toBukkitPlayer())) {
            this.u.send("&cYour inventory is full!");
            return;
        }
        for (final ItemStack i : this.u.getStashedItems()) {
            if (this.u.toBukkitPlayer().getInventory().firstEmpty() == -1) {
                this.u.send("&eYou picked up &a" + SUtil.commaify(picked) + " &eitems from your item stash!");
                this.u.send("&eYou still have &b" + SUtil.commaify(this.getStashQuantity()) + " &eitems in there!");
                return;
            }
            this.u.toBukkitPlayer().getInventory().addItem(new ItemStack[] { i });
            picked += i.getAmount();
            final List<ItemStack> modifiableList = new ArrayList<ItemStack>(this.u.getStashedItems());
            modifiableList.remove(i);
            this.u.setStashedItems(modifiableList);
            if (i.getAmount() < 2) {
                this.u.send("&eFrom stash: &f" + i.getItemMeta().getDisplayName());
            }
            else {
                this.u.send("&eFrom stash: &7" + i.getAmount() + "x &f" + i.getItemMeta().getDisplayName());
            }
        }
        this.u.send("&eYou picked up &aall &eitems from your item stash!");
    }
}
