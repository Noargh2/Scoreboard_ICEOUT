package n0devx.scoreboard_iceout.Scoreboard;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin (final PlayerJoinEvent event) {
        new ScoreboardHandler().setScoreboard(event.getPlayer());

    }
}