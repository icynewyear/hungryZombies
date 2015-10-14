package hungryZombies;

import java.io.File;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import hungryZombies.hungryZombiesConfig;






@Mod(modid = "hungryZombies", name = "Hungry Zombies", version = "1.2.0", acceptableRemoteVersions = "*")
public class hungryZombies {
	public static hungryZombiesConfig config;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		String path = event.getSuggestedConfigurationFile().getAbsolutePath();
		config = hungryZombiesConfig.initialize(new File(path));	
	}
	
	
	@Mod.EventHandler
	public void load(FMLInitializationEvent evt) {
		MinecraftForge.EVENT_BUS.register(new zombieSpawnEventHandler());
	}
	}
