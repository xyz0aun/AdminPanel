package pl.xcode.adminpanel.main.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import pl.xcode.adminpanel.main.Main;
import pl.xcode.adminpanel.main.utils.ChatUtil;

public class PlaceBlockListener implements Listener {

    @EventHandler
    public void PlaceTNT(BlockPlaceEvent e) {
        if (e.getBlock().getType() == Material.TNT) {
            Player p = (Player) e.getPlayer();
            if (!Main.PanelCahe().isTnt()) {
                e.setCancelled(true);
                p.sendTitle(ChatUtil.fixColor("&8>> &c&lTNT &8<<"), ChatUtil.fixColor("&7TNT aktualnie jest &c&lWYLACZONE"));
            }
        }
    }
}
