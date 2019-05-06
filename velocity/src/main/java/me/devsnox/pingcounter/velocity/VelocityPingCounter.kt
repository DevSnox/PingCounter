package me.devsnox.pingcounter.velocity

import com.google.inject.Inject
import com.velocitypowered.api.command.CommandManager
import com.velocitypowered.api.event.EventManager
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.plugin.Plugin
import me.devsnox.pingcounter.core.impl.BasicPingCounter

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
        id = "pingcounter",
        name = "PingCounter",
        version = "1.2-SNAPSHOT",
        description = "PingCounter counts all incoming pings from the serverlist.",
        authors = ["DevSnox", "Lars Artmann | LartyHD"]
)
class VelocityPingCounter @Inject private constructor(
        private val commandManager: CommandManager,
        private val eventManager: EventManager
) {

    /**
     * @author Lars Artmann | LartyHD
     * Created by Lars Artmann | LartyHD on 10.02.2019 23:17.
     *
     * WARNING: This is an event. Do not call it manually!
     *
     * @param event specifies which event is intercepted. In this case it is the [ProxyInitializeEvent].
     *
     * Current Version: 1.0 (10.02.2019 - 10.02.2019)
     */
    @Suppress("UNUSED_PARAMETER")
    @Subscribe
    fun on(event: ProxyInitializeEvent): Unit = BasicPingCounter().run {
        commandManager.register(PingCommand(stats), "pingcounter")
        eventManager.register(this@VelocityPingCounter, PingListener(engine))
    }

}