package me.venacava.bloodandsilver;

import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerSkin;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

public class BloodAndSilver extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }

        /*
         * 1. Creating a new Category
         * This Category will use the following ItemStack
         */
        ItemStack bloSilItem = new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDMxY2Q3ZWQ0ZTRiZjA3YzNkZmQ5YmE0OTg3MDhlNzMwZTY5ZDgwNzMzNWFmZmFiYzEyZDg3ZmY1NDJmNmE4OCJ9fX0=")),
                "&4Blood & Silver",
                "",
                "&a> Click to open");

        // Give your Category a unique id.
        NamespacedKey bloSilId = new NamespacedKey(this, "bloodandsilver");
        ItemGroup itemGroup = new ItemGroup(bloSilId, bloSilItem);

        // Create Item
        SlimefunItemStack holyWater = new SlimefunItemStack("BS_HOLY_WATER", Material.POTION, "&fHoly Water", "");

        PotionMeta meta = (PotionMeta) holyWater.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType).WATER));
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        holyWater.setItemMeta(meta);
        
        // Crafting Recipe
        ItemStack[] holyWaterRecipe = {
            SlimefunItems.SALT,                     new ItemStack(Material.POTION),     null,
            null,                                   null,                               null,
            null,                                   null,                               null
            };

        // Register Item & Recipe
        SlimefunItem item = new SlimefunItem(itemGroup, holyWater, RecipeType.ENHANCED_CRAFTING_TABLE, holyWaterRecipe);
        item.register(this);
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }

}
