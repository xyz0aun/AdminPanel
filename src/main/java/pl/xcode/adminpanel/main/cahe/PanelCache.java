package pl.xcode.adminpanel.main.cahe;

import pl.xcode.adminpanel.main.Main;

public class PanelCache {

    private Main plugin;
    private boolean tnt;
    private boolean kit;
    private boolean enchant;
    private boolean crafting;
    private boolean pearl;
    private boolean sword;

    public PanelCache(Main plugin) {
        this.plugin = plugin;
        this.tnt = plugin.getConfig().getBoolean("tnt");
        this.kit = plugin.getConfig().getBoolean("kit");
        this.enchant = plugin.getConfig().getBoolean("enchant");
        this.crafting = plugin.getConfig().getBoolean("crafting");
        this.pearl = plugin.getConfig().getBoolean("pearl");
        this.sword = plugin.getConfig().getBoolean("sword");
    }

    public Main getPlugin() {
        return plugin;
    }

    public void setPlugin(Main plugin) {
        this.plugin = plugin;
    }

    public boolean isTnt() {
        return tnt;
    }

    public void setTnt(boolean tnt) {
        this.tnt = tnt;
    }

    public boolean isKit() {
        return kit;
    }

    public void setKit(boolean kit) {
        this.kit = kit;
    }

    public boolean isEnchant() {
        return enchant;
    }

    public void setEnchant(boolean enchant) {
        this.enchant = enchant;
    }

    public boolean isCrafting() {
        return crafting;
    }

    public void setCrafting(boolean crafting) {
        this.crafting = crafting;
    }

    public boolean isPearl() {
        return pearl;
    }

    public void setPearl(boolean pearl) {
        this.pearl = pearl;
    }

    public boolean isSword() {
        return sword;
    }

    public void setSword(boolean sword) {
        this.sword = sword;
    }
}
