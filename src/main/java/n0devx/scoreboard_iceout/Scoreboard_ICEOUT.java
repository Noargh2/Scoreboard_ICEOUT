package n0devx.scoreboard_iceout;

import n0devx.scoreboard_iceout.Scoreboard.PlayerJoinListener;
import n0devx.scoreboard_iceout.Scoreboard.ScoreboardHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Scoreboard_ICEOUT extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        new ScoreboardHandler().startAnimation();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
