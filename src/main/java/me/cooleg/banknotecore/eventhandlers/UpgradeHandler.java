package me.cooleg.banknotecore.eventhandlers;

import me.cooleg.banknotecore.BanknoteCore;
import me.cooleg.banknotecore.profiles.PlayerProfile;
import me.cooleg.banknotecore.util.GenPrices;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.UUID;

public class UpgradeHandler implements Listener {

    HashMap<UUID, Long> map = new HashMap<>();

    @EventHandler
    public void genUpgrade(PlayerInteractEvent e) {
        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {return;}
        if (!map.containsKey(e.getPlayer().getUniqueId()) || map.get(e.getPlayer().getUniqueId()) <= System.currentTimeMillis()) {
            map.put(e.getPlayer().getUniqueId(), System.currentTimeMillis() + 1000);
            for (GenPrices genPrices : GenPrices.values()) {
                if (genPrices.block == e.getClickedBlock().getType()) {
                    int newLevel = genPrices.level + 1;
                    for (GenPrices genPricesv2 : GenPrices.values()) {
                        if (genPricesv2.level == newLevel) {
                            PlayerProfile profile = BanknoteCore.getMain().manager.getProfile(e.getPlayer().getUniqueId()).get();
                            int bal = profile.getBal();
                            if (bal >= genPricesv2.price) {
                                profile.removeFromBal(genPricesv2.price);
                                e.getClickedBlock().setType(genPricesv2.block);
                                return;
                            } else {
                                e.getPlayer().sendMessage(ChatColor.RED + "You don't have enough money! You need " + genPricesv2.price);
                                return;
                            }
                        }
                    }
                } else {continue;}
            }
        }
    }
}
