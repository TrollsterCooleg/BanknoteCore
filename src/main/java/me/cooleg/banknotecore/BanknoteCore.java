package me.cooleg.banknotecore;

import me.cooleg.banknotecore.commands.Balance;
import me.cooleg.banknotecore.commands.Shop;
import me.cooleg.banknotecore.eventhandlers.BombHandler;
import me.cooleg.banknotecore.eventhandlers.GuiHandlers;
import me.cooleg.banknotecore.eventhandlers.MiscHandlers;
import me.cooleg.banknotecore.eventhandlers.UpgradeHandler;
import me.cooleg.banknotecore.util.Placeholder;
import me.cooleg.playerstore.PlayerStore;
import me.cooleg.playerstore.StorageAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class BanknoteCore extends JavaPlugin {

    private PlayerStore playerStore = (PlayerStore) Bukkit.getServer().getPluginManager().getPlugin("PlayerStore");
    public StorageAPI storageAPI = playerStore.api;

    public Shop shop;
    private static BanknoteCore main;

    @Override
    public void onEnable() {
        main = this;
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        new CoreRunnables(this);
        new Placeholder(this).register();
        registerCommands();
        registerEvents();
    }

    private void registerCommands() {
        getCommand("shop").setExecutor(shop = new Shop());
        getCommand("bal").setExecutor(new Balance(this));
    }

    private void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new GuiHandlers(), this);
        Bukkit.getPluginManager().registerEvents(new MiscHandlers(), this);
        Bukkit.getPluginManager().registerEvents(new BombHandler(), this);
        Bukkit.getPluginManager().registerEvents(new UpgradeHandler(), this);
    }

    public static BanknoteCore getMain() {
        return main;
    }

}
