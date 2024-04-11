package net.clozynoii.slsb.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import net.clozynoii.slsb.network.SlsbModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetMoveProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (DoubleArgumentType.getDouble(arguments, "movenumber") == 1) {
			{
				String _setval = StringArgumentType.getString(arguments, "movename");
				entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Move1 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (DoubleArgumentType.getDouble(arguments, "movenumber") == 2) {
			{
				String _setval = StringArgumentType.getString(arguments, "movename");
				entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Move2 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (DoubleArgumentType.getDouble(arguments, "movenumber") == 3) {
			{
				String _setval = StringArgumentType.getString(arguments, "movename");
				entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Move3 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (DoubleArgumentType.getDouble(arguments, "movenumber") == 4) {
			{
				String _setval = StringArgumentType.getString(arguments, "movename");
				entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Move4 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
