package pl.xcode.adminpanel.main.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import pl.xcode.adminpanel.main.Main;
import pl.xcode.adminpanel.main.utils.ChatUtil;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player p = (Player) e.getPlayer();
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(e.getClickedBlock().getType() == Material.ENCHANTMENT_TABLE) {
                if (!Main.PanelCahe().isEnchant()) {
                    e.setCancelled(true);
                    p.sendTitle(ChatUtil.fixColor("&8>> &d&lENCHANT &8<<"), ChatUtil.fixColor("&7ENCHANT aktualnie jest &c&lWYLACZONE"));
                }
            }
        }

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getPlayer().getItemInHand().getType() == Material.ENDER_PEARL) {
            if (!Main.PanelCahe().isPearl()) {
                e.setCancelled(true);
                p.sendTitle(ChatUtil.fixColor("&8>> &3&lPERLY &8<<"), ChatUtil.fixColor("&7PERLY aktualnie sa &c&lWYLACZONE"));
            }
        }
    }
}
