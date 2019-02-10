package me.devsnox.pingcounter;

import me.devsnox.pingcounter.core.api.PingStats;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.concurrent.TimeUnit;

public class PingCommand implements CommandExecutor {

    private final PingStats pingStats;

    public PingCommand(final PingStats pingStats) {
        this.pingStats = pingStats;
    }

    @Override
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        sender.sendMessage("§bUnique pings§8: §a" + this.pingStats.getUniquePings() + " §bTotal pings§8: §a" + this.pingStats.getTotalPings());
        sender.sendMessage("§bAverage unique PPM§8: §a" + ((double) this.pingStats.getAverageUnqiePings(TimeUnit.MINUTES) + " §bAverage total PPM§8: §a" + ((double) this.pingStats.getAverageTotalPings(TimeUnit.MINUTES))));
        return false;
    }
}
