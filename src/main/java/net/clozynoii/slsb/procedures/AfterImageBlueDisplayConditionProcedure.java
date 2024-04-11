package net.clozynoii.slsb.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class AfterImageBlueDisplayConditionProcedure {
public static boolean execute(
Entity entity
) {
if(
entity == null
) return false;
if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame():false) {if (().equals("Blue")) {return
true;}}return
false;
}
}
