package net.clozynoii.slsb.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HealActiveProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

private static void execute(
@Nullable Event event,
LevelAccessor world,
double x,
double y,
double z,
Entity entity
) {
if(
entity == null
) return ;
if () {if (entity.isAlive()) {if (!entity.isShiftKeyDown()) {if (entity instanceof LivingEntity _entity) _entity.setHealth((float)((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth():-1)+0.5+/ 250));if ((entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new SlsbModVariables.PlayerVariables())).Mana>0) {{
double _setval = (entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new SlsbModVariables.PlayerVariables())).Mana-2;
entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.Mana = _setval;
capability.syncPlayerVariables(entity);
});
}
}if ((entity.getCapability(SlsbModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new SlsbModVariables.PlayerVariables())).Mana<=0) {}}else if (entity.isShiftKeyDown()) {{
final Vec3 _center = new Vec3(x, y, z);
List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true)
.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
for (Entity entityiterator : _entfound) {
if (false) {if (entity instanceof LivingEntity _entity) _entity.setHealth((float)((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth():-1)+0.4+/ 250));}
}
}}}}
}
}
