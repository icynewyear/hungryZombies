package hungryZombies;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="hungryZombies", name="Hungry Zombies", version="1.0.0", acceptableRemoteVersions = "*")
public class hungryZombies 
{

	@Mod.EventHandler
	public void load(FMLInitializationEvent evt)
	{
		MinecraftForge.EVENT_BUS.register(new zombieSpawnEventHandler());
	}
}
