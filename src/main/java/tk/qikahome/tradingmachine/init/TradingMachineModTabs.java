
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package tk.qikahome.tradingmachine.init;

import tk.qikahome.tradingmachine.TradingMachineMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

public class TradingMachineModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TradingMachineMod.MODID);
	public static final RegistryObject<CreativeModeTab> TRADING_MACHINE_TAB = REGISTRY.register("trading_machine_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.trading_machine.trading_machine_tab")).icon(() -> new ItemStack(TradingMachineModItems.TFC_COIN.get())).displayItems((parameters, tabData) -> {
				tabData.accept(TradingMachineModItems.TFC_COIN.get());
				tabData.accept(TradingMachineModItems.TFC_CARD.get());
				tabData.accept(TradingMachineModItems.TFC_CARD_NOT_REGISTERED.get());
				tabData.accept(TradingMachineModBlocks.CREATIVE_TRADING_MACHINE.get().asItem());
				tabData.accept(TradingMachineModBlocks.STONE_TRADING_MACHINE.get().asItem());
			}).build());
}
