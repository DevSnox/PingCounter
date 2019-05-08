package me.devsnox.pingcounter.velocity

import com.google.inject.Inject
import com.velocitypowered.api.command.Command
import com.velocitypowered.api.command.CommandManager
import com.velocitypowered.api.command.CommandSource
import com.velocitypowered.api.plugin.Plugin
import me.devsnox.pingcounter.api.PingCounterFactory
import me.devsnox.pingcounter.api.PingStats
import net.kyori.text.TextComponent
import java.util.concurrent.TimeUnit

/**
 * Created by DevSnox on 12.02.18
 * Copyright (c) 2018 DevSnox | Lars Artmann | LartyHD
 * GitHub: https://github.com/DevSnox
 * Web: http://devsnox.me
 * Mail: me.devsnox@gmail.com
 * Discord: DevSnox#4884 | Skype: live:chaos3729
 */
@Suppress("unused")
@Plugin(
        id = "pingcountercommand",
        name = "PingCounterCommand",
        version = "1.3-SNAPSHOT",
        description = "PingCounter counts all incoming pings from the serverlist.",
        authors = ["DevSnox", "Lars Artmann | LartyHD"]
)
class VelocityPingCommand @Inject private constructor(
        private val commandManager: CommandManager
) : Command {

    private val pingStats : PingStats = PingCounterFactory.pingCounter.stats

    override fun execute(commandSource: CommandSource, strings: Array<String>) {
        commandSource.sendMessage(TextComponent.of("§bUnique pings§8: §a" + this.pingStats.uniquePings + " §bTotal pings§8: §a" + this.pingStats.totalPings))
        commandSource.sendMessage(TextComponent.of("§bAverage unique PPM§8: §a" + (this.pingStats.getAverageUniquePings(TimeUnit.MINUTES).toDouble().toString() + " §bAverage total PPM§8: §a" + this.pingStats.getAverageTotalPings(TimeUnit.MINUTES).toDouble())))
    }
}