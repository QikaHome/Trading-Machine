
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package tk.qikahome.tradingmachine.init;

import tk.qikahome.tradingmachine.block.entity.StoneTradingMachineBlockEntity;
import tk.qikahome.tradingmachine.block.entity.CreativeTradingMachineBlockEntity;
import tk.qikahome.tradingmachine.TradingMachineMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

public class TradingMachineModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TradingMachineMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> CREATIVE_TRADING_MACHINE = register("creative_trading_machine", TradingMachineModBlocks.CREATIVE_TRADING_MACHINE, CreativeTradingMachineBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> STONE_TRADING_MACHINE = register("stone_trading_machine", TradingMachineModBlocks.STONE_TRADING_MACHINE, StoneTradingMachineBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
