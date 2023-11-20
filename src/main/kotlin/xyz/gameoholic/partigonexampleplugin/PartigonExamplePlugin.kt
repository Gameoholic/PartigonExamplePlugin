package xyz.gameoholic.partigonexampleplugin

import org.bukkit.plugin.java.JavaPlugin
import xyz.gameoholic.partigon.particle.PartigonParticle
import xyz.gameoholic.partigonexampleplugin.commands.ParticleCommand


class PartigonExamplePlugin: JavaPlugin() {
    var particle: PartigonParticle? = null
    override fun onEnable() {
        getCommand("particle")?.setExecutor(ParticleCommand(this))
    }
}