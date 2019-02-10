package me.devsnox.pingcounter.spigot;

import me.devsnox.pingcounter.core.api.CounterEngine;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class PingListener implements Listener {

    private final CounterEngine engine;

    public PingListener(final CounterEngine engine) {
        this.engine = engine;
    }

    @EventHandler
    public void onPing(final ServerListPingEvent event) {
        this.engine.addPing(event.getAddress());
    }
}
