package me.devsnox.pincounter.engine.spigot;

import me.devsnox.pingcounter.api.PingCounter;
import me.devsnox.pingcounter.api.PingCounterFactory;
import me.devsnox.pingcounter.core.impl.BasicPingCounter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by DevSnox on 12.02.18
 * Copyright (c) 2018 DevSnox
 * GitHub: https://github.com/DevSnox
 * Web: http://devsnox.me
 * Mail: me.devsnox@gmail.com
 * Discord: DevSnox#4884 | Skype: live:chaos3729
 */
public class SpigotPingCounter extends JavaPlugin {

    private final PingCounter pingCounter;

    public SpigotPingCounter() {
        this.pingCounter = new BasicPingCounter();
        PingCounterFactory.pingCounter = this.pingCounter;
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PingListener(this.pingCounter.getEngine()), this);
    }
}