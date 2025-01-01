package tk.qikahome.tradingmachine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class InputRemove64Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		InputRemoveNProcedure.execute(world, x, y, z, entity, 64);
	}
}
