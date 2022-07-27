package com.dominikkorsa.tablistworld

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerChangedWorldEvent
import org.bukkit.event.player.PlayerJoinEvent

class PlayerListener(private val plugin: TablistWorldPlugin) : Listener {
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        plugin.updatePlayerTabList(event.player)
    }

    @EventHandler
    fun onPlayerChangedWorld(event: PlayerChangedWorldEvent) {
        plugin.updatePlayerTabList(event.player)
    }
}
