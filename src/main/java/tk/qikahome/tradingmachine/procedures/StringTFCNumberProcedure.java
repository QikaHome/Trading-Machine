package tk.qikahome.tradingmachine.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class StringTFCNumberProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return Component.translatable("gui.trading_machine.tfc_number").getString() + "" + Math.round(GetTFCNumberProcedure.execute(entity) + 1);
	}
}
