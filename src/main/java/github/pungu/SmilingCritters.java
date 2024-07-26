package github.pungu;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.util.Identifier;
import github.pungu.init.initialize;

public class SmilingCritters implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("smilingcritters");
	public static final String MOD_ID = "smilingcritters";
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		initialize.init();
		LOGGER.info("Hello Smiling Critter world!");
	}

	public static Identifier id(String path){
		return Identifier.of(MOD_ID, path);
	}
}