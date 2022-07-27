package com.dominikkorsa.tablistworld

class ConfigManager(private val plugin: TablistWorldPlugin) {
    private val config get() = plugin.config

    init {
        if (!config.contains("world-tab-names")) {
            config.set("world-tab-names.world", "§r%player%")
            config.set("world-tab-names.world_nether", "§r%player% §7[§cNether§7]")
            config.set("world-tab-names.world_the_end", "§r%player% §7[§dThe End§7]")
            plugin.saveConfig()
        }
    }

    fun getWorldTabName(world: String): String? = config.getConfigurationSection("world-tab-names").getString(world)
}
