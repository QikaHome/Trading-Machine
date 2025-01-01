package tk.qikahome.tradingmachine.procedures;

import tk.qikahome.tradingmachine.TradingMachineMod;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class SetTradingItemProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack, double slot) {
		TradingMachineMod.LOGGER.info(x + " " + y + " " + z + " " + slot + " " + itemstack.getCount());
		{
			BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
			if (_ent != null) {
				final int _slotid = (int) slot;
				final ItemStack _setstack = itemstack.copy();
				_setstack.setCount(itemstack.getCount());
				_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable)
						((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
				});
			}
		}
		return true;
	}
}
