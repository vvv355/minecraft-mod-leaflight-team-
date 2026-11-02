package ru.college.leaflight;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback; // Импорт для события
import net.minecraft.text.Text; // Импорт для текста
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LuminousLeaves implements ModInitializer {
	public static final String MOD_ID = "luminous-leaves";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Проект загружен успешно");
		ModBlocks.initialize();

		// Реализация дополнительного поведения
		UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
			// Проверяем, что действие происходит на сервере (не на клиенте) и кликнули именно по нашему блоку
			if (!world.isClient() && world.getBlockState(hitResult.getBlockPos()).isOf(ModBlocks.LUMINOUS_LEAVES)) {
				player.sendMessage(Text.literal("§eЛиства мягко светится..."), false); // Вывод сообщения
				return ActionResult.SUCCESS; // Указываем, что действие выполнено
			}
			return ActionResult.PASS; // Для всех остальных блоков ничего не делаем
		});
	}
}