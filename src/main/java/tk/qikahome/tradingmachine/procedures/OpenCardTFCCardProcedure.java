package tk.qikahome.tradingmachine.procedures;

import tk.qikahome.tradingmachine.init.TradingMachineModItems;
import tk.qikahome.tradingmachine.TradingMachineMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

public class OpenCardTFCCardProcedure {
	public static void execute(LevelAccessor world, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		double TFCs = 0;
		ItemStack NEWCARD = ItemStack.EMPTY;
		TFCs = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("TFCs");
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(TradingMachineModItems.TFC_CARD_NOT_REGISTERED.get());
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
		if (entity instanceof LivingEntity _entity) {
			ItemStack _setstack = new ItemStack(TradingMachineModItems.TFC_CARD.get()).copy();
			_setstack.setCount(1);
			_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
			if (_entity instanceof Player _player)
				_player.getInventory().setChanged();
		}
		(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).setDamageValue((int) (65535 - TFCs));
		TradingMachineMod.LOGGER.info(guistate.containsKey("text:CardID") ? ((EditBox) guistate.get("text:CardID")).getValue() : "");
		(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("ID", (guistate.containsKey("text:CardID") ? ((EditBox) guistate.get("text:CardID")).getValue() : ""));
		TradingMachineMod.queueServerWork(1, () -> {
			if (entity instanceof Player _player)
				_player.closeContainer();
		});
	}
}
