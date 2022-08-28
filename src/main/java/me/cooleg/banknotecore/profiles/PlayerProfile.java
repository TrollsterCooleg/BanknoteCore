package me.cooleg.banknotecore.profiles;

import me.cooleg.banknotecore.BanknoteCore;

import java.util.UUID;

public class PlayerProfile {

    private final UUID id;
    private int bal;

    public PlayerProfile(UUID id) {
        this.id = id;
        bal = BanknoteCore.getMain().storageAPI.getInt(id, "balance");
    }

    public UUID getUUID() {return id;}
    public int getBal() {return bal;}
    public void setBal(int bal) {this.bal = bal;}
    public void addToBal(int num) {bal += num;}
    public void removeFromBal(int num) {bal -= num;}

    public void saveProfile() {BanknoteCore.getMain().storageAPI.storeInt(id, "balance", bal);}

}
