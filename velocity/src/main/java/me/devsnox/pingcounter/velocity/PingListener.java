package me.devsnox.pingcounter.velocity;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyPingEvent;
import me.devsnox.pingcounter.core.api.CounterEngine;

public class PingListener {

    private final CounterEngine engine;

    PingListener(final CounterEngine engine) {
        this.engine = engine;
    }

    @Subscribe
    public void onPing(final ProxyPingEvent event) {
        this.engine.addPing(event.getConnection().getRemoteAddress().getAddress());
    }
}
