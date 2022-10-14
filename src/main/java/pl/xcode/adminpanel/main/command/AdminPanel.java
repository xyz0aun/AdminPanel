package pl.xcode.adminpanel.main.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.xcode.adminpanel.main.Main;
import pl.xcode.adminpanel.main.gui.AdminPanelGUI;
import pl.xcode.adminpanel.main.utils.ChatUtil;

public class AdminPanel implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
        Player p = (Player) sender;
        if(p.isOp() || p.hasPermission(Main.getPlugin().getConfig().getString("Permissions.PERMISSION")) || p.hasPermission("*")) {
            AdminPanelGUI.AdminPanel(p);
        } else {
            p.sendMessage(ChatUtil.fixColor(Main.getPlugin().getConfig().getString("Messages.NO_PERMISSION")));
        }
        return false;
    }
}
