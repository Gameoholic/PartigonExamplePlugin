package xyz.gameoholic.partigonexampleplugin.particles.c_rotation
import org.bukkit.Bukkit
import org.bukkit.Location
import xyz.gameoholic.partigon.particle.SingularParticle.Companion.singularParticle
import xyz.gameoholic.partigon.particle.envelope.EnvelopeGroup
import xyz.gameoholic.partigon.particle.envelope.LinearEnvelope
import xyz.gameoholic.partigon.particle.envelope.wrapper.CircleEnvelopeWrapper.circleEnvelopeGroup
import xyz.gameoholic.partigon.particle.location.ConstantLocation
import xyz.gameoholic.partigon.particle.loop.RepeatLoop
import xyz.gameoholic.partigon.util.EnvelopePair
import xyz.gameoholic.partigon.util.EnvelopeTriple
import xyz.gameoholic.partigon.util.Utils.envelope
import xyz.gameoholic.partigon.util.rotation.RotationOptions
import xyz.gameoholic.partigon.util.rotation.RotationType

object BRotatingCircleParticle {
    fun getParticle() = singularParticle {
        originLocation = ConstantLocation(Location(Bukkit.getWorld("world"), 0.0, 300.0, 0.0))

        // Rotations are the backbone to a lot of cool particle animations.
        // It is important you mess around with them and get a hang of how they work.

        circleEnvelopeGroup(
            EnvelopeGroup.EnvelopeGroupType.POSITION,
            EnvelopePair(0.0.envelope, 0.0.envelope),
            3.0.envelope,
            RepeatLoop(50),
            rotationOptions = listOf(
                RotationOptions(
                    EnvelopeTriple(0.0.envelope, 0.0.envelope, 0.0.envelope),
                    LinearEnvelope(0.0.envelope, 360.0.envelope, RepeatLoop(100)), // Rotation degrees: 0 -> 360 over 100 ticks
                    RotationType.Z_AXIS
                ),
                RotationOptions(
                    EnvelopeTriple(0.0.envelope, 0.0.envelope, 0.0.envelope),
                    LinearEnvelope(0.0.envelope, 360.0.envelope, RepeatLoop(100)), // Rotation degrees: 0 -> 360 over 100 ticks
                    RotationType.X_AXIS
                )
            )
        ).add()

    }
}