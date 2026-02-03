package git.coopas.clunarcheck.Events;

import git.coopas.clunarcheck.*;
import git.coopas.clunarcheck.Utils.LunarSession;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinE implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();
        e.setJoinMessage(null);

        Main plugin = Main.plugin;

        LunarSession session = new LunarSession(p.getUniqueId());
        plugin.sessions.put(p.getUniqueId(), session);

        plugin.msg(p, "&eIniciando verificação Lunar...");

        /* check channel */
        Bukkit.getScheduler().runTaskLater(plugin, () -> {

            if (p.getListeningPluginChannels().contains("lunar:apollo")) {
                session.channel = true;
                plugin.msg(p, "&a✔ lunar:apollo registrado");
            } else {
                plugin.msg(p, "&c✘ lunar:apollo não registrado");
            }

        }, 20L);

        /* handshake */
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            p.sendPluginMessage(plugin, "lunar:apollo", new byte[]{0x0});
        }, 40L);

        /* resultado */
        Bukkit.getScheduler().runTaskLater(plugin, () -> {

            plugin.msg(p, "&7----------------------");

            if (session.isRealLunar()) {
                plugin.msg(p, "&b&lLUNAR REAL CONFIRMADO");
            } else {
                plugin.msg(p, "&c&lCLIENTE SUSPEITO");
            }

            plugin.msg(p, "&7Tempo: &f" +
                    (System.currentTimeMillis() - session.joinTime) + "ms");

            plugin.msg(p, "&7----------------------");

        }, 100L);
    }
}
