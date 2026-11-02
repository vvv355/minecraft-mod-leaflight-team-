package ru.college.leaflight;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier; // Правильный импорт для Fabric (Yarn)
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LuminousLeaves implements ModInitializer {
	public static final String MOD_ID = "luminous-leaves";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		// Инициализация наших блоков
		ModBlocks.initialize();
	}

	// Полезный метод для создания ID (например, "luminous-leaves:luminous_leaves")
	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}