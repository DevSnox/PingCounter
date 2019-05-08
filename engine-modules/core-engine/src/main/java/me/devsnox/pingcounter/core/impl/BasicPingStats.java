package me.devsnox.pingcounter.core.impl;

import me.devsnox.pingcounter.api.PingStats;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by DevSnox on 12.02.18
 * Copyright (c) 2018 DevSnox
 * GitHub: https://github.com/DevSnox
 * Web: http://devsnox.me
 * Mail: me.devsnox@gmail.com
 * Discord: DevSnox#4884 | Skype: live:chaos3729
 */
public class BasicPingStats implements PingStats {

    private final BasicCounterEngine engine;

    BasicPingStats(final BasicCounterEngine engine) {
        this.engine = engine;
    }

    @Override
    public int getTotalPings() {
        int totalPings = 0;

        for (final Integer value : this.engine.getPings().values()) {
            totalPings += value;
        }

        return totalPings;
    }

    @Override
    public int getUniquePings() {
        int uniquePings = 0;

        for (final Integer ignored : this.engine.getPings().values()) {
            uniquePings++;
        }

        return uniquePings;
    }

    @Override
    public float getAverageTotalPings(final TimeUnit timeUnit) {
        return this.averagePingPerTimeUnit(this.getTotalPings(), timeUnit);
    }

    @Override
    public float getAverageUniquePings(final TimeUnit timeUnit) {
        return this.averagePingPerTimeUnit(this.getUniquePings(), timeUnit);
    }

    private float averagePingPerTimeUnit(final int pings, final TimeUnit timeUnit) {
        if (TimeUnit.MINUTES.convert((System.currentTimeMillis() - this.engine.getStartTime()), TimeUnit.MILLISECONDS) == 0) {
            Logger.getLogger("minecraft").log(Level.WARNING, "Please wait some seconds, the system is still collecting data (max. 60 seconds)");
            return 0;
        }
        return pings / timeUnit.convert((System.currentTimeMillis() - this.engine.getStartTime()), TimeUnit.MILLISECONDS);
    }
}
