package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import net.clozynoii.slsb.network.SlsbModVariables;

public class RandomRankProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double randomrank = 0;
		randomrank = Mth.nextInt(RandomSource.create(), 1, 20);
		if (randomrank >= 1 && randomrank < 5) {
			{
				String _setval = "E";
				entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Rank = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("You Are " + "\u00A7f\u00A7lE-Rank")), true);
		}
		if (randomrank >= 5 && randomrank < 10) {
			{
				String _setval = "D";
				entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Rank = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("You Are " + "\u00A7a\u00A7lD-Rank")), true);
		}
		if (randomrank >= 10 && randomrank < 15) {
			{
				String _setval = "C";
				entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Rank = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("You Are " + "\u00A7d\u00A7lC-Rank")), true);
		}
		if (randomrank >= 15 && randomrank < 18) {
			{
				String _setval = "B";
				entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Rank = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("You Are " + "\u00A7b\u00A7lB-Rank")), true);
		}
		if (randomrank >= 18 && randomrank < 20) {
			{
				String _setval = "A";
				entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Rank = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("You Are " + "\u00A7e\u00A7lA-Rank")), true);
		}
		if (randomrank == 20) {
			{
				String _setval = "S";
				entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Rank = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("You Are " + "\u00A7c\u00A7lS-Rank")), true);
		}
	}
}
