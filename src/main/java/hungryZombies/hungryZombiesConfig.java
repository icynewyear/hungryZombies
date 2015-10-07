package hungryZombies;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class hungryZombiesConfig {
	private static hungryZombiesConfig instance = null;
	public static String ZOMBIE_GENERAL = "General";
	public static boolean ZOMBIESEATFOOD;
	public static Configuration config;
	
	private hungryZombiesConfig(File configFile)
	{
		config = new Configuration(configFile);
		config.load();
		hungryZombiesConfig.Configs();
		config.save();
	}

	public static hungryZombiesConfig initialize(File configFile)
	{
		if (instance == null)
			instance = new hungryZombiesConfig(configFile);
		else
			throw new IllegalStateException("Cannot initialize HUngry Zombies Config twice");
		return instance;
	}
    public static hungryZombiesConfig instance() 
    {
        if (instance == null) 
        {
            throw new IllegalStateException("Instance of Hungry Zombies Config requested before initialization");
        }
        return instance;
    }
	
	
	private static void Configs() {
		System.out.println("Config enter");
		ZOMBIESEATFOOD = config.get(ZOMBIE_GENERAL, "eat off ground", false,"Zombies eat food off the ground").getBoolean();
		
	}
	
}
