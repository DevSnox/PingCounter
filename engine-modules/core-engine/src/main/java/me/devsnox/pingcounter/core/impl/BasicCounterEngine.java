package me.devsnox.pingcounter.core.impl;

import lombok.Getter;
import me.devsnox.pingcounter.api.CounterEngine;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DevSnox on 12.02.18
 * Copyright (c) 2018 DevSnox
 * GitHub: https://github.com/DevSnox
 * Web: http://devsnox.me
 * Mail: me.devsnox@gmail.com
 * Discord: DevSnox#4884 | Skype: live:chaos3729
 */
public class BasicCounterEngine implements CounterEngine {

    @Getter
    private Map<InetAddress, Integer> pings;

    @Getter
    private long startTime;

    public BasicCounterEngine() {
        this.pings = new HashMap<>();
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public long getStartTime() {
        return this.startTime;
    }

    @Override
    public void resetCount() {
        this.pings = new HashMap<>();
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public void addPing(final InetAddress inetAddress) {
        if (this.pings.containsKey(inetAddress)) {
            this.pings.replace(inetAddress, this.pings.get(inetAddress) + 1);
        } else {
            this.pings.put(inetAddress, 1);
        }
    }
}
