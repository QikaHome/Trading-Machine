package tk.qikahome.tradingmachine.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

public class TFCCardToolTipProcedure {
	public static String execute(ItemStack itemstack) {
		return Component.translatable("tooltip.trading_machine.tfccard_id").getString() + "" + itemstack.getOrCreateTag().getString("ID");
	}
}
