package me.devsnox.pingcounter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.net.InetAddress;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PingCommand implements CommandExecutor {

    private PingCounter pingCounter;

    public PingCommand(PingCounter pingCounter) {
        this.pingCounter = pingCounter;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        int totalPings = 0;
        int uniquePings = 0;

        for(Map.Entry<InetAddress, Integer> entry : pingCounter.getPings().entrySet()) {
            uniquePings++;
            totalPings = totalPings + entry.getValue();
        }

        sender.sendMessage("§bUnique pings§8: §a" + uniquePings + " §bTotal pings§8: §a" + totalPings);
        sender.sendMessage("§bAverage unique PPM§8: §a" + ((double) uniquePings / TimeUnit.MINUTES.convert((System.currentTimeMillis() - this.pingCounter.getStartTime()), TimeUnit.MILLISECONDS))  + " §bAverage total PPM§8: §a" + ((double) totalPings / TimeUnit.MINUTES.convert((System.currentTimeMillis() - this.pingCounter.getStartTime()), TimeUnit.MILLISECONDS)));
        return false;
    }
}
