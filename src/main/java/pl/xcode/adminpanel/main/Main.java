package pl.xcode.adminpanel.main;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import pl.xcode.adminpanel.main.cahe.PanelCache;
import pl.xcode.adminpanel.main.command.AdminPanel;
import pl.xcode.adminpanel.main.listeners.*;

import pl.xcode.adminpanel.main.utils.Ticking;


public class Main extends JavaPlugin {

    private static Main main;
    private static Main plugin;

    private static PanelCache panelCache;

    private static Main instance;

    public void onEnable() {
        panelCache = new PanelCache(this);
        Main.instance = this;
        main = this;
        (Main.plugin = this).saveDefaultConfig();
        new Ticking().start();
        this.getCommand("adminpanel").setExecutor(new AdminPanel());


        this.getServer().getPluginManager().registerEvents(new GuiListenersClicked(), this);
        this.getServer().getPluginManager().registerEvents(new PlaceBlockListener(), this);
        this.getServer().getPluginManager().registerEvents(new ExplodeListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerCommandListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
        this.getServer().getPluginManager().registerEvents(new CraftingListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerDamage(), this);
    }

    public static PanelCache PanelCahe() {
        return panelCache;
    }


    public static Main getPlugin() {
        return Main.plugin;
    }
}
