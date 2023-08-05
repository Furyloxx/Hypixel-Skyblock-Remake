package me.godspunky.skyblock.command;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;
import javax.xml.bind.DatatypeConverter;

import me.godspunky.skyblock.features.ranks.PlayerRank;
import me.godspunky.skyblock.user.User;
import me.godspunky.skyblock.util.SUtil;
import me.godspunky.skyblock.util.Sputnik;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;


@CommandParameters(description = "", aliases = "api", permission = PlayerRank.DEFAULT)
public class APICommand extends SCommand {
    public void run(CommandSource sender, String[] args) {
        Player player = sender.getPlayer();
        if (player == null) {
            send("&cConsole sender cannot execute this command!");
            return;
        }
        User user = User.getUser(player.getUniqueId());
        if (user.isCooldownAPI()) {
            send("&cPlease wait 30 seconds before requesting the API key!");
            return;
        }
        user.setCooldownAPI(true);
        SUtil.delay(() -> user.setCooldownAPI(false), 600L);
        ComponentBuilder message = new ComponentBuilder("");
        String APIKey = "An Error Occured!";
        try {
            APIKey = generateAPIKey(player.getUniqueId());
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }
        String usage = APIKey;
        message.append(Sputnik.trans("&aYour &aAPI &akey &ais &b" + APIKey))
                .event(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, usage))
                .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(ChatColor.YELLOW + "Click to put key into chat so you can copy!")));
        player.spigot().sendMessage(message.create());
    }

    public static String generateAPIKey(UUID uuid) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(xorString(uuid.toString(), "D7qjI59cOcuoEDEQd4Cs"));
        byte[] digest = md5.digest();
        return uuid + ":" + Base64.getEncoder().encodeToString(xorString(DatatypeConverter.printHexBinary(digest).toUpperCase().substring(0, 10), "AWF6GGDnWJ54TErdQdsw"));
    }

    private static byte[] xorString(String s, String key) {
        byte[] bytes = new byte[s.length()];
        for (int i = 0; i < s.length(); i++)
            bytes[i] = (byte)(s.charAt(i) ^ key.charAt(i % key.length()));
        return bytes;
    }
}
