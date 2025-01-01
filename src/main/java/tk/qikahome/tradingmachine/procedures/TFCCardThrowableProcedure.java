package tk.qikahome.tradingmachine.procedures;

import net.minecraft.world.item.ItemStack;

public class TFCCardThrowableProcedure {
	public static boolean execute(ItemStack itemstack) {
		return itemstack.getDamageValue() < itemstack.getMaxDamage();
	}
}
