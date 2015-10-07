package hungryZombies;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraftforge.event.entity.living.LivingEvent;
import hungryZombies.hungryZombiesConfig;

public class zombieSpawnEventHandler {

	@SubscribeEvent
	public void addHuntToZombies(LivingEvent.LivingUpdateEvent evt) {
		if ((evt.entityLiving.ticksExisted < 5)) {
			EntityMob mob;

			if (evt.entityLiving instanceof EntityZombie) {
				mob = (EntityZombie) evt.entityLiving;
			} else {
				mob = null;
			}
			if (mob != null) {
				if(hungryZombiesConfig.ZOMBIESEATFOOD) mob.tasks.addTask(4, new eatDroppedFoodAI((EntityZombie) mob));
				mob.tasks.addTask(4, new EntityAIAttackOnCollide(mob, EntityCow.class, 1.0D, true));
				mob.tasks.addTask(4, new EntityAIAttackOnCollide(mob, EntitySheep.class, 1.0D, true));
				mob.tasks.addTask(4, new EntityAIAttackOnCollide(mob, EntityPig.class, 1.0D, true));
				mob.targetTasks.addTask(2, new EntityAINearestAttackableTarget(mob, EntityCow.class, 0, false));
				mob.targetTasks.addTask(2, new EntityAINearestAttackableTarget(mob, EntitySheep.class, 0, false));
				mob.targetTasks.addTask(2, new EntityAINearestAttackableTarget(mob, EntityPig.class, 0, false));

			}
		}
	}
}
