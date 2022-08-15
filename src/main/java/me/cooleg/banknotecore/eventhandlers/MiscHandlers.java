package me.cooleg.banknotecore.eventhandlers;

import me.cooleg.banknotecore.BanknoteCore;
import me.cooleg.banknotecore.profiles.PlayerProfile;
import me.cooleg.banknotecore.util.GenPrices;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Set;

public class MiscHandlers implements Listener {

    private BanknoteCore main = BanknoteCore.getMain();

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (e.getItem() == null) {return;}
            if (!e.getItem().getType().equals(Material.PAPER)) {
                return;
            }
            PersistentDataContainer contain = e.getItem().getItemMeta().getPersistentDataContainer();
            NamespacedKey amount = new NamespacedKey(main, "amount");
            if (!contain.getKeys().contains(amount)) {return;}
            int total = 0;
            e.setCancelled(true);
            for (int i = 0; i < e.getPlayer().getInventory().getSize(); i++) {
                ItemStack item = e.getPlayer().getInventory().getItem(i);
                if (item == null) {continue;}
                if (!item.getType().equals(Material.PAPER)) {continue;}
                PersistentDataContainer container = item.getItemMeta().getPersistentDataContainer();
                if (!container.getKeys().contains(amount)) {continue;}
                int storedamount = container.get(amount, PersistentDataType.INTEGER);
                storedamount *= item.getAmount();
                total += storedamount;
                e.getPlayer().getInventory().remove(item);
            }
            PlayerProfile profile = main.manager.getProfile(e.getPlayer().getUniqueId()).get();
            profile.addToBal(total);
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        main.storageAPI.createCustom(e.getPlayer().getUniqueId(), "PERMANENT");
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Material b = e.getBlock().getType();
        Location bloc = e.getBlock().getLocation();
        for (GenPrices gen : GenPrices.values()) {
            if (b.equals(gen.block)) {
                ItemStack item = new ItemStack(gen.block);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(ChatColor.BLUE + "Level " +gen.level + " Gen");
                item.setItemMeta(meta);
                e.getPlayer().getInventory().addItem(item);
                FileConfiguration config = main.getConfig();
                Set<String> keys = config.getKeys(false);
                for (String s : keys) {
                    Set<String> deepKeys = config.getConfigurationSection(s).getKeys(false) ;
                    for (String str : deepKeys) {
                        if (config.getLocation(s+"."+str).equals(bloc)) {
                            config.set(s+"."+str, null);
                            main.saveConfig();
                            return;
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        for (GenPrices gen : GenPrices.values()) {
            if (e.getBlock().getType().equals(gen.block)) {
                int gencount = main.storageAPI.getInt(e.getPlayer().getUniqueId(), "genCount");
                main.storageAPI.storeInt(e.getPlayer().getUniqueId(), "genCount", gencount+1);
                main.getConfig().set(e.getPlayer().getUniqueId()+"."+gencount, e.getBlock().getLocation());
                main.saveConfig();
                return;
            }
        }
        return;
    }
}
