package pl.xcode.adminpanel.main.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.InventoryView;
import pl.xcode.adminpanel.main.Main;
import pl.xcode.adminpanel.main.item.ItemBuilder;
import pl.xcode.adminpanel.main.utils.ChatUtil;

import pl.xcode.adminpanel.main.utils.Ticking;

import java.util.Arrays;

public class AdminPanelManageGUI {


    Main plugin;

    public static InventoryView AdminPanelManage(Player p) {

        Inventory inv = Bukkit.createInventory((InventoryHolder)p, 27, (ChatUtil.fixColor(Main.getPlugin().getConfig().getString("Manage.GUI_NAME"))));

        ItemBuilder glass = (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 7).setTitle(ChatUtil.fixColor("&0.")));

        ItemBuilder paper = (new ItemBuilder(Material.PAPER))
                .setTitle(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("Manage.PAPER_NAME")))
                .addLores(Arrays.asList(ChatUtil.fixColor
                        (" "), ChatUtil.fixColor
                        ("&8>> &7Informacje ogolne:"), ChatUtil.fixColor
                        (""), ChatUtil.fixColor
                        ("&8>> &7TPS: &9"+ Ticking.getTPS()), ChatUtil.fixColor
                        ("&8>> &7ONLINE: &9 " + Bukkit.getOnlinePlayers().size()), ChatUtil.fixColor
                        ("&8>> &7PORT: &9 " + Bukkit.getPort()), ChatUtil.fixColor
                        ("")));

        ItemBuilder glass5 = (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 4))
                .setTitle(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("Manage.RESET_NAME")))
                .addLores(Arrays.asList(ChatUtil.fixColor
                        (" "), ChatUtil.fixColor
                        ("&8>> &7Resetuje caly serwer")));

        ItemBuilder glass4 = (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 5))
                .setTitle(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("Manage.UNLAG_NAME")))
                .addLores(Arrays.asList(ChatUtil.fixColor
                        (" "), ChatUtil.fixColor
                        ("&8>> &cPamietaj ze robisz to na wlasna odpowiedzialnosc!"), ChatUtil.fixColor
                        ("&8>> &cTa opcja usuwa wszystkie przedmioty na ziemi!"), ChatUtil.fixColor
                        (" "), ChatUtil.fixColor
                        ("&8>> &c&mUNLAG serwera")));

        ItemBuilder glass14 = (new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 14))
                .setTitle(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("Manage.OFF_NAME")))
                .addLores(Arrays.asList(ChatUtil.fixColor
                        (" "), ChatUtil.fixColor
                        ("&8>> &7Wylaczenie serwera")));

        ItemBuilder barrier = (new ItemBuilder(Material.BARRIER))
                .setTitle(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("Panel.BARRIER_NAME")))
                .addLores(Arrays.asList(ChatUtil.fixColor(" "), ChatUtil.fixColor("&8>> &7Zamkniecie managera")));



        for(int i = 0; i < 27; i++){
            inv.setItem(i, glass.build());
        }

        inv.setItem(9, paper.build());
        inv.setItem(12, glass5.build());
        inv.setItem(13, glass4.build());
        inv.setItem(14, glass14.build());
        inv.setItem(17, barrier.build());


        return p.openInventory(inv);
    }
}
