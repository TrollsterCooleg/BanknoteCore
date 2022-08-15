package me.cooleg.banknotecore;

import me.cooleg.banknotecore.util.GenPrices;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.Set;

public class CoreRunnables {
    BanknoteCore main;
    FileConfiguration config;
    public CoreRunnables(BanknoteCore banknoteCore) {
        main = banknoteCore;
        config = main.getConfig();
        startRunnable();
    }

    private void startRunnable() {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (config.getKeys(false).isEmpty()) {return;}
                for (String s : config.getKeys(false)) {
                    Set<String> deepKeys = config.getConfigurationSection(s).getKeys(false);
                    for (String str : deepKeys) {
                        Location loc = config.getLocation(s + "." + str);
                        Location testLoc = new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ());
                        testLoc.setY(testLoc.getY()+1);
                        if (!testLoc.getBlock().getType().equals(Material.AIR)) {
                            while (true) {
                                testLoc.setY(testLoc.getY()+1);
                                if (testLoc.getBlock().getType().equals(Material.AIR)) {break;}
                            }
                        }
                        testLoc.setY(testLoc.getY()+.1);
                        testLoc.setX(testLoc.getX()+.5);
                        testLoc.setZ(testLoc.getZ()+.5);
                        ItemStack note = new ItemStack(Material.PAPER);
                        ItemMeta meta = note.getItemMeta();
                        meta.setDisplayName("Unknown Generator");
                        int value = -1;
                        for (GenPrices gen : GenPrices.values()) {
                            if (!loc.getBlock().getType().equals(gen.block)) {continue;}
                            if (gen.level == 1) {value = 5; break;}
                            value = (gen.level * 10) - 10;
                            break;
                        }
                        if (value != -1) {
                            meta.setDisplayName(ChatColor.BLUE + "Banknote");
                            meta.setLore(Arrays.asList(plain("Amount: " + value)));
                            PersistentDataContainer data = meta.getPersistentDataContainer();
                            NamespacedKey amountKey = new NamespacedKey(main, "amount");
                            data.set(amountKey, PersistentDataType.INTEGER, value);
                        }
                        note.setItemMeta(meta);
                        Bukkit.getWorld("world").dropItem(testLoc, note);
                    }
                }
            }
        }.runTaskTimer(main, 300, 300);
    }

    private static String plain(String s) {
        return ChatColor.WHITE + s;
    }

}
