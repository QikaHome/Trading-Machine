
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package tk.qikahome.tradingmachine.init;

import tk.qikahome.tradingmachine.world.inventory.TradingGUIMenu;
import tk.qikahome.tradingmachine.world.inventory.TMConfigGUIMenu;
import tk.qikahome.tradingmachine.world.inventory.TFCCardRegisterMenu;
import tk.qikahome.tradingmachine.world.inventory.CreativeTMConfigGUIMenu;
import tk.qikahome.tradingmachine.TradingMachineMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

public class TradingMachineModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, TradingMachineMod.MODID);
	public static final RegistryObject<MenuType<TFCCardRegisterMenu>> TFC_CARD_REGISTER = REGISTRY.register("tfc_card_register", () -> IForgeMenuType.create(TFCCardRegisterMenu::new));
	public static final RegistryObject<MenuType<TradingGUIMenu>> TRADING_GUI = REGISTRY.register("trading_gui", () -> IForgeMenuType.create(TradingGUIMenu::new));
	public static final RegistryObject<MenuType<CreativeTMConfigGUIMenu>> CREATIVE_TM_CONFIG_GUI = REGISTRY.register("creative_tm_config_gui", () -> IForgeMenuType.create(CreativeTMConfigGUIMenu::new));
	public static final RegistryObject<MenuType<TMConfigGUIMenu>> TM_CONFIG_GUI = REGISTRY.register("tm_config_gui", () -> IForgeMenuType.create(TMConfigGUIMenu::new));
}
