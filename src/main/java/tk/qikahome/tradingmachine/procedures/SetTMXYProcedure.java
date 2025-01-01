package tk.qikahome.tradingmachine.procedures;

import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

public class SetTMXYProcedure {
	public static void execute(double x, double y, HashMap guistate) {
		if (guistate == null)
			return;
		if (guistate.get("text:X") instanceof EditBox _tf)
			_tf.setValue(("" + x));
		if (guistate.get("text:Y") instanceof EditBox _tf)
			_tf.setValue(("" + y));
	}
}
