package tk.qikahome.tradingmachine.procedures;

import net.minecraft.network.chat.Component;

public class StringNotRegisteredProcedure {
	public static String execute() {
		return Component.translatable("tooltip.trading_machine.not_registed").getString();
	}
}
