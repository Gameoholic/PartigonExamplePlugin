package xyz.gameoholic.partigonexampleplugin.particles.b_wrappers_groups

import org.bukkit.Bukkit
import org.bukkit.Location
import xyz.gameoholic.partigon.particle.SingularParticle
import xyz.gameoholic.partigon.particle.SingularParticle.Companion.singularParticle
import xyz.gameoholic.partigon.particle.envelope.EnvelopeGroup
import xyz.gameoholic.partigon.particle.envelope.wrapper.LinearEnvelopeWrapper.linearEnvelopeGroup
import xyz.gameoholic.partigon.particle.location.ConstantLocation
import xyz.gameoholic.partigon.particle.loop.RepeatLoop
import xyz.gameoholic.partigon.util.EnvelopeTriple
import xyz.gameoholic.partigon.util.Utils.envelope

object BLinearWrapperParticle {

    fun getParticle() = singularParticle {
        originLocation = ConstantLocation(Location(Bukkit.getWorld("world"), 0.0, 300.0, 0.0))


        // As with the previous example, we want to create a straight line between 2 points.

        // Instead of creating 3 separate envelopes for the X,Y,Z by hand,
        // we use an envelope wrapper method and create an Envelope Group.

        // Envelope wrappers ease the process of using envelopes, are preferred over
        // vanilla envelopes when dealing with position/offset properties directly.
        // You should use them whenever possible and convenient.

        // Make sure to import the wrapper method.

        // This wrapper will return an Envelope Group

        linearEnvelopeGroup(
            EnvelopeGroup.EnvelopeGroupType.POSITION, // Can be either POSITION or OFFSET
            EnvelopeTriple((-4.0).envelope, (-4.0).envelope, (-4.0).envelope), // First position: (-4, -4, -4)
            EnvelopeTriple(2.0.envelope, 2.0.envelope, 2.0.envelope), // Second position (2, 2, 2)
            RepeatLoop(100)
        ).add()

        // See? Much less boilerplate!
    }

}