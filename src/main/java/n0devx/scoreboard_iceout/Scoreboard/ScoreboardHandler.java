package n0devx.scoreboard_iceout.Scoreboard;

import n0devx.scoreboard_iceout.Scoreboard_ICEOUT;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScoreboardHandler {

    private static Integer animationCount;

    private String[] animation = new String[]{
            "§9§lICEOUT", "§9§3§lI§9§lCEOUT", "§l§9§lI§3§lC§9§lEOUT", "§l§9§lIC§3§lE§9§lOUT", "§l§9§lICE§3§lO§9§lUT", "§l§9§lICEO§3§lU§9§lT", "§l§9§lICEOU§3§lT", "§l§9§lICEOUT"
    };

    public void setScoreboard(final Player player) {
        final Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        final Objective objective = scoreboard.registerNewObjective("main-content", "dummy");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(animation[animationCount]);
        objective.getScore(" ").setScore(7);
        objective.getScore(ChatColor.AQUA + player.getDisplayName()).setScore(6);
        objective.getScore("").setScore(5);
        objective.getScore("§7Rang: §3RANG").setScore(4);
        objective.getScore("§7Zeit: " + String.valueOf(player.getPlayerTime())).setScore(3);
        objective.getScore("§7Spielzeit: §3SZEIT").setScore(2);
        objective.getScore("§7Ping: " + String.valueOf(player.getPing())).setScore(1);

        

        player.setScoreboard(scoreboard);

    }


    public void startAnimation() {
        animationCount = 0;
        Bukkit.getScheduler().runTaskTimer(Scoreboard_ICEOUT.getPlugin(Scoreboard_ICEOUT.class), new Runnable() {
            @Override
            public void run() {
                Bukkit.getOnlinePlayers().forEach(current -> {

                    if(current.getScoreboard() == null)
                        setScoreboard(current);

                    current.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(animation[animationCount]);
                });

                animationCount ++;

                if (animationCount == animation.length)
                    animationCount = 0;

            }
        }, 0, 3);
    }


}
