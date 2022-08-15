package me.cooleg.banknotecore.util;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.cooleg.banknotecore.BanknoteCore;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

public class Placeholder extends PlaceholderExpansion {

    BanknoteCore main;
    public Placeholder(BanknoteCore banknoteCore) {
        main = banknoteCore;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "banknote";
    }

    @Override
    public @NotNull String getAuthor() {
        return "cooleg";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if (params.equals("bal")) {return String.valueOf(main.storageAPI.getInt(player.getUniqueId(), "balance"));}
        return "";
    }
}
