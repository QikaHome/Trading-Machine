package tk.qikahome.tradingmachine.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class CardThrowProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		itemstack.setDamageValue((int) (itemstack.getDamageValue() + 1));
		if (itemstack.getMaxDamage() == itemstack.getDamageValue()) {
			itemstack.setCount(0);
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Items.PAPER).copy();
				_setstack.setCount(2);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}
