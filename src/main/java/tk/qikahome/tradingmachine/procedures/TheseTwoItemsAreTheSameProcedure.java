package tk.qikahome.tradingmachine.procedures;

import net.minecraft.world.item.ItemStack;

public class TheseTwoItemsAreTheSameProcedure {
	public static boolean execute(ItemStack stacka, ItemStack stackb) {
		return ItemStack.isSameItemSameTags(stacka, stackb);
	}
}
