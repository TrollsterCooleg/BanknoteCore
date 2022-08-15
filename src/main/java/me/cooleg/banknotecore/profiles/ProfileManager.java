package me.cooleg.banknotecore.profiles;

import me.cooleg.banknotecore.BanknoteCore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

public class ProfileManager implements Listener {

    HashMap<UUID, PlayerProfile> profileMap = new HashMap<>();

    @EventHandler
    public void createProfile(PlayerJoinEvent e) {
        PlayerProfile profile = new PlayerProfile(e.getPlayer().getUniqueId());
        profileMap.put(e.getPlayer().getUniqueId(), profile);
    }

    @EventHandler
    public void closeProfile(PlayerQuitEvent e) {
        PlayerProfile profile = profileMap.get(e.getPlayer().getUniqueId());
        profile.saveProfile();
        profileMap.remove(e.getPlayer().getUniqueId());
    }

    public Optional<PlayerProfile> getProfile(UUID id) {
        if (!profileMap.containsKey(id)) {return Optional.empty();}
        PlayerProfile profile = profileMap.get(id);
        return Optional.of(profile);
    }


}
