package xyz.gameoholic.partigonexampleplugin.particles.a_basic

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Particle
import xyz.gameoholic.partigon.particle.SingularParticle
import xyz.gameoholic.partigon.particle.SingularParticle.Companion.singularParticle
import xyz.gameoholic.partigon.particle.envelope.LinearEnvelope
import xyz.gameoholic.partigon.particle.location.ConstantLocation
import xyz.gameoholic.partigon.particle.loop.RepeatLoop
import xyz.gameoholic.partigon.util.Utils.envelope

/**
 *
 */
object BUpwardsParticle {
    fun getParticle() = singularParticle {
        particleType = Particle.FLAME
        originLocation = ConstantLocation(Location(Bukkit.getWorld("world"), 0.0, 300.0, 0.0))

        // Particle's Y value will start at 0.0, increase to 4.0 over 40 ticks, and then restart at 0
        // Because originLocation's y level is 300.0, it'll actually be 300.0 -> 174.0
        positionY = LinearEnvelope(0.0.envelope, 4.0.envelope, RepeatLoop(40))

        // Envelopes can also be added like this:
        // LinearEnvelope(Envelope.PropertyType.POS_Y, 0.0.envelope, 4.0.envelope, RepeatLoop(100)).add()
        // Which allows you to have multiple envelopes affecting one property
    }
}