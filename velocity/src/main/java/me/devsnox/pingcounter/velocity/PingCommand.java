package me.devsnox.pingcounter.velocity;

import com.velocitypowered.api.command.Command;
import com.velocitypowered.api.command.CommandSource;
import me.devsnox.pingcounter.core.api.PingStats;
import net.kyori.text.TextComponent;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.optional.qual.MaybePresent;

import java.util.concurrent.TimeUnit;

public class PingCommand implements Command {

    private final PingStats pingStats;

    PingCommand(final PingStats pingStats) {
        this.pingStats = pingStats;
    }

    @Override
    public void execute(@MaybePresent final CommandSource commandSource, @NonNull @MaybePresent final String[] strings) {
        commandSource.sendMessage(TextComponent.of("§bUnique pings§8: §a" + this.pingStats.getUniquePings() + " §bTotal pings§8: §a" + this.pingStats.getTotalPings()));
        commandSource.sendMessage(TextComponent.of("§bAverage unique PPM§8: §a" + ((double) this.pingStats.getAverageUniquePings(TimeUnit.MINUTES) + " §bAverage total PPM§8: §a" + ((double) this.pingStats.getAverageTotalPings(TimeUnit.MINUTES)))));
    }
}
