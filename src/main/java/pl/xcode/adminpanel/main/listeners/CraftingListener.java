package pl.xcode.adminpanel.main.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import pl.xcode.adminpanel.main.Main;
import pl.xcode.adminpanel.main.utils.ChatUtil;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class CraftingListener implements Listener {

    private final List<Material> item;

    public CraftingListener() {
        this.item = Arrays.asList(Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS, Material.DIAMOND_SWORD);
    }

    @EventHandler
    public void onCrafting(CraftItemEvent e) {
        if(item.contains(e.getRecipe().getResult().getType())) {
            if (!Main.PanelCahe().isCrafting()) {
                Player p = (Player) e.getWhoClicked();
                p.sendTitle(ChatUtil.fixColor("&8>> &b&lDIAXY &8<<"), ChatUtil.fixColor("&7DIAXY aktualnie sa &c&lWYLACZONE"));
                p.closeInventory();
                e.setCancelled(true);
            }
        }
    }
}
