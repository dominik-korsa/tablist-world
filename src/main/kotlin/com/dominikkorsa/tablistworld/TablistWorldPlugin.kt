package com.dominikkorsa.tablistworld

import org.bstats.bukkit.Metrics
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class TablistWorldPlugin: JavaPlugin() {
    lateinit var configManager: ConfigManager

    override fun onEnable() {
        super.onEnable()
        configManager = ConfigManager(this)
        registerEvents(PlayerListener(this))
        Bukkit.getOnlinePlayers().forEach { player ->
            updatePlayerTabList(player)
        }
        @Suppress("UNUSED_VARIABLE")
        val metrics = Metrics(this, 15936)
    }

    private fun registerEvents(listener: Listener) {
        server.pluginManager.registerEvents(listener, this)
    }

    fun updatePlayerTabList(player: Player) {
        val worldMessage = configManager.getWorldTabName(player.world.name)
        player.playerListName = worldMessage?.replace("%player%", player.name) ?: player.name
    }
}
