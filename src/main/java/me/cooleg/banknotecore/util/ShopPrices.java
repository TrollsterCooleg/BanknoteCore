package me.cooleg.banknotecore.util;

import org.bukkit.inventory.ItemStack;

public enum ShopPrices {

    BOMB_1(20000),
    BOMB_2(50000),
    BOMB_3(100000),
    DEFENSE_0(100),
    DEFENSE_1(10000),
    DEFENSE_2(25000),
    DEFENSE_3(50000);


    public final int price;
    ShopPrices(int price) {
        this.price = price;
    }

}
