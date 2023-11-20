package xyz.gameoholic.partigonexampleplugin.particles.a_basic

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Particle
import xyz.gameoholic.partigon.particle.MultiParticle.Companion.multiParticle
import xyz.gameoholic.partigon.particle.SingularParticle.Companion.singularParticle
import xyz.gameoholic.partigon.particle.location.ConstantLocation
import xyz.gameoholic.partigon.util.Utils.envelope

/**
 * Particle with no motion.
 */
object ANoMotionParticle {
    fun getParticle() = singularParticle {
        particleType = Particle.FLAME

        // Location of particle can be ConstantLocation, EntityLocation, or your own implementation!
        originLocation = ConstantLocation(Location(Bukkit.getWorld("world"), 0.0, 300.0, 0.0))
    }

}