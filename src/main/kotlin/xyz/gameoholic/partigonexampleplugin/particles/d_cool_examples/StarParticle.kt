package xyz.gameoholic.partigonexampleplugin.particles.d_cool_examples

import org.bukkit.Bukkit
import org.bukkit.Location
import xyz.gameoholic.partigon.particle.MultiParticle.Companion.multiParticle
import xyz.gameoholic.partigon.particle.SingularParticle.Companion.singularParticleBuilder
import xyz.gameoholic.partigon.particle.envelope.EnvelopeGroup
import xyz.gameoholic.partigon.particle.envelope.TrigonometricEnvelope
import xyz.gameoholic.partigon.particle.envelope.wrapper.CircleEnvelopeWrapper.circleEnvelopeGroup
import xyz.gameoholic.partigon.particle.location.ConstantLocation
import xyz.gameoholic.partigon.particle.loop.BounceLoop
import xyz.gameoholic.partigon.particle.loop.RepeatLoop
import xyz.gameoholic.partigon.util.EnvelopePair
import xyz.gameoholic.partigon.util.EnvelopeTriple
import xyz.gameoholic.partigon.util.Utils.envelope
import xyz.gameoholic.partigon.util.rotation.RotationOptions
import xyz.gameoholic.partigon.util.rotation.RotationType

object StarParticle {
    fun getParticle() = multiParticle {
        fun builder() =
            singularParticleBuilder {
                originLocation = ConstantLocation(Location(Bukkit.getWorld("world"), 0.0, 300.0, 0.0))

                circleEnvelopeGroup(
                    EnvelopeGroup.EnvelopeGroupType.POSITION,
                    EnvelopePair(0.0.envelope, 0.0.envelope), // center
                    TrigonometricEnvelope(
                        4.0.envelope,
                        2.0.envelope,
                        TrigonometricEnvelope.TrigFunc.SIN,
                        BounceLoop(100)
                    ), // radius
                    RepeatLoop(100)
                ).add()

                circleEnvelopeGroup(
                    EnvelopeGroup.EnvelopeGroupType.OFFSET,
                    EnvelopePair(0.0.envelope, 0.0.envelope), // center
                    3.0.envelope, // radius
                    RepeatLoop(100),
                    listOf(
                        RotationOptions(
                            EnvelopeTriple(0.0.envelope, 0.0.envelope, 0.0.envelope),
                            180.0.envelope, RotationType.Y_AXIS
                        )
                    )
                ).add()

                extra = 0.05.envelope
            }



        repeat(6) {
            builder().apply {
                RotationOptions(
                    EnvelopeTriple(0.0.envelope, 0.0.envelope, 0.0.envelope),
                    (it * 60.0).envelope, RotationType.Y_AXIS // 10
                ).addToGroups()
            }.build().add()
        }
    }
}