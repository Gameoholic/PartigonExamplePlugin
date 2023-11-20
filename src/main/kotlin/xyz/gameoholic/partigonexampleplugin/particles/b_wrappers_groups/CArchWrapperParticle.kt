package xyz.gameoholic.partigonexampleplugin.particles.b_wrappers_groups

import org.bukkit.Bukkit
import org.bukkit.Location
import xyz.gameoholic.partigon.particle.SingularParticle
import xyz.gameoholic.partigon.particle.SingularParticle.Companion.singularParticle
import xyz.gameoholic.partigon.particle.envelope.EnvelopeGroup
import xyz.gameoholic.partigon.particle.envelope.TrigonometricEnvelope
import xyz.gameoholic.partigon.particle.envelope.wrapper.CurveEnvelopeWrapper
import xyz.gameoholic.partigon.particle.envelope.wrapper.CurveEnvelopeWrapper.curveEnvelopeGroup
import xyz.gameoholic.partigon.particle.location.ConstantLocation
import xyz.gameoholic.partigon.particle.loop.BounceLoop
import xyz.gameoholic.partigon.util.EnvelopeTriple
import xyz.gameoholic.partigon.util.Utils.envelope

object CArchWrapperParticle {
    fun getParticle() = singularParticle {
        originLocation = ConstantLocation(Location(Bukkit.getWorld("world"), 0.0, 300.0, 0.0))

        // We will improve how we created the arch in one of the previous examples.

        curveEnvelopeGroup(
            EnvelopeGroup.EnvelopeGroupType.POSITION,
            EnvelopeTriple(0.0.envelope, 0.0.envelope, 0.0.envelope),
            EnvelopeTriple(4.0.envelope, 4.0.envelope, 4.0.envelope),
            CurveEnvelopeWrapper.CurveOrientation.RIGHT_BELOW,
            BounceLoop(200)
        ).add()


    }
}