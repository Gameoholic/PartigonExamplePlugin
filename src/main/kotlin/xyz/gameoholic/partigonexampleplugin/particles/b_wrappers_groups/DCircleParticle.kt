package xyz.gameoholic.partigonexampleplugin.particles.b_wrappers_groups

import org.bukkit.Bukkit
import org.bukkit.Location
import xyz.gameoholic.partigon.particle.SingularParticle
import xyz.gameoholic.partigon.particle.SingularParticle.Companion.singularParticle
import xyz.gameoholic.partigon.particle.envelope.EnvelopeGroup
import xyz.gameoholic.partigon.particle.envelope.wrapper.CircleEnvelopeWrapper.circleEnvelopeGroup
import xyz.gameoholic.partigon.particle.envelope.wrapper.CurveEnvelopeWrapper
import xyz.gameoholic.partigon.particle.envelope.wrapper.CurveEnvelopeWrapper.curveEnvelopeGroup
import xyz.gameoholic.partigon.particle.location.ConstantLocation
import xyz.gameoholic.partigon.particle.loop.BounceLoop
import xyz.gameoholic.partigon.particle.loop.RepeatLoop
import xyz.gameoholic.partigon.util.EnvelopePair
import xyz.gameoholic.partigon.util.EnvelopeTriple
import xyz.gameoholic.partigon.util.Utils.envelope

object DCircleParticle {
    fun getParticle() = singularParticle {
        originLocation = ConstantLocation(Location(Bukkit.getWorld("world"), 0.0, 300.0, 0.0))

        circleEnvelopeGroup(
            EnvelopeGroup.EnvelopeGroupType.POSITION,
            EnvelopePair(0.0.envelope, 0.0.envelope), // Center of circle: (0, 0) in the XZ plane
            3.0.envelope, // Radius of circle: 3.0
            RepeatLoop(100),
            // completion = 0.5 // Every envelope and wrapper method comes with completion. Setting to 0.5 will only draw half a circle, etc.
        ).add()

    }
}