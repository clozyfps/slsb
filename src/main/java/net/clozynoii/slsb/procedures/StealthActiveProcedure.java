package net.clozynoii.slsb.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class StealthActiveProcedure {
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
ItemStack helmetsave = ItemStack.EMPTY;ItemStack chestsave = ItemStack.EMPTY;ItemStack leggingssave = ItemStack.EMPTY;ItemStack bootssave = ItemStack.EMPTY;
if () {entity.getPersistentData().putDouble("stealthtick", (entity.getPersistentData().getDouble("stealthtick")+1));if (entity.getPersistentData().getDouble("stealthtick")>=20) {entity.getPersistentData().putDouble("stealthtick", 0);if (world instanceof ServerLevel _level) {
Entity entityToSpawn = SlsbModEntities.DELETED_MOD_ELEMENT.get().spawn(_level, BlockPos.containing(x,y,z), MobSpawnType.MOB_SUMMONED);
if (entityToSpawn != null) {
entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
}
}
if (!world.getEntitiesOfClass(AfterImageEntity.class,
AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true)
.isEmpty()) {if (((Entity) world.getEntitiesOfClass(AfterImageEntity.class,
AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true)
.stream().sorted(new Object() {
Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
}
}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof TamableAnimal _toTame && entity instanceof Player _owner) _toTame.tame(_owner);{
Entity _ent = entity;
_ent.setYRot(((Entity) world.getEntitiesOfClass(AfterImageEntity.class,
AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true)
.stream().sorted(new Object() {
Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
}
}.compareDistOf(x, y, z)).findFirst().orElse(null)).getYRot());
_ent.setXRot(((Entity) world.getEntitiesOfClass(AfterImageEntity.class,
AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true)
.stream().sorted(new Object() {
Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
}
}.compareDistOf(x, y, z)).findFirst().orElse(null)).getXRot());
_ent.setYBodyRot(_ent.getYRot());
_ent.setYHeadRot(_ent.getYRot());
_ent.yRotO = _ent.getYRot();
_ent.xRotO = _ent.getXRot();
if (_ent instanceof LivingEntity _entity) {
_entity.yBodyRotO = _entity.getYRot();
_entity.yHeadRotO = _entity.getYRot();
}
}}}}
}
}
