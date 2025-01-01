package tk.qikahome.tradingmachine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

public class SetTMNameBlankProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, HashMap guistate) {
		if (guistate == null)
			return;
		if (guistate.get("text:Name") instanceof EditBox _tf)
			_tf.setValue(GetTMNameProcedure.execute(world, x, y, z));
	}
}
