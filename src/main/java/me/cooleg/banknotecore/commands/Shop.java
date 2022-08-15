package me.cooleg.banknotecore.commands;

import me.cooleg.banknotecore.BanknoteCore;
import me.cooleg.banknotecore.util.GenPrices;
import me.cooleg.banknotecore.util.GetSkull;
import me.cooleg.banknotecore.util.ShopPrices;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Shop implements CommandExecutor {
    private final NamespacedKey key = new NamespacedKey(BanknoteCore.getMain(), "bomblevel");
    private static final ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
    private static final ItemStack shopItem = new ItemStack(Material.TRIPWIRE_HOOK);
    private static final ItemStack genItem = new ItemStack(Material.RED_STAINED_GLASS);
    private static final ItemStack defenseItem = new ItemStack(Material.SHIELD);
    private static final ItemStack raidItem = new ItemStack(Material.TNT);
    private static final ItemStack miscItem = new ItemStack(Material.CHEST);
    public static final ItemStack bomb1 = GetSkull.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzhkMjZjNDI5M2ZhYWQ3ZTBmZDFlOTFjNzFkYzU4YjRlYmMzOGM5MGRhYmFjOTE1NTU5NzY4ZDJkOWY0YWYifX19");
    public static final ItemStack bomb2 = GetSkull.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmM5MmUzZjQ1YjQ5ZTQwNTY3MDIyNDg5MmY5M2ViYzg0ZmE3ZjhjOTZjMzZhYWIyNGE4ODU0ZjJjYmYwYjgifX19");
    public static final ItemStack bomb3 = GetSkull.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjg4ZmI2YjJiM2VmYTZhYjI5OWY5ZjRlN2Q4YzFhMWQ3MzM4NzUzYmRmOGZlZjgxMDc1ZjIxNTU5NDNiYzY5In19fQ==");
    public static final ItemStack gen1 = new ItemStack(Material.WHITE_STAINED_GLASS);
    public static final ItemStack def0 = new ItemStack(Material.STONE);
    public static final ItemStack def1 = new ItemStack(Material.COBBLED_DEEPSLATE);
    public static final ItemStack def2 = new ItemStack(Material.DEEPSLATE_BRICKS);
    public static final ItemStack def3 = new ItemStack(Material.DEEPSLATE_TILES);
    public static final ItemStack misc1 = new ItemStack(Material.STONE_SWORD);
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {openMainShop((Player) sender); return true;}
        return false;
    }

    public void openMainShop(Player p) {
        Inventory inv = Bukkit.createInventory(p, 27, ChatColor.BLUE + "Shop");
        for (int i = 0; i < 27; i++) {
            inv.setItem(i, filler);
        }
        inv.setItem(10, shopItem);
        inv.setItem(13, genItem);
        inv.setItem(14, defenseItem);
        inv.setItem(15, raidItem);
        inv.setItem(16, miscItem);
        p.openInventory(inv);
    }

    public void openGenShop(Player p) {
        Inventory inv = Bukkit.createInventory(p, 27, ChatColor.BLUE + "Gen Shop");
        for (int i = 0; i < 27; i++) {
            inv.setItem(i, filler);
        }
        inv.setItem(13, gen1);
        p.openInventory(inv);
    }

    public void openDefenseShop(Player p) {
        Inventory inv = Bukkit.createInventory(p, 27, ChatColor.BLUE + "Defense Shop");
        for (int i = 0; i < 27; i++) {
            inv.setItem(i, filler);
        }
        inv.setItem(10, def0);
        inv.setItem(12, def1);
        inv.setItem(14, def2);
        inv.setItem(16, def3);
        p.openInventory(inv);
    }

    public void openRaidingShop(Player p) {
        Inventory inv = Bukkit.createInventory(p, 27, ChatColor.BLUE + "Raiding Shop");
        for (int i = 0; i < 27; i++) {
            inv.setItem(i, filler);
        }
        inv.setItem(11, bomb1);
        inv.setItem(13, bomb2);
        inv.setItem(15, bomb3);
        p.openInventory(inv);
    }

    public void openMiscShop(Player p) {
        Inventory inv = Bukkit.createInventory(p, 27, ChatColor.BLUE + "Misc Shop");
        for (int i = 0; i < 27; i++) {
            inv.setItem(i, filler);
        }
        inv.setItem(15, misc1);
        p.openInventory(inv);
    }

    static {
        NamespacedKey key = new NamespacedKey(BanknoteCore.getMain(), "bomblevel");
        ItemMeta fillerMeta = filler.getItemMeta();
        fillerMeta.setDisplayName(" ");
        filler.setItemMeta(fillerMeta);
        ItemMeta genMeta = genItem.getItemMeta();
        genMeta.setDisplayName(ChatColor.BLUE + "Open Generator Shop");
        genItem.setItemMeta(genMeta);
        ItemMeta defMeta = defenseItem.getItemMeta();
        defMeta.setDisplayName(ChatColor.BLUE + "Open Defense Shop");
        defenseItem.setItemMeta(defMeta);
        ItemMeta raidMeta = raidItem.getItemMeta();
        raidMeta.setDisplayName(ChatColor.BLUE + "Open Raiding Shop");
        raidItem.setItemMeta(raidMeta);
        ItemMeta miscMeta = miscItem.getItemMeta();
        miscMeta.setDisplayName(ChatColor.BLUE + "Open Misc Shop");
        miscItem.setItemMeta(miscMeta);
        ItemMeta shopMeta = shopItem.getItemMeta();
        shopMeta.setDisplayName(ChatColor.BLUE + "Open Buycraft Shop");
        shopItem.setItemMeta(shopMeta);
        ItemMeta bomb1Meta = bomb1.getItemMeta();
        bomb1Meta.setDisplayName(ChatColor.YELLOW + "Tier 1 Explosive");
        bomb1Meta.setLore(Arrays.asList(plain("Price: " + ChatColor.GOLD + ShopPrices.BOMB_1.price)));
        bomb1Meta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, 1);
        bomb1.setItemMeta(bomb1Meta);
        ItemMeta bomb2Meta = bomb2.getItemMeta();
        bomb2Meta.setDisplayName(ChatColor.YELLOW + "Tier 2 Explosive");
        bomb2Meta.setLore(Arrays.asList(plain("Price: " + ChatColor.GOLD + ShopPrices.BOMB_2.price)));
        bomb2Meta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, 2);
        bomb2.setItemMeta(bomb2Meta);
        ItemMeta bomb3Meta = bomb3.getItemMeta();
        bomb3Meta.setDisplayName(ChatColor.YELLOW + "Tier 3 Explosive");
        bomb3Meta.setLore(Arrays.asList(plain("Price: " + ChatColor.GOLD + ShopPrices.BOMB_3.price)));
        bomb3Meta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, 3);
        bomb3.setItemMeta(bomb3Meta);
        ItemMeta gen1Meta = gen1.getItemMeta();
        gen1Meta.setDisplayName(ChatColor.BLUE + "Level 1 Gen");
        gen1Meta.setLore(Arrays.asList(plain("Price: " + ChatColor.GOLD + GenPrices.WHITE.price)));
        gen1.setItemMeta(gen1Meta);
        ItemMeta def0Meta = def0.getItemMeta();
        def0Meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Building Block");
        def0Meta.setLore(Arrays.asList(plain("Price: " + ChatColor.GOLD + ShopPrices.DEFENSE_0.price)));
        def0.setItemMeta(def0Meta);
        ItemMeta def1Meta = def1.getItemMeta();
        def1Meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Tier 1 Defense Block");
        def1Meta.setLore(Arrays.asList(plain("Price: " + ChatColor.GOLD + ShopPrices.DEFENSE_1.price)));
        def1.setItemMeta(def1Meta);
        ItemMeta def2Meta = def2.getItemMeta();
        def2Meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Tier 2 Defense Block");
        def2Meta.setLore(Arrays.asList(plain("Price: " + ChatColor.GOLD + ShopPrices.DEFENSE_2.price)));
        def2.setItemMeta(def2Meta);
        ItemMeta def3Meta = def3.getItemMeta();
        def3Meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Tier 3 Defense Block");
        def3Meta.setLore(Arrays.asList(plain("Price: " + ChatColor.GOLD + ShopPrices.DEFENSE_3.price)));
        def3.setItemMeta(def3Meta);
        ItemMeta misc1Meta = misc1.getItemMeta();
        misc1Meta.setDisplayName(ChatColor.RED + "Cool Sword");
        misc1Meta.setLore(Arrays.asList(plain("Price: " + ChatColor.GOLD + "1000")));
        misc1Meta.setUnbreakable(true);
        misc1.setItemMeta(misc1Meta);
    }

    private static String plain(String s) {
        return ChatColor.WHITE + s;
    }


}
