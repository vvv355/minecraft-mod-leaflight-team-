package ru.college.leaflight;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
// ПРАВИЛЬНЫЙ импорт для Fabric 1.21.1
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.color.world.BiomeColors;

public class LuminousLeavesClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		// Устанавливаем слой рендеринга CUTOUT для нашего блока
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LUMINOUS_LEAVES, RenderLayer.getCutout());

		// Ваш код для окрашивания
		ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
			if (tintIndex == 0) {
				if (view != null && pos != null) {
					return BiomeColors.getFoliageColor(view, pos);
				}
				return 0x48B518;
			}
			return 0xFFFFFF;
		}, ModBlocks.LUMINOUS_LEAVES);

		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
			if (tintIndex == 0) {
				return 0x48B518;
			}
			return 0xFFFFFF;
		}, ModBlocks.LUMINOUS_LEAVES);
	}
}