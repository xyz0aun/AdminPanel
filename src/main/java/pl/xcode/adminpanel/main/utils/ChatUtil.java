package pl.xcode.adminpanel.main.utils;

import java.util.*;
import org.bukkit.*;

public final class ChatUtil {
    public static List<String> fixColor(final List<String> list) {
        final List<String> mm = new ArrayList<String>();
        for (final String s : list) {
            mm.add(fixColor(s));
        }
        return mm;
    }

    public static String fixColor(final String s) {
        if (s == null) {
            return "";
        }
        return ChatColor.translateAlternateColorCodes('&', s.replace(">>", "»").replace("<<", "«").replace("%o", "\u2022"));
    }
}
