package pl.xcode.adminpanel.main.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import pl.xcode.adminpanel.main.Main;
import pl.xcode.adminpanel.main.utils.ChatUtil;

public class PlayerCommandListener implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        if (e.getMessage().startsWith("/kit") || e.getMessage().startsWith("/kity") || e.getMessage().startsWith("/kits")) {
            Player p = (Player) e.getPlayer();
            if (!Main.PanelCahe().isKit()) {
                e.setCancelled(true);
                p.sendTitle(ChatUtil.fixColor("&8>> &9&lKITY &8<<"), ChatUtil.fixColor("&7KITY aktualnie sa &c&lWYLACZONE"));
            }
        }
    }
}
