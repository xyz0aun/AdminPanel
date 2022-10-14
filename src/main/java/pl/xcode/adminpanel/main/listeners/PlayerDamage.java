package pl.xcode.adminpanel.main.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import pl.xcode.adminpanel.main.Main;
import pl.xcode.adminpanel.main.utils.ChatUtil;

public class PlayerDamage implements Listener {
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if(e.getEntity() instanceof Player || e.getDamager() instanceof Player) {
            if (!Main.PanelCahe().isSword()) {
                Player p = (Player) e.getDamager();
                e.setCancelled(true);
                p.sendTitle(ChatUtil.fixColor("&8>> &c&lPVP &8<<"), ChatUtil.fixColor("&7PVP aktualnie jest &c&lWYLACZONE"));
            }
        }
    }
}
