
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package tk.qikahome.tradingmachine.init;

import tk.qikahome.tradingmachine.item.TradingPanelItem;
import tk.qikahome.tradingmachine.item.TFCCoinItem;
import tk.qikahome.tradingmachine.item.TFCCardNotRegisteredItem;
import tk.qikahome.tradingmachine.item.TFCCardItem;
import tk.qikahome.tradingmachine.TradingMachineMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

public class TradingMachineModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TradingMachineMod.MODID);
	public static final RegistryObject<Item> TFC_COIN = REGISTRY.register("tfc_coin", () -> new TFCCoinItem());
	public static final RegistryObject<Item> TFC_CARD = REGISTRY.register("tfc_card", () -> new TFCCardItem());
	public static final RegistryObject<Item> TFC_CARD_NOT_REGISTERED = REGISTRY.register("tfc_card_not_registered", () -> new TFCCardNotRegisteredItem());
	public static final RegistryObject<Item> CREATIVE_TRADING_MACHINE = block(TradingMachineModBlocks.CREATIVE_TRADING_MACHINE);
	public static final RegistryObject<Item> STONE_TRADING_MACHINE = block(TradingMachineModBlocks.STONE_TRADING_MACHINE);
	public static final RegistryObject<Item> TRADING_PANEL = REGISTRY.register("trading_panel", () -> new TradingPanelItem());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
