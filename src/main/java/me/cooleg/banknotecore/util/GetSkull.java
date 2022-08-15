package me.cooleg.banknotecore.util;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;

public class GetSkull {

    public static ItemStack getSkull(String texture) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        GameProfile gameProfile = new GameProfile(UUID.fromString("3a8b8128-179e-43c2-978f-f3d612f55f19"), null);
        gameProfile.getProperties().put("textures", new Property(null, texture));
        try {
            Method method = meta.getClass().getDeclaredMethod("setProfile", GameProfile.class);
            method.setAccessible(true);
            method.invoke(meta, gameProfile);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        skull.setItemMeta(meta);
        return skull;
    }

}
