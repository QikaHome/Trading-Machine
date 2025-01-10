
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package tk.qikahome.tradingmachine.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TradingMachineModGameRules {
	public static final GameRules.Key<GameRules.IntegerValue> TRADING_MACHINE_INVENTORY_SIZE = GameRules.register("tradingMachineInventorySize", GameRules.Category.UPDATES, GameRules.IntegerValue.create(12));
	public static final GameRules.Key<GameRules.BooleanValue> TM_CHECK_BAD_BLOCK_BLACK_LIST_MODE = GameRules.register("tmCheckBadBlockBlackListMode", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
}
