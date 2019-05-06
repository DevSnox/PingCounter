package me.devsnox.pingcounter.velocity

import com.velocitypowered.api.command.Command
import com.velocitypowered.api.command.CommandSource
import me.devsnox.pingcounter.core.api.PingStats
import net.kyori.text.TextComponent
import java.util.concurrent.TimeUnit

class PingCommand internal constructor(private val pingStats: PingStats) : Command {

    override fun execute(commandSource: CommandSource, strings: Array<String>) {
        commandSource.sendMessage(TextComponent.of("§bUnique pings§8: §a" + this.pingStats.uniquePings + " §bTotal pings§8: §a" + this.pingStats.totalPings))
        commandSource.sendMessage(TextComponent.of("§bAverage unique PPM§8: §a" + (this.pingStats.getAverageUniquePings(TimeUnit.MINUTES).toDouble().toString() + " §bAverage total PPM§8: §a" + this.pingStats.getAverageTotalPings(TimeUnit.MINUTES).toDouble())))
    }
}
