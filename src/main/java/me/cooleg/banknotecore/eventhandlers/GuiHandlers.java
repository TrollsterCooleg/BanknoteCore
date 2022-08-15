package me.cooleg.banknotecore.eventhandlers;

import me.cooleg.banknotecore.BanknoteCore;
import me.cooleg.banknotecore.commands.Shop;
import me.cooleg.banknotecore.util.GenPrices;
import me.cooleg.banknotecore.util.ShopPrices;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiHandlers implements Listener {

    BanknoteCore main = BanknoteCore.getMain();

    @EventHandler
    public void inventoryClick(InventoryClickEvent e) {
        if ((ChatColor.translateAlternateColorCodes('&', e.getView().getTitle())).equals(ChatColor.BLUE + "Shop")) {
            mainShopClick(e);
            e.setCancelled(true);
            return;
        }
        if ((ChatColor.translateAlternateColorCodes('&', e.getView().getTitle())).equals(ChatColor.BLUE + "Gen Shop")) {
            genShopClick(e);
            e.setCancelled(true);
            return;
        }
        if ((ChatColor.translateAlternateColorCodes('&', e.getView().getTitle())).equals(ChatColor.BLUE + "Defense shop")) {
            defenseShopClick(e);
            e.setCancelled(true);
            return;
        }
        if ((ChatColor.translateAlternateColorCodes('&', e.getView().getTitle())).equals(ChatColor.BLUE + "Raiding Shop")) {
            raidShopClick(e);
            e.setCancelled(true);
            return;
        }
        if ((ChatColor.translateAlternateColorCodes('&', e.getView().getTitle())).equals(ChatColor.BLUE + "Misc Shop")) {
            miscShopClick(e);
            e.setCancelled(true);
            return;
        }
    }

    private void mainShopClick(InventoryClickEvent e) {
        if (e.getSlot() == 10) {((Player) e.getWhoClicked()).performCommand("/buy"); return;}
        if (e.getSlot() == 13) {main.shop.openGenShop((Player) e.getWhoClicked()); return;}
        if (e.getSlot() == 14) {main.shop.openDefenseShop((Player) e.getWhoClicked()); return;}
        if (e.getSlot() == 15) {main.shop.openRaidingShop((Player) e.getWhoClicked()); return;}
        if (e.getSlot() == 16) {main.shop.openMiscShop((Player) e.getWhoClicked()); return;}
    }

    private void genShopClick(InventoryClickEvent e) {
        if (e.getSlot() == 13) {
            int bal = main.storageAPI.getInt(e.getWhoClicked().getUniqueId(), "balance");
            if (GenPrices.WHITE.price > bal) {return;}
            main.storageAPI.storeInt(e.getWhoClicked().getUniqueId(), "balance", bal - GenPrices.WHITE.price);
            ItemStack item = Shop.gen1;
            ItemMeta meta = item.getItemMeta();
            meta.setLore(null);
            item.setItemMeta(meta);
            (e.getWhoClicked()).getInventory().addItem(item);
            return;
        }
    }

    private void defenseShopClick(InventoryClickEvent e) {
        if (e.getSlot() == 10) {
            int bal = main.storageAPI.getInt(e.getWhoClicked().getUniqueId(), "balance");
            if (ShopPrices.DEFENSE_0.price > bal) {return;}
            main.storageAPI.storeInt(e.getWhoClicked().getUniqueId(), "balance", bal - ShopPrices.DEFENSE_0.price);
            ItemStack item = Shop.def0;
            ItemMeta meta = item.getItemMeta();
            meta.setLore(null);
            item.setItemMeta(meta);
            (e.getWhoClicked()).getInventory().addItem(item);
            return;
        }
        if (e.getSlot() == 12) {
            int bal = main.storageAPI.getInt(e.getWhoClicked().getUniqueId(), "balance");
            if (ShopPrices.DEFENSE_1.price > bal) {return;}
            main.storageAPI.storeInt(e.getWhoClicked().getUniqueId(), "balance", bal - ShopPrices.DEFENSE_1.price);
            ItemStack item = Shop.def1;
            ItemMeta meta = item.getItemMeta();
            meta.setLore(null);
            item.setItemMeta(meta);
            (e.getWhoClicked()).getInventory().addItem(item);
            return;
        }
        if (e.getSlot() == 14) {
            int bal = main.storageAPI.getInt(e.getWhoClicked().getUniqueId(), "balance");
            if (ShopPrices.DEFENSE_2.price > bal) {return;}
            main.storageAPI.storeInt(e.getWhoClicked().getUniqueId(), "balance", bal - ShopPrices.DEFENSE_2.price);
            ItemStack item = Shop.def2;
            ItemMeta meta = item.getItemMeta();
            meta.setLore(null);
            item.setItemMeta(meta);
            (e.getWhoClicked()).getInventory().addItem(item);
            return;
        }
        if (e.getSlot() == 16) {
            int bal = main.storageAPI.getInt(e.getWhoClicked().getUniqueId(), "balance");
            if (ShopPrices.DEFENSE_3.price > bal) {return;}
            main.storageAPI.storeInt(e.getWhoClicked().getUniqueId(), "balance", bal - ShopPrices.DEFENSE_3.price);
            ItemStack item = Shop.def3;
            ItemMeta meta = item.getItemMeta();
            meta.setLore(null);
            item.setItemMeta(meta);
            (e.getWhoClicked()).getInventory().addItem(item);
            return;
        }
    }

    private void raidShopClick(InventoryClickEvent e) {
        // Doesnt cost money yet as its just for testing right now
        if (e.getSlot() == 11) {
            int bal = main.storageAPI.getInt(e.getWhoClicked().getUniqueId(), "balance");
            if (ShopPrices.BOMB_1.price > bal) {return;}
            main.storageAPI.storeInt(e.getWhoClicked().getUniqueId(), "balance", bal - ShopPrices.BOMB_1.price);
            ItemStack item = Shop.bomb1;
            ItemMeta meta = item.getItemMeta();
            meta.setLore(null);
            item.setItemMeta(meta);
            (e.getWhoClicked()).getInventory().addItem(item);
            return;
        }
        if (e.getSlot() == 13) {
            int bal = main.storageAPI.getInt(e.getWhoClicked().getUniqueId(), "balance");
            if (ShopPrices.BOMB_2.price > bal) {return;}
            main.storageAPI.storeInt(e.getWhoClicked().getUniqueId(), "balance", bal - ShopPrices.BOMB_2.price);
            ItemStack item = Shop.bomb2;
            ItemMeta meta = item.getItemMeta();
            meta.setLore(null);
            item.setItemMeta(meta);
            (e.getWhoClicked()).getInventory().addItem(item);
            return;
        }
        if (e.getSlot() == 15) {
            int bal = main.storageAPI.getInt(e.getWhoClicked().getUniqueId(), "balance");
            if (ShopPrices.BOMB_3.price > bal) {return;}
            main.storageAPI.storeInt(e.getWhoClicked().getUniqueId(), "balance", bal - ShopPrices.BOMB_3.price);
            ItemStack item = Shop.bomb3;
            ItemMeta meta = item.getItemMeta();
            meta.setLore(null);
            item.setItemMeta(meta);
            (e.getWhoClicked()).getInventory().addItem(item);
            return;
        }
    }

    private void miscShopClick(InventoryClickEvent e) {
        if (e.getSlot() == 15) {
            int bal = main.storageAPI.getInt(e.getWhoClicked().getUniqueId(), "balance");
            if (1000 > bal) {return;}
            main.storageAPI.storeInt(e.getWhoClicked().getUniqueId(), "balance", bal - 1000);
            ItemStack item = Shop.misc1;
            ItemMeta meta = item.getItemMeta();
            meta.setLore(null);
            item.setItemMeta(meta);
            (e.getWhoClicked()).getInventory().addItem(item);
            return;
        }
    }

}
