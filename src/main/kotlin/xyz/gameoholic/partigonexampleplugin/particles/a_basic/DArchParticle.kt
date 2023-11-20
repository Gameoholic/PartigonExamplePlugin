package xyz.gameoholic.partigonexampleplugin.particles.a_basic

import org.bukkit.Bukkit
import org.bukkit.Location
import xyz.gameoholic.partigon.particle.SingularParticle
import xyz.gameoholic.partigon.particle.SingularParticle.Companion.singularParticle
import xyz.gameoholic.partigon.particle.envelope.TrigonometricEnvelope
import xyz.gameoholic.partigon.particle.location.ConstantLocation
import xyz.gameoholic.partigon.particle.loop.BounceLoop
import xyz.gameoholic.partigon.util.Utils.envelope

object DArchParticle {
    fun getParticle() = singularParticle {
        originLocation = ConstantLocation(Location(Bukkit.getWorld("world"), 0.0, 300.0, 0.0))

        // This is a bad way to create arches and curves - We will learn how to do it more efficiently later
        positionX = TrigonometricEnvelope(
            0.0.envelope,
            4.0.envelope,
            TrigonometricEnvelope.TrigFunc.COS,
            BounceLoop(200)
        )
        positionY = TrigonometricEnvelope(
            0.0.envelope,
            4.0.envelope,
            TrigonometricEnvelope.TrigFunc.SIN,
            BounceLoop(200)
        )
        positionZ = TrigonometricEnvelope(
            0.0.envelope,
            4.0.envelope,
            TrigonometricEnvelope.TrigFunc.SIN,
            BounceLoop(200)
        )


    }
}