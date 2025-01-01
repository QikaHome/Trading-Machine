
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package tk.qikahome.tradingmachine.init;

import tk.qikahome.tradingmachine.entity.TFCCoinEntityEntity;
import tk.qikahome.tradingmachine.TradingMachineMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TradingMachineModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TradingMachineMod.MODID);
	public static final RegistryObject<EntityType<TFCCoinEntityEntity>> TFC_COIN_ENTITY = register("tfc_coin_entity",
			EntityType.Builder.<TFCCoinEntityEntity>of(TFCCoinEntityEntity::new, MobCategory.MISC).setCustomClientFactory(TFCCoinEntityEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}
}
