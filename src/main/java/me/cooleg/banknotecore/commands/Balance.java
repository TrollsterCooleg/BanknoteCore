package me.cooleg.banknotecore.commands;

import me.cooleg.banknotecore.BanknoteCore;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Balance implements CommandExecutor {
    BanknoteCore main;
    public Balance(BanknoteCore banknoteCore) {
        main = banknoteCore;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            sender.sendMessage(ChatColor.GOLD + "Balance: " + ChatColor.GREEN + main.manager.getProfile(((Player) sender).getUniqueId()).get().getBal());
        }
        return true;
    }
}
