package me.godspunky.skyblock.command;

import me.godspunky.skyblock.features.enchantment.EnchantmentType;
import me.godspunky.skyblock.features.item.SItem;
import me.godspunky.skyblock.features.item.SMaterial;
import me.godspunky.skyblock.features.ranks.PlayerRank;
import me.godspunky.skyblock.util.SUtil;
import me.godspunky.skyblock.util.Sputnik;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@CommandParameters(description = "Adds an enchantment from Spec to the specified item.", aliases = "meb", permission = PlayerRank.DEFAULT)
public class MembersEnchantCommand extends SCommand {
    public void run(CommandSource sender, String[] args) {
        if (args.length != 2)
            throw new CommandArgumentException();
        if (args.length == 0) {
            send(ChatColor.RED + "Wrong usage of the command! Usage /meb <enchant type> <level>!");
            return;
        }
        if (sender instanceof org.bukkit.command.ConsoleCommandSender)
            throw new CommandFailException("Console senders cannot use this command!");
        Player player = sender.getPlayer();
        if (Sputnik.isFullInv(player)) {
            send(ChatColor.RED + "Your inventory ran out of spaces! Clean it up!");
            return;
        }
        EnchantmentType type = EnchantmentType.getByNamespace(args[0]);
        if (type == null) {
            send(ChatColor.RED + "Invalid enchantment type! It might not get added yet.");
            return;
        }
        int i = Integer.parseInt(args[1]);
        if (i <= 0) {
            send(ChatColor.RED + "Are you serious? If you want to remove enchantments, use /rench");
            return;
        }

        if (i > 2 && type == EnchantmentType.KNOCKBACK) {
            send(ChatColor.RED + "Too high enchantment level! This enchantment is capped at level 2!");
            return;
        }
        if (i > 1500) {
            send(ChatColor.RED + "Too high enchantment level! This enchantment is capped at 1,500.");
            return;
        }
        if (i > 320 && type == EnchantmentType.POWER) {
            send(ChatColor.RED + "Too high enchantment level! This enchantment is capped at level 320.");
            return;
        }
        if (i > 400 && type == EnchantmentType.SHARPNESS) {
            send(ChatColor.RED + "Too high enchantment level! This enchantment is capped at level 400.");
            return;
        }
        if (i > 1 && (type == EnchantmentType.ONE_FOR_ALL || type == EnchantmentType.TELEKINESIS || type == EnchantmentType.AQUA_INFINITY)) {
            send(ChatColor.RED + "Too high enchantment level! This enchantment is capped at level 1.");
            return;
        }
        if (i > 30 && (type == EnchantmentType.CRITICAL || type == EnchantmentType.EXECUTE || type == EnchantmentType.AIMING)) {
            send(ChatColor.RED + "Too high enchantment level! This enchantment is capped at level 30.");
            return;
        }
        if (i > 10 && (type == EnchantmentType.ENDER_SLAYER || type == EnchantmentType.SMITE || type == EnchantmentType.BANE_OF_ARTHROPODS || type == EnchantmentType.DRAGON_HUNTER)) {
            send(ChatColor.RED + "Too high enchantment level! This enchantment is capped at level 10.");
            return;
        }
        if (i > 8 && type == EnchantmentType.ULTIMATE_WISE) {
            send(ChatColor.RED + "Too high enchantment level! This enchantment is capped at level 8.");
            return;
        }
        if (i > 5 && (type == EnchantmentType.SOUL_EATER || type == EnchantmentType.LIFE_STEAL || type == EnchantmentType.AIMING || type == EnchantmentType.VAMPIRISM)) {
            send(ChatColor.RED + "Too high enchantment level! This enchantment is capped at level 5.");
            return;
        }
        SItem eBook = SItem.of(SMaterial.ENCHANTED_BOOK);
        eBook.addEnchantment(type, i);
        player.getInventory().addItem(new ItemStack[] { eBook.getStack() });
        send(Sputnik.trans("&aYou have been given the &dEnchanted Book &awith &9" + type.getName() + " &9" + SUtil.toRomanNumeral(i) + " &aon it. Use an Anvil to apply it to your items."));
    }

    public void stop() {
        send("");
    }
}
