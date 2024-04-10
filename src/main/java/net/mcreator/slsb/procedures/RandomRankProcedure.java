package net.mcreator.slsb.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import net.mcreator.slsb.network.SlsbModVariables;

public class RandomRankProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double randomrank = 0;
		randomrank = Mth.nextInt(RandomSource.create(), 1, 6);
		if (randomrank == 1) {
			{
				String _setval = "Mage";
				entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HunterClass = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Your class is" + "\u00A7b\u00A7lMage")), true);
		}
		if (randomrank == 2) {
			{
				String _setval = "Assassin";
				entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HunterClass = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Your class is" + "\u00A79\u00A7lAssassin")), true);
		}
		if (randomrank == 3) {
			{
				String _setval = "Ranger";
				entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HunterClass = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Your class is" + "\u00A72\u00A7lRanger")), true);
		}
		if (randomrank == 4) {
			{
				String _setval = "Healer";
				entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HunterClass = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Your class is" + "\u00A7a\u00A7lHealer")), true);
		}
		if (randomrank == 5) {
			{
				String _setval = "Fighter";
				entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HunterClass = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Your class is" + "\u00A76\u00A7lFighter")), true);
		}
		if (randomrank == 6) {
			{
				String _setval = "Tanker";
				entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HunterClass = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Your class is" + "\u00A7c\u00A7lTanker")), true);
		}
	}
}
