package hungryZombies;

import java.util.List;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class eatDroppedFoodAI extends EntityAIBase{
	
	private EntityZombie zombie;
	private World world = null;
	double searchDistance = 2;
	
	  public eatDroppedFoodAI(EntityZombie ent)
	  {
	    this.zombie = ent;
	    this.world = ent.worldObj;
	  }
	
	@Override
	public boolean shouldExecute() {
		EntityItem closeFood = whatFoodIsNear();
		if ((closeFood != null) && (closeFood.getEntityItem().getItem() instanceof ItemFood))
		{
			execute(closeFood);
		}
		return false;
	}
	
	  public boolean execute(EntityItem enti)
	  {
		  enti.setDead();
		  world.playSoundEffect(zombie.posX, zombie.posY, zombie.posZ, "random.burp", 1F, 1.5F);
		  return true;
	  }
	  
	  
	  public EntityItem whatFoodIsNear()
	  {
	    List<EntityItem> items = getItems();
	    //Turns the list into single Item Entity's
	    for(EntityItem item : items) 
	    {
	    	EntityItem stack = item;  
	    	
	    	if(items != null)
	    	{
	    		return stack;
	    	}
	    }
		return null;
	  }
	
	  List<EntityItem> getItems() 
	  {
		return world.getEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getBoundingBox(zombie.posX - searchDistance, zombie.posY - searchDistance, zombie.posZ - searchDistance,
				zombie.posX + searchDistance, zombie.posY + searchDistance, zombie.posZ + searchDistance));
	  }	
}
