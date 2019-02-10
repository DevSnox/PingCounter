package me.devsnox.pingcounter.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import me.devsnox.pingcounter.core.api.PingCounter;
import me.devsnox.pingcounter.core.impl.BasicPingCounter;
import org.slf4j.Logger;

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
        authors = "DevSnox"
)
public class VelocityPingCounter {

    private final ProxyServer proxyServer;
    private final PingCounter pingCounter;

    @Inject
    public VelocityPingCounter(final ProxyServer proxyServer, final Logger logger) {
        this.proxyServer = proxyServer;
        this.pingCounter = new BasicPingCounter();

        this.proxyServer.getCommandManager().register(new PingCommand(this.pingCounter.getStats()));
        this.proxyServer.getEventManager().register(this, new PingListener(this.pingCounter.getEngine()));
    }
}