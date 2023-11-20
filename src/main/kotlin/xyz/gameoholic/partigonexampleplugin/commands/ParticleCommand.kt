package xyz.gameoholic.partigonexampleplugin.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import xyz.gameoholic.partigonexampleplugin.PartigonExamplePlugin
import xyz.gameoholic.partigonexampleplugin.particles.a_basic.DArchParticle
import xyz.gameoholic.partigonexampleplugin.particles.a_basic.ANoMotionParticle
import xyz.gameoholic.partigonexampleplugin.particles.a_basic.BUpwardsParticle
import xyz.gameoholic.partigonexampleplugin.particles.a_basic.CZigZagParticle
import xyz.gameoholic.partigonexampleplugin.particles.b_wrappers_groups.*
import xyz.gameoholic.partigonexampleplugin.particles.c_rotation.ARotatedCircleParticle
import xyz.gameoholic.partigonexampleplugin.particles.c_rotation.BRotatingCircleParticle
import xyz.gameoholic.partigonexampleplugin.particles.c_rotation.CAnotherCircleParticle
import xyz.gameoholic.partigonexampleplugin.particles.d_cool_examples.*

class ParticleCommand(val plugin: PartigonExamplePlugin): CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (args.isNullOrEmpty()) return true
        plugin.particle?.stop()
        plugin.particle = null
        when (args[0]) {
            "no_motion" -> plugin.particle = ANoMotionParticle.getParticle()
            "upwards" -> plugin.particle = BUpwardsParticle.getParticle()
            "zig_zag" -> plugin.particle = CZigZagParticle.getParticle()
            "arch" -> plugin.particle = DArchParticle.getParticle()
            "linear_group" -> plugin.particle = ALinearGroupParticle.getParticle()
            "linear_wrapper" -> plugin.particle = BLinearWrapperParticle.getParticle()
            "arch_wrapper" -> plugin.particle = CArchWrapperParticle.getParticle()
            "circle" -> plugin.particle = DCircleParticle.getParticle()
            "spiral" -> plugin.particle = ESpiralParticle.getParticle()
            "rotated_circle" -> plugin.particle = ARotatedCircleParticle.getParticle()
            "rotating_circle" -> plugin.particle = BRotatingCircleParticle.getParticle()
            "another_circle" -> plugin.particle = CAnotherCircleParticle.getParticle()
            "shrinking_flower" -> plugin.particle = ShrinkingFlowerParticle.getParticle()
            "pillar" -> plugin.particle = PillarParticle.getParticle()
            "nexus" -> plugin.particle = NexusParticle.getParticle()
            "star" -> plugin.particle = StarParticle.getParticle()
            "circle_flower" -> plugin.particle = CircleFlowerParticle.getParticle()
            "circle_ripple" -> plugin.particle = CircleRippleParticle.getParticle()
        }
        plugin.particle?.start()
        return true
    }
}