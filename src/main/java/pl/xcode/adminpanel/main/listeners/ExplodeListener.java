package pl.xcode.adminpanel.main.listeners;

import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import pl.xcode.adminpanel.main.Main;

public class ExplodeListener implements Listener {

    @EventHandler
    public void onExplode(EntityExplodeEvent e) {
        if (e.getEntity() instanceof TNTPrimed) {
            if (!Main.PanelCahe().isTnt()) {
                e.setCancelled(true);
            }
        }
    }
}
