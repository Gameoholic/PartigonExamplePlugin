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

object CAnotherCircleParticle {
    fun getParticle() = singularParticle {
        originLocation = ConstantLocation(Location(Bukkit.getWorld("world"), 0.0, 300.0, 0.0))

        // When particle count is set to 0 (it is by default), offset acts as motion
        // values for the particle, with extra acting as a multiplier
        extra = 0.1.envelope

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
            RepeatLoop(100)
        ).add()


        // We can use the addToGroups() extension function to apply the rotation
        // to all the groups. This method is nicer, so you should prefer it over
        // adding them to each group separately.
        RotationOptions(
            EnvelopeTriple(0.0.envelope, 0.0.envelope, 0.0.envelope),
            LinearEnvelope(0.0.envelope, 360.0.envelope, RepeatLoop(100)),
            RotationType.Z_AXIS
        ).addToGroups()
    }
}