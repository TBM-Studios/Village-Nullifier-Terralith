package io.github.tbmstudios.villagenullifier;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
public class VillageNullifier implements ModInitializer {
    
    @Override
    public void onInitialize() {
        String configPath = "config/villagenullifier.json";
        ConfigHandler.createConfigFile(configPath);
        ConfigHandler.readConfigFile(configPath);
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        Constants.LOG.info("Hello Fabric world!");
        CommonClass.init();
    }
}