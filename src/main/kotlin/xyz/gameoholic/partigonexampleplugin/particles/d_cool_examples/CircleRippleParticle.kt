package xyz.gameoholic.partigonexampleplugin.particles.d_cool_examples

import org.bukkit.Bukkit
import org.bukkit.Location
import xyz.gameoholic.partigon.particle.SingularParticle.Companion.singularParticle
import xyz.gameoholic.partigon.particle.envelope.Envelope
import xyz.gameoholic.partigon.particle.envelope.EnvelopeGroup
import xyz.gameoholic.partigon.particle.envelope.TrigonometricEnvelope
import xyz.gameoholic.partigon.particle.envelope.wrapper.CircleEnvelopeWrapper
import xyz.gameoholic.partigon.particle.envelope.wrapper.CircleEnvelopeWrapper.circleEnvelopeGroup
import xyz.gameoholic.partigon.particle.location.ConstantLocation
import xyz.gameoholic.partigon.particle.loop.RepeatLoop
import xyz.gameoholic.partigon.util.EnvelopePair
import xyz.gameoholic.partigon.util.Utils.envelope

// todo: this example uses deprecated fields, and is a bit old. Replace someday

object CircleRippleParticle {
    fun getParticle() = singularParticle {
        originLocation = ConstantLocation(Location(Bukkit.getWorld("world"), 0.0, 300.0, 0.0))
        val framesPerTick = 10
        animationFrameAmount = framesPerTick
        extra = 0.1.envelope

        val circlePoint1 = TrigonometricEnvelope(
            Envelope.PropertyType.NONE,
            1.5.envelope,
            0.0.envelope,
            TrigonometricEnvelope.TrigFunc.COS,
            RepeatLoop(50 * framesPerTick)
        )
        val circlePoint2 = TrigonometricEnvelope(
            Envelope.PropertyType.NONE,
            (-1.5).envelope,
            0.0.envelope,
            TrigonometricEnvelope.TrigFunc.COS,
            RepeatLoop(50 * framesPerTick)
        )

        circleEnvelopeGroup(
            EnvelopeGroup.EnvelopeGroupType.POSITION,
            EnvelopePair(circlePoint2, 0.0.envelope),
            EnvelopePair(0.0.envelope, circlePoint1),
            CircleEnvelopeWrapper.CircleDirection.RIGHT,
            RepeatLoop(framesPerTick),
        ).add()
        circleEnvelopeGroup(
            EnvelopeGroup.EnvelopeGroupType.OFFSET,
            EnvelopePair(circlePoint2, 0.0.envelope),
            EnvelopePair(0.0.envelope, circlePoint1),
            CircleEnvelopeWrapper.CircleDirection.RIGHT,
            RepeatLoop(10 * framesPerTick),
        ).add()
    }
}