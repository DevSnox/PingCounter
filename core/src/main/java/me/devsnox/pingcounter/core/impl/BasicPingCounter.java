package me.devsnox.pingcounter.core.impl;

import me.devsnox.pingcounter.core.api.CounterEngine;
import me.devsnox.pingcounter.core.api.PingCounter;
import me.devsnox.pingcounter.core.api.PingStats;

/**
 * Created by DevSnox on 12.02.18
 * Copyright (c) 2018 DevSnox
 * GitHub: https://github.com/DevSnox
 * Web: http://devsnox.me
 * Mail: me.devsnox@gmail.com
 * Discord: DevSnox#4884 | Skype: live:chaos3729
 */
public class BasicPingCounter implements PingCounter {

    private final BasicCounterEngine counterEngine;
    private final PingStats pingStats;

    public BasicPingCounter() {
        this.counterEngine = new BasicCounterEngine();
        this.pingStats = new BasicPingStats(this.counterEngine);
    }

    @Override
    public CounterEngine getEngine() {
        return this.counterEngine;
    }

    @Override
    public PingStats getStats() {
        return this.pingStats;
    }
}
