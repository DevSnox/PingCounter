package me.devsnox.pingcounter;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.InetAddress;
import java.util.HashMap;

public class PingCounter extends JavaPlugin {

    private HashMap<InetAddress, Integer> pings;
    private long startTime;

    public void onEnable() {
        this.pings = new HashMap<>();
        this.startTime = System.currentTimeMillis();
        Bukkit.getPluginManager().registerEvents(new PingListener(this), this);
        getCommand("pingcounter").setExecutor(new PingCommand(this));
    }

    public void addPing(InetAddress address) {
        if(this.pings.containsKey(address)) {
            this.pings.replace(address, pings.get(address) + 1);
        } else {
            this.pings.put(address, 1);
        }
    }

    public HashMap<InetAddress, Integer> getPings() {
        return pings;
    }

    public long getStartTime() {
        return startTime;
    }
}
