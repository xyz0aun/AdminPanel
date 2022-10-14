package pl.xcode.adminpanel.main.listeners;

import javafx.scene.paint.Stop;
import javafx.util.Builder;
import org.bukkit.event.inventory.*;
import pl.xcode.adminpanel.main.Main;
import pl.xcode.adminpanel.main.gui.AdminPanelGUI;
import pl.xcode.adminpanel.main.gui.AdminPanelManageGUI;
import pl.xcode.adminpanel.main.utils.ChatUtil;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.event.*;

import java.util.List;

public class GuiListenersClicked implements Listener {

    @EventHandler
    public void onGuiClicked(final InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        final int raw_slot = e.getRawSlot();

        if (e.getView().getTitle().equalsIgnoreCase(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("Panel.GUI_NAME")))) {
            e.setCancelled(true);
            if (raw_slot == 11) {
                Main.PanelCahe().setTnt(!Main.PanelCahe().isTnt());
                p.sendTitle(ChatUtil.fixColor("&8>> &c&lTNT &8<<"), ChatUtil.fixColor("&7TNT zostalo " + (ChatUtil.fixColor(Main.PanelCahe().isTnt() ? "&a&lWLACZONE" : "&c&lWYLACZONE"))));
                AdminPanelGUI.AdminPanel(p);
                p.updateInventory();
            }
            if (raw_slot == 13) {
                Main.PanelCahe().setKit(!Main.PanelCahe().isKit());
                p.sendTitle(ChatUtil.fixColor("&8>> &9&lKITY &8<<"), ChatUtil.fixColor("&7KITY zostaly " + (ChatUtil.fixColor(Main.PanelCahe().isKit() ? "&a&lWLACZONE" : "&c&lWYLACZONE"))));
                AdminPanelGUI.AdminPanel(p);
                p.updateInventory();
            }
            if (raw_slot == 15) {
                Main.PanelCahe().setEnchant(!Main.PanelCahe().isEnchant());
                p.sendTitle(ChatUtil.fixColor("&8>> &d&lENCHANT &8<<"), ChatUtil.fixColor("&7ENCHANT zostal " + (ChatUtil.fixColor(Main.PanelCahe().isEnchant() ? "&a&lWLACZONE" : "&c&lWYLACZONE"))));
                AdminPanelGUI.AdminPanel(p);
                p.updateInventory();
            }
            if (raw_slot == 21) {
                Main.PanelCahe().setCrafting(!Main.PanelCahe().isCrafting());
                p.sendTitle(ChatUtil.fixColor("&8>> &b&lDIAXY &8<<"), ChatUtil.fixColor("&7DIAXY zostaly " + (ChatUtil.fixColor(Main.PanelCahe().isCrafting() ? "&a&lWLACZONE" : "&c&lWYLACZONE"))));
                AdminPanelGUI.AdminPanel(p);
                p.updateInventory();
            }
            if (raw_slot == 23) {
                Main.PanelCahe().setPearl(!Main.PanelCahe().isPearl());
                p.sendTitle(ChatUtil.fixColor("&8>> &3&lPERLY &8<<"), ChatUtil.fixColor("&7PERLY zostaly " + (ChatUtil.fixColor(Main.PanelCahe().isPearl() ? "&a&lWLACZONE" : "&c&lWYLACZONE"))));
                AdminPanelGUI.AdminPanel(p);
                p.updateInventory();
            }
            if (raw_slot == 31) {
                Main.PanelCahe().setSword(!Main.PanelCahe().isSword());
                p.sendTitle(ChatUtil.fixColor("&8>> &c&lPVP &8<<"), ChatUtil.fixColor("&7PVP zostalo " + (ChatUtil.fixColor(Main.PanelCahe().isSword() ? "&a&lWLACZONE" : "&c&lWYLACZONE"))));
                AdminPanelGUI.AdminPanel(p);
                p.updateInventory();
            }
            if (raw_slot == 36) {
                AdminPanelManageGUI.AdminPanelManage(p);
            }
            if (raw_slot == 44) {
                p.closeInventory();
            }
        }
    }

    @EventHandler
    public void onGuiClickedManage(final InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        final int raw_slot = e.getRawSlot();
        World world = p.getWorld();
        List<Entity> list = world.getEntities();

        if (e.getView().getTitle().equalsIgnoreCase(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("Manage.GUI_NAME")))) {
            e.setCancelled(true);
            if (raw_slot == 12) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"rl");
                p.sendTitle(ChatUtil.fixColor("&8>> &e&lRESET &8<<"), ChatUtil.fixColor("&7Serwer zostal pomyslnie zresetowany!"));
            }
            if (raw_slot == 13) {
                p.sendTitle(ChatUtil.fixColor("&8>> &a&lUNLAG &8<<"), ChatUtil.fixColor("&7Serwer zostal pomyslnie odlagowany!"));
                for(Entity current : list){
                    if (current instanceof Item){
                        current.remove();
                    }
                }
            }
            if (raw_slot == 14) {
                Bukkit.getServer().shutdown();
            }
            if (raw_slot == 17) {
                p.closeInventory();
            }
        }
    }
}
