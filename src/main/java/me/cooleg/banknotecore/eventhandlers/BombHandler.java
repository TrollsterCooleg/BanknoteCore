package me.cooleg.banknotecore.eventhandlers;

import me.cooleg.banknotecore.BanknoteCore;
import me.cooleg.banknotecore.util.ExplosiveBlocks;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.HashSet;

public class BombHandler implements Listener {

    private final BanknoteCore main = BanknoteCore.getMain();
    private final NamespacedKey key = new NamespacedKey(main, "bomblevel");

    @EventHandler
    public void bombPlace(BlockPlaceEvent e) {
        ItemStack item = e.getItemInHand();
        if (item.getType() == Material.PLAYER_HEAD) {
            doExplosion(e.getBlockPlaced().getLocation(), getBombLevel(item));
        }
    }

    private void doExplosion(Location loc, int lvl) {
        if (lvl == -1) {return;}
        loc.getBlock().setType(Material.AIR);
        loc.getWorld().createExplosion(loc, 0);
        HashMap<Material, Integer> defense = new HashMap<>();
        for (ExplosiveBlocks explosiveBlocks : ExplosiveBlocks.values()) {
            defense.put(explosiveBlocks.material, explosiveBlocks.level);
        }
        HashSet<Block> blocks = new HashSet<>();
        for (int i = -1; i<2; i++) {
            Location newLoc = loc.clone();
            newLoc.setX(loc.getX() + i);
            if (blocks.contains(newLoc.getBlock())) {continue;}
            blocks.add(newLoc.getBlock());
        }
        for (int i = -1; i<2; i++) {
            Location newLoc = loc.clone();
            newLoc.setY(loc.getY() + i);
            if (blocks.contains(newLoc.getBlock())) {continue;}
            blocks.add(newLoc.getBlock());
        }
        for (int i = -1; i<2; i++) {
            Location newLoc = loc.clone();
            newLoc.setZ(loc.getZ() + i);
            if (blocks.contains(newLoc.getBlock())) {continue;}
            blocks.add(newLoc.getBlock());
        }
        for (Block block : blocks) {
            if (defense.containsKey(block.getType())) {
                if (lvl >= defense.get(block.getType())) {
                    block.setType(Material.AIR);
                }
            }
        }
    }

    private int getBombLevel(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer data = meta.getPersistentDataContainer();
        if (!data.has(key, PersistentDataType.INTEGER)) {return -1;}
        return data.get(key, PersistentDataType.INTEGER);
    }

}
