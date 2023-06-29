package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.features.collection.ItemCollection;
import me.adarsh.godspunkycore.features.ranks.PlayerRank;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.command.ConsoleCommandSender;

@CommandParameters(description = "Modify your collections.", permission = PlayerRank.ADMIN)
public class CollectionsCommand extends SCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
        if (args.length != 3) throw new CommandArgumentException();
        if (sender instanceof ConsoleCommandSender)
            throw new CommandFailException("Console senders cannot use this command!");
        ItemCollection collection = ItemCollection.getByIdentifier(args[0]);
        if (collection == null)
            throw new CommandFailException("Could not find the specified collection!");
        User user = sender.getUser();
        int amount = Integer.parseInt(args[2]);
        switch (args[1].toLowerCase()) {
            case "add": {
                user.addToCollection(collection, amount);
                send("You have added " + SUtil.commaify(amount) + " to your " + collection.getName() + " collection.");
                return;
            }
            case "subtract":
            case "sub": {
                user.setCollection(collection, user.getCollection(collection) - amount);
                send("You have subtracted " + SUtil.commaify(amount) + " from your " + collection.getName() + " collection.");
                return;
            }
            case "set": {
                user.setCollection(collection, amount);
                send("You have set your " + collection.getName() + " collection to " + SUtil.commaify(amount) + ".");
                return;
            }
        }
        throw new CommandArgumentException();
    }
}
