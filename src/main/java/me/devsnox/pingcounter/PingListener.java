package me.devsnox.pingcounter;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class PingListener implements Listener {

    private PingCounter pingCounter;

    public PingListener(PingCounter pingCounter) {
        this.pingCounter = pingCounter;
    }

    @EventHandler
    public void onPing(ServerListPingEvent event) {
        this.pingCounter.addPing(event.getAddress());
    }
}
