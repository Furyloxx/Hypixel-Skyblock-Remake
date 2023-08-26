package me.godspunky.skyblock.listener;

import me.godspunky.skyblock.features.skill.CombatSkill;
import me.godspunky.skyblock.user.User;
import me.godspunky.skyblock.util.SUtil;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class NpcListner implements Listener {
    @EventHandler
    public void onNPCClick(NPCRightClickEvent e){
        Player p = e.getClicker();
        String NpcName = e.getNPC().getName();
        Location Ploc = p.getLocation();
        Sound sound = Sound.VILLAGER_YES;
        User user = User.getUser(p.getUniqueId());

        if (NpcName.equalsIgnoreCase("Andrew")){
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),0);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Andrew: &fThis game is still under heavy development, don't forget to check the &adiscord &foften for updates!")),0);
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),30);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Andrew: &fIf you'd like to discuss SkyBlock with other players then check out the SkyBlock section of the &adiscord&f!")), 30);
        }

        if (NpcName.equalsIgnoreCase("Jack")){
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),0);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Jack: &fYour &aSkyBlock Profile &fin your &aSkyBlock Menu &fshows details about your current stats!")),0);
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),30);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Jack: &fThere are 7 stats in total, including &c❤ Health&f, &c❁ Strength&f, &fand &a❈ Defense&f.")), 30);
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),60);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Jack: &fEquipped armor, weapons, and accessories in your inventory all improve your stats.")), 60);
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),90);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Jack: &fAdditionally, leveling your Skills can permanently boost some of your stats!")), 90);
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),120);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Jack: &fThe higher your &c❤ Health &fstat, the faster your health will regenerate!")), 120);
        }

        if (NpcName.equalsIgnoreCase("Jamie")){
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),0);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Jamie: &fYou might have noticed that you have a Mana bar!")),0);
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),30);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Jamie: &fSome items have mysterious properties, called Abilities.")), 30);
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),60);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Jamie: &fAbilities use your Mana as a resource. Here, take this Rogue Sword. I don't need it!")), 60);
        }

        if (NpcName.equalsIgnoreCase("Tom")){
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),0);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Tom: &fI will teach you the &aPromising Axe Recipe &fto get you started!")),0);
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),30);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Tom: &fAll SkyBlock recipes can be found by opening the &aRecipe Book &fin your &aSkyBlock Menu&f.")), 30);
        }

        if (NpcName.equalsIgnoreCase("leo")){
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),0);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Leo: &fYou can unlock &aLeaflet Armor &fby progressing through your &aOak Log Collection.")),0);
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),30);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Leo: &fThere is a &bForest &fwest of the &bVillage &fwhere you can gather Oak Logs.")), 30);
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),60);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Leo: &fTo check your Collection progress and rewards, open the &eCollection Menu &fin your &eSkyBlock Menu&f.")), 60);
        }

        if (NpcName.equalsIgnoreCase("Felix")){
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),0);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Felix: &fYou can access your &aEnder Chest &fin your &aSkyBlock Menu&f.")),0);
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),30);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Felix: &fStore items in this chest and access them at any time!")), 30);
        }

        if (NpcName.equalsIgnoreCase("Duke")){
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),0);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Duke: &fAre you new here? As you can see there is a lot to explore!")),0);
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),30);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Duke: &fMy advice is to start by visiting the &bFarm&f, or the &bCoal Mine &fboth North of here.")), 30);
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),60);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Duke: &fIf you do need some wood, the best place to get some is West of the &bVillage&f!")), 60);
        }

        if (NpcName.equalsIgnoreCase("Lynn")){
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),0);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Lynn: &fIf you ever get lost during a quest, open your Quest Log in your &aSkyBlock Menu&f!")),0);
        }

        if (NpcName.equalsIgnoreCase("Stella")){
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),0);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Stella: &fAt any time you can create a Co-op with your friends!")),0);
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),30);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Stella: &fSimply go in your &aSkyBlock Menu &f  where you can find the &aProfile Menu&f.")), 30);
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),60);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Stella: &fThis is where you can create, delete or switch SkyBlock Profiles.")), 60);
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),90);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Stella: &fEnter coop followed by the name of all the friends you want to invite!")), 90);
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),120);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Stella: &fAll your friends have to be online to accept!")), 120);
        }

        if (NpcName.equalsIgnoreCase("Vex")){
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),0);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Vex: &fYou can shift click any player to trade with them!")),0);
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),30);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Vex: &fOnce both players are ready to trade, click on &aAccept trade&f!")), 30);
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),60);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Vex: &fMake sure you don't give away all of your belongings!")), 60);
        }

        if (NpcName.equalsIgnoreCase("Liam")){
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),0);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Liam: &fOne day those houses in the Village will be rentable for Coins!")),0);
            SUtil.delay(() -> p.playSound(Ploc,sound,1.0f,1.0f),30);
            SUtil.delay(() -> p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&e[NPC] Liam: &fAnyone will be able to rent them, players, co-ops, even Guilds!")), 30);
        }
    }
}
