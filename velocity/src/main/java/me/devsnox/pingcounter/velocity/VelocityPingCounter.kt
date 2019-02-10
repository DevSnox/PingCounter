package me.devsnox.pingcounter.velocity

import com.google.inject.Inject
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.proxy.ProxyServer
import me.devsnox.pingcounter.core.impl.BasicPingCounter

/**
 * Created by DevSnox on 12.02.18
 * Copyright (c) 2018 DevSnox
 * GitHub: https://github.com/DevSnox
 * Web: http://devsnox.me
 * Mail: me.devsnox@gmail.com
 * Discord: DevSnox#4884 | Skype: live:chaos3729
 */
@Plugin(
        id = "pingcounter",
        name = "PingCounter",
        version = "1.2-SNAPSHOT",
        description = "PingCounter counts all incoming pings from the serverlist.",
        authors = ["DevSnox"]
)

class VelocityPingCounter @Inject
constructor(proxyServer: ProxyServer) {

    init {
        val pingCounter = BasicPingCounter()

        proxyServer.commandManager.register(PingCommand(pingCounter.stats))
        proxyServer.eventManager.register(this, PingListener(pingCounter.engine))
    }
}