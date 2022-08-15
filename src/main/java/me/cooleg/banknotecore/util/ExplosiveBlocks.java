package me.cooleg.banknotecore.util;

import org.bukkit.Material;

import java.util.logging.Level;

public enum ExplosiveBlocks {

    Tier0(Material.STONE, 0),
    Tier1(Material.COBBLED_DEEPSLATE, 1),
    Tier2(Material.DEEPSLATE_BRICKS, 2),
    Tier3(Material.DEEPSLATE_TILES, 3);


    public final Material material;
    public final int level;

    ExplosiveBlocks(Material material, int level) {
        this.material = material;
        this.level = level;
    }
}
