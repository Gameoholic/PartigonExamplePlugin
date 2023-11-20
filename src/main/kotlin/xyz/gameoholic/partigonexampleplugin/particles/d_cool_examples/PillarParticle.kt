package xyz.gameoholic.partigonexampleplugin.particles.d_cool_examples

import org.bukkit.Bukkit
import org.bukkit.Location
import xyz.gameoholic.partigon.particle.MultiParticle.Companion.multiParticle
import xyz.gameoholic.partigon.particle.SingularParticle.Companion.singularParticleBuilder
import xyz.gameoholic.partigon.particle.envelope.Envelope
import xyz.gameoholic.partigon.particle.envelope.EnvelopeGroup
import xyz.gameoholic.partigon.particle.envelope.wrapper.CircleEnvelopeWrapper.circleEnvelopeGroup
import xyz.gameoholic.partigon.particle.envelope.wrapper.CurveEnvelopeWrapper
import xyz.gameoholic.partigon.particle.envelope.wrapper.CurveEnvelopeWrapper.curveEnvelope
import xyz.gameoholic.partigon.particle.location.ConstantLocation
import xyz.gameoholic.partigon.particle.loop.BounceLoop
import xyz.gameoholic.partigon.particle.loop.RepeatLoop
import xyz.gameoholic.partigon.util.EnvelopePair
import xyz.gameoholic.partigon.util.EnvelopeTriple
import xyz.gameoholic.partigon.util.Utils.envelope
import xyz.gameoholic.partigon.util.rotation.RotationOptions
import xyz.gameoholic.partigon.util.rotation.RotationType

object PillarParticle {
    fun getParticle() = multiParticle {
        fun builder() = singularParticleBuilder {
            originLocation = ConstantLocation(Location(Bukkit.getWorld("world"), 0.0, 300.0, 0.0))

            circleEnvelopeGroup(
                EnvelopeGroup.EnvelopeGroupType.POSITION,
                EnvelopePair(0.0.envelope, 0.0.envelope),
                3.0.envelope,
                RepeatLoop(100)
            ).add()

            circleEnvelopeGroup(
                EnvelopeGroup.EnvelopeGroupType.OFFSET,
                EnvelopePair(0.0.envelope, 0.0.envelope),
                3.0.envelope,
                RepeatLoop(100),
                listOf(
                    RotationOptions(
                        EnvelopeTriple(0.0.envelope, 0.0.envelope, 0.0.envelope),
                        180.0.envelope, RotationType.Y_AXIS
                    )
                )
            ).add()

            curveEnvelope(
                Envelope.PropertyType.POS_Y,
                0.0.envelope,
                4.0.envelope, // Because completion is 1.0 by default, it'll go from 0.0 -> 4.0, then from 4.0 -> 8.0. Can set to 0.5, but it'll be less smooth, better to take advantage of the sin/cos functions.
                CurveEnvelopeWrapper.CurveOrientation.BELOW, // Can alternatively use ABOVE, will result in a slightly different effect.
                BounceLoop(200) // Will go from 0.0 to 8.0 in 100 ticks, then go back to 0.0 in 100 ticks. Then repeat.
            ).add()

            extra = 0.05.envelope
        }

        // Mirror all particles:
        repeat(3) {
            builder().apply {
                RotationOptions(
                    EnvelopeTriple(0.0.envelope, 0.0.envelope, 0.0.envelope),
                    (it * 120.0).envelope, RotationType.Y_AXIS
                ).addToGroups()
            }.build().add()
        }

        repeat(3) {
            builder().apply {
                RotationOptions(
                    EnvelopeTriple(0.0.envelope, 0.0.envelope, 0.0.envelope),
                    (it * 120.0).envelope, RotationType.Y_AXIS
                ).addToGroups()
                RotationOptions(
                    EnvelopeTriple(0.0.envelope, 0.0.envelope, 0.0.envelope),
                    (180.0).envelope, RotationType.Z_AXIS
                ).addToGroups()
            }.build().add()
        }
    }

}
