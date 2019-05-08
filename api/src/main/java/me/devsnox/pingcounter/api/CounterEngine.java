package me.devsnox.pingcounter.api;

import java.net.InetAddress;

/**
 * Created by DevSnox on 12.02.18
 * Copyright (c) 2018 DevSnox
 * GitHub: https://github.com/DevSnox
 * Web: http://devsnox.me
 * Mail: me.devsnox@gmail.com
 * Discord: DevSnox#4884 | Skype: live:chaos3729
 */
public interface CounterEngine {

    long getStartTime();

    void resetCount();

    void addPing(InetAddress inetAddress);
}
