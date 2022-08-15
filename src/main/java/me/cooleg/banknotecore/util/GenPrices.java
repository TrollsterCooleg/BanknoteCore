package me.cooleg.banknotecore.util;

import org.bukkit.Material;

public enum GenPrices {

    WHITE(1, 50, Material.WHITE_STAINED_GLASS),
    RED(2, 120, Material.RED_STAINED_GLASS),
    ORANGE(3, 270, Material.ORANGE_STAINED_GLASS),
    PINK(4, 580, Material.PINK_STAINED_GLASS),
    YELLOW(5, 1250, Material.YELLOW_STAINED_GLASS),
    LIME(6, 2700, Material.LIME_STAINED_GLASS),
    GREEN(7, 2700, Material.GREEN_STAINED_GLASS),
    CYAN(8, 2700, Material.CYAN_STAINED_GLASS),
    BLUE(9, 2700, Material.BLUE_STAINED_GLASS),
    PURPLE(10, 2700, Material.PURPLE_STAINED_GLASS),
    BROWN(11, 6000, Material.BROWN_STAINED_GLASS),
    GRAY(12, 13500, Material.GRAY_STAINED_GLASS),
    BLACK(13, 30000, Material.BLACK_STAINED_GLASS);

    public final int level;
    public final int price;
    public final Material block;


    GenPrices(int level, int price, Material block) {
        this.level = level;
        this.price = price;
        this.block = block;
    }

}
