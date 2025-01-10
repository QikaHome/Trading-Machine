package tk.qikahome.tradingmachine.procedures;

import tk.qikahome.tradingmachine.init.TradingMachineModGameRules;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class CheckAndDestoryProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		String name = "";
		if (world.getLevelData().getGameRules().getBoolean(TradingMachineModGameRules.TM_CHECK_BAD_BLOCK_BLACK_LIST_MODE)) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("trading_machine:black_list")))) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
		} else {
			name = ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString();
			if (!(name.startsWith("minecraft:") || name.startsWith("trading_machine:"))) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
		}
	}
}
