package xyz.gameoholic.partigonexampleplugin.particles.b_wrappers_groups

import org.bukkit.Bukkit
import org.bukkit.Location
import xyz.gameoholic.partigon.particle.SingularParticle
import xyz.gameoholic.partigon.particle.SingularParticle.Companion.singularParticle
import xyz.gameoholic.partigon.particle.envelope.Envelope
import xyz.gameoholic.partigon.particle.envelope.EnvelopeGroup
import xyz.gameoholic.partigon.particle.envelope.LinearEnvelope
import xyz.gameoholic.partigon.particle.location.ConstantLocation
import xyz.gameoholic.partigon.particle.loop.RepeatLoop
import xyz.gameoholic.partigon.util.Utils.envelope

object ALinearGroupParticle {
    fun getParticle() = singularParticle {
        originLocation = ConstantLocation(Location(Bukkit.getWorld("world"), 0.0, 300.0, 0.0))

        // Envelope groups are groups of 3 envelopes, that affect either 'position', or 'offset' property types.
        // You can create EnvelopeGroups with its constructor

        EnvelopeGroup(
            LinearEnvelope(
                Envelope.PropertyType.POS_X,
                (-4.0).envelope,
                2.0.envelope,
                RepeatLoop(100)
            ),
            LinearEnvelope(
                Envelope.PropertyType.POS_Y,
                (-4.0).envelope,
                2.0.envelope,
                RepeatLoop(100)
            ),
            LinearEnvelope(
                Envelope.PropertyType.POS_Z,
                (-4.0).envelope,
                2.0.envelope,
                RepeatLoop(100)
            )
        ).add() // Envelope groups have to be added with the add() extension function.

        // The above will create a line from (-4, -4, -4) to (2, 2, 2)

        // As you may have noticed, this is not the most ideal way of doing it.
        // A better way is shown in the next file, with envelope wrappers.

    }
}