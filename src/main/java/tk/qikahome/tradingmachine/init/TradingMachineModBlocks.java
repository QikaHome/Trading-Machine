
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package tk.qikahome.tradingmachine.init;

import tk.qikahome.tradingmachine.block.StoneTradingMachineBlock;
import tk.qikahome.tradingmachine.block.CreativeTradingMachineBlock;
import tk.qikahome.tradingmachine.TradingMachineMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

public class TradingMachineModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, TradingMachineMod.MODID);
	public static final RegistryObject<Block> CREATIVE_TRADING_MACHINE = REGISTRY.register("creative_trading_machine", () -> new CreativeTradingMachineBlock());
	public static final RegistryObject<Block> STONE_TRADING_MACHINE = REGISTRY.register("stone_trading_machine", () -> new StoneTradingMachineBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
