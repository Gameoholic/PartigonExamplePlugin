package xyz.gameoholic.partigonexampleplugin.particles.c_rotation

import org.bukkit.Bukkit
import org.bukkit.Location
import xyz.gameoholic.partigon.particle.SingularParticle.Companion.singularParticle
import xyz.gameoholic.partigon.particle.envelope.EnvelopeGroup
import xyz.gameoholic.partigon.particle.envelope.wrapper.CircleEnvelopeWrapper.circleEnvelopeGroup
import xyz.gameoholic.partigon.particle.location.ConstantLocation
import xyz.gameoholic.partigon.particle.loop.RepeatLoop
import xyz.gameoholic.partigon.util.EnvelopePair
import xyz.gameoholic.partigon.util.EnvelopeTriple
import xyz.gameoholic.partigon.util.Utils.envelope
import xyz.gameoholic.partigon.util.rotation.RotationOptions
import xyz.gameoholic.partigon.util.rotation.RotationType

object ARotatedCircleParticle {
    fun getParticle() = singularParticle {
        originLocation = ConstantLocation(Location(Bukkit.getWorld("world"), 0.0, 300.0, 0.0))

        // Remember how our circle envelope wrapper only allows for circles to be created
        // on the XZ plane?
        // To fix this, we apply a rotation to it.

        // Envelope groups allow rotations to be applied to it.

        // The following will create the same circle on the ZY plane.
        circleEnvelopeGroup(
            EnvelopeGroup.EnvelopeGroupType.POSITION,
            EnvelopePair(0.0.envelope, 0.0.envelope),
            3.0.envelope,
            RepeatLoop(50),
            rotationOptions = listOf(
                RotationOptions(
                    EnvelopeTriple(0.0.envelope, 0.0.envelope, 0.0.envelope), // Point of reference for the rotation - center of circle
                    90.0.envelope, // Will rotate 90 degrees
                    RotationType.Z_AXIS // Will rotate around Z Axis
                )
            )
        ).add()
    }
}