package me.devsnox.pingcounter.command.spigot;

import me.devsnox.pingcounter.api.PingCounterFactory;
import me.devsnox.pingcounter.api.PingStats;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.TimeUnit;

public class SpigotPingCommand extends JavaPlugin implements CommandExecutor {

    private PingStats pingStats;

    @Override
    public void onEnable() {
        this.getCommand("pingcounter").setExecutor(this);
        this.pingStats = PingCounterFactory.pingCounter.getStats();
    }

    @Override
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        sender.sendMessage("§bUnique pings§8: §a" + this.pingStats.getUniquePings() + " §bTotal pings§8: §a" + this.pingStats.getTotalPings());
        sender.sendMessage("§bAverage unique PPM§8: §a" + ((double) this.pingStats.getAverageUniquePings(TimeUnit.MINUTES) + " §bAverage total PPM§8: §a" + ((double) this.pingStats.getAverageTotalPings(TimeUnit.MINUTES))));
        return false;
    }
}
