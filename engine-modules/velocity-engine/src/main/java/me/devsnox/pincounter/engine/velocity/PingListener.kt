package me.devsnox.pincounter.engine.velocity

import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyPingEvent
import me.devsnox.pingcounter.api.CounterEngine

class PingListener internal constructor(private val engine: CounterEngine) {

    @Subscribe
    fun onPing(event: ProxyPingEvent) {
        this.engine.addPing(event.connection.remoteAddress.address)
    }
}
