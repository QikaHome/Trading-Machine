
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package tk.qikahome.tradingmachine.init;

import tk.qikahome.tradingmachine.client.gui.TradingGUIScreen;
import tk.qikahome.tradingmachine.client.gui.TMConfigGUIScreen;
import tk.qikahome.tradingmachine.client.gui.TFCCardRegisterScreen;
import tk.qikahome.tradingmachine.client.gui.CreativeTMConfigGUIScreen;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TradingMachineModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(TradingMachineModMenus.TFC_CARD_REGISTER.get(), TFCCardRegisterScreen::new);
			MenuScreens.register(TradingMachineModMenus.TRADING_GUI.get(), TradingGUIScreen::new);
			MenuScreens.register(TradingMachineModMenus.CREATIVE_TM_CONFIG_GUI.get(), CreativeTMConfigGUIScreen::new);
			MenuScreens.register(TradingMachineModMenus.TM_CONFIG_GUI.get(), TMConfigGUIScreen::new);
		});
	}
}
