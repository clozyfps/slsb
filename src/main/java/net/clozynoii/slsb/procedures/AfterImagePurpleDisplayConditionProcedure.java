package net.clozynoii.slsb.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class AfterImagePurpleDisplayConditionProcedure {
public static boolean execute(
Entity entity
) {
if(
entity == null
) return false;
if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame():false) {if (().equals("Purple")) {return
true;}}return
false;
}
}
