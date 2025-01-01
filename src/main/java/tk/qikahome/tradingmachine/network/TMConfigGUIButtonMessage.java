
package tk.qikahome.tradingmachine.network;

import tk.qikahome.tradingmachine.world.inventory.TMConfigGUIMenu;
import tk.qikahome.tradingmachine.procedures.TMDestoryProcedure;
import tk.qikahome.tradingmachine.procedures.SaveTMConfigProcedure;
import tk.qikahome.tradingmachine.procedures.OutputRemoveAllProcedure;
import tk.qikahome.tradingmachine.procedures.OutputRemove64Procedure;
import tk.qikahome.tradingmachine.procedures.OutputRemove1Procedure;
import tk.qikahome.tradingmachine.procedures.InputRemoveAllProcedure;
import tk.qikahome.tradingmachine.procedures.InputRemove64Procedure;
import tk.qikahome.tradingmachine.procedures.InputRemove1Procedure;
import tk.qikahome.tradingmachine.TradingMachineMod;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TMConfigGUIButtonMessage {
	private final int buttonID, x, y, z;

	public TMConfigGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public TMConfigGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(TMConfigGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(TMConfigGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = TMConfigGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			TMDestoryProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			SaveTMConfigProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 2) {

			OutputRemove64Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			OutputRemoveAllProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			OutputRemove1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			InputRemove1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			InputRemove64Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			InputRemoveAllProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TradingMachineMod.addNetworkMessage(TMConfigGUIButtonMessage.class, TMConfigGUIButtonMessage::buffer, TMConfigGUIButtonMessage::new, TMConfigGUIButtonMessage::handler);
	}
}
