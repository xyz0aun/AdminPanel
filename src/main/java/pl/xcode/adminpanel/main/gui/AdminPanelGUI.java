package pl.xcode.adminpanel.main.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import pl.xcode.adminpanel.main.Main;
import pl.xcode.adminpanel.main.item.ItemBuilder;
import pl.xcode.adminpanel.main.utils.ChatUtil;

import java.util.Arrays;

public class AdminPanelGUI {


    public static void AdminPanel(Player p) {

        Inventory inv = Bukkit.createInventory(p, 45, (ChatUtil.fixColor(Main.getPlugin().getConfig().getString("Panel.GUI_NAME"))));


        ItemBuilder glass = (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7).setTitle(ChatUtil.fixColor("&0.")));


        ItemBuilder tnt = (new ItemBuilder(Material.TNT))
                .setTitle(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("Panel.TNT_NAME")))
                .addLores(Arrays.asList(ChatUtil.fixColor(" "), ChatUtil.fixColor("&8>> &7Aktualny status: " + (ChatUtil.fixColor(Main.PanelCahe().isTnt() ? "&a&lWLACZONE" : "&c&lWYLACZONE" )))));


        ItemBuilder diamond_helmet = (new ItemBuilder(Material.DIAMOND_HELMET))
                .setTitle(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("Panel.DIAMOND_HELMET_NAME")))
                .addLores(Arrays.asList(ChatUtil.fixColor(" "), ChatUtil.fixColor("&8>> &7Aktualny status: " + (ChatUtil.fixColor(Main.PanelCahe().isKit() ? "&a&lWLACZONE" : "&c&lWYLACZONE" )))));


        ItemBuilder enchant = (new ItemBuilder(Material.ENCHANTMENT_TABLE))
                .setTitle(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("Panel.ENCHANT_NAME")))
                .addLores(Arrays.asList(ChatUtil.fixColor(" "), ChatUtil.fixColor("&8>> &7Aktualny status: " + (ChatUtil.fixColor(Main.PanelCahe().isEnchant() ? "&a&lWLACZONE" : "&c&lWYLACZONE" )))));


        ItemBuilder diamond = (new ItemBuilder(Material.DIAMOND))
                .setTitle(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("Panel.DIAMOND_NAME")))
                .addLores(Arrays.asList(ChatUtil.fixColor(" "), ChatUtil.fixColor("&8>> &7Aktualny status: " + (ChatUtil.fixColor(Main.PanelCahe().isCrafting() ? "&a&lWLACZONE" : "&c&lWYLACZONE" )))));


        ItemBuilder pearl = (new ItemBuilder(Material.ENDER_PEARL))
                .setTitle(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("Panel.PEARL_NAME")))
                .addLores(Arrays.asList(ChatUtil.fixColor(" "), ChatUtil.fixColor("&8>> &7Aktualny status: " + (ChatUtil.fixColor(Main.PanelCahe().isPearl() ? "&a&lWLACZONE" : "&c&lWYLACZONE" )))));


        ItemBuilder sword = (new ItemBuilder(Material.DIAMOND_SWORD))
                .setTitle(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("Panel.SWORD_NAME")))
                .addLores(Arrays.asList(ChatUtil.fixColor(" "), ChatUtil.fixColor("&8>> &7Aktualny status: " + (ChatUtil.fixColor(Main.PanelCahe().isSword() ? "&a&lWLACZONE" : "&c&lWYLACZONE" )))));

        ItemBuilder barrier = (new ItemBuilder(Material.BARRIER))
                .setTitle(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("Panel.BARRIER_NAME")))
                .addLores(Arrays.asList(ChatUtil.fixColor(" "), ChatUtil.fixColor("&8>> &7Zamkniecie panelu")));

        ItemBuilder paper = (new ItemBuilder(Material.PAPER))
                .setTitle(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("Panel.PAPER_NAME")))
                .addLores(Arrays.asList(ChatUtil.fixColor(" "), ChatUtil.fixColor("&8>> &7Otwieranie managera")));



        for(int i = 0; i < 45; i++){
            inv.setItem(i, glass.build());
        }

        inv.setItem(11, tnt.build());
        inv.setItem(13, diamond_helmet.build());
        inv.setItem(15, enchant.build());
        inv.setItem(21, diamond.build());
        inv.setItem(23, pearl.build());
        inv.setItem(31, sword.build());
        inv.setItem(36, paper.build());
        inv.setItem(44, barrier.build());

        p.openInventory(inv);
    }
}
