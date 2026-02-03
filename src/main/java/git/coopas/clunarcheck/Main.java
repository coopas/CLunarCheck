package git.coopas.clunarcheck;

import git.coopas.clunarcheck.Events.PlayerJoinE;
import git.coopas.clunarcheck.Utils.LunarSession;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class Main extends JavaPlugin {

    public static Main plugin;

    public final Map<UUID, LunarSession> sessions = new HashMap<>();

    @Override
    public void onEnable() {

        plugin = this;

        Bukkit.getMessenger().registerIncomingPluginChannel(this, "lunar:apollo", this::onApollo);
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "lunar:apollo");

        Bukkit.getPluginManager().registerEvents(new PlayerJoinE(), this);

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[CLunarCheck] Plugin iniciado.");
    }

    @Override
    public void onDisable() {
        sessions.clear();
    }

    /* ================= APOLLO ================= */

    private void onApollo(String channel, Player player, byte[] data) {

        LunarSession s = sessions.get(player.getUniqueId());
        if (s == null) return;

        if (!s.apollo) {
            s.apollo = true;
            msg(player, "&a✔ lunar:apollo ativo");
        }

        s.handshake = true;
    }

    /* ================= API ================= */

    public boolean isRealLunar(Player p) {
        LunarSession s = sessions.get(p.getUniqueId());
        return s != null && s.isRealLunar();
    }

    /* ================= UTIL ================= */

    public void msg(Player p, String msg) {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&',
                "&7[&bCLunarCheck&7] " + msg));
    }
}
