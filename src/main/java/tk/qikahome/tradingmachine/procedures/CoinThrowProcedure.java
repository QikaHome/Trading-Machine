package tk.qikahome.tradingmachine.procedures;

import net.minecraft.world.item.ItemStack;

public class CoinThrowProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.shrink(1);
	}
}
