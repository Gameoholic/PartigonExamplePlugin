package xyz.gameoholic.partigonexampleplugin.particles.a_basic

import org.bukkit.Bukkit
import org.bukkit.Location
import xyz.gameoholic.partigon.particle.SingularParticle
import xyz.gameoholic.partigon.particle.SingularParticle.Companion.singularParticle
import xyz.gameoholic.partigon.particle.envelope.LinearEnvelope
import xyz.gameoholic.partigon.particle.location.ConstantLocation
import xyz.gameoholic.partigon.particle.loop.BounceLoop
import xyz.gameoholic.partigon.particle.loop.ContinueLoop
import xyz.gameoholic.partigon.util.Utils.envelope

object CZigZagParticle {
    fun getParticle() = singularParticle {
        // particleType = Particle.END_ROD This is the default value for the particle type, so we don't have to specify it.
        originLocation = ConstantLocation(Location(Bukkit.getWorld("world"), 0.0, 300.0, 0.0))

        positionZ = LinearEnvelope(0.0.envelope, 5.0.envelope, ContinueLoop(50)) // ContinueLoop will continue in the same direction and velocity, even after 50 ticks have passed
        positionX = LinearEnvelope(0.0.envelope, 4.0.envelope, BounceLoop(20)) // BounceLoop will go from 0 -> 4 -> 0 and repeat

        maxFrameAmount = 100 // Will stop the particle animation after 100 frames (ticks)
    }
}