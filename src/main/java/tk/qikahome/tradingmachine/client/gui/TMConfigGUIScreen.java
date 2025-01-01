package tk.qikahome.tradingmachine.client.gui;

import tk.qikahome.tradingmachine.world.inventory.TMConfigGUIMenu;
import tk.qikahome.tradingmachine.procedures.UnTradableProcedure;
import tk.qikahome.tradingmachine.procedures.GetOutputCountStringProcedure;
import tk.qikahome.tradingmachine.procedures.GetInputCountStringProcedure;
import tk.qikahome.tradingmachine.network.TMConfigGUIButtonMessage;
import tk.qikahome.tradingmachine.TradingMachineMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class TMConfigGUIScreen extends AbstractContainerScreen<TMConfigGUIMenu> {
	private final static HashMap<String, Object> guistate = TMConfigGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox Name;
	Checkbox UnTradable;
	Button button_destory;
	Button button_savenconfig;
	Button button_out64;
	Button button_outall;
	Button button_out1;
	Button button_in1;
	Button button_in64;
	Button button_inall;

	public TMConfigGUIScreen(TMConfigGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 178;
		this.imageHeight = 206;
	}

	private static final ResourceLocation texture = new ResourceLocation("trading_machine:textures/screens/tm_config_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		Name.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (Name.isFocused())
			return Name.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		Name.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String NameValue = Name.getValue();
		super.resize(minecraft, width, height);
		Name.setValue(NameValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.trading_machine.tm_config_gui.label_input"), 6, 62, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.trading_machine.tm_config_gui.label_output"), 6, 82, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.trading_machine.tm_config_gui.label_remove_from"), 99, 45, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.trading_machine.tm_config_gui.label_set"), 63, 45, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.trading_machine.tm_config_gui.label_put"), 81, 45, -12829636, false);
		guiGraphics.drawString(this.font,

				GetInputCountStringProcedure.execute(world, x, y, z), 40, 62, -12829636, false);
		guiGraphics.drawString(this.font,

				GetOutputCountStringProcedure.execute(world, x, y, z), 40, 82, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.trading_machine.tm_config_gui.label_count"), 36, 45, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		Name = new EditBox(this.font, this.leftPos + 5, this.topPos + 4, 168, 18, Component.translatable("gui.trading_machine.tm_config_gui.Name"));
		Name.setMaxLength(32767);
		guistate.put("text:Name", Name);
		this.addWidget(this.Name);
		button_destory = Button.builder(Component.translatable("gui.trading_machine.tm_config_gui.button_destory"), e -> {
			if (true) {
				TradingMachineMod.PACKET_HANDLER.sendToServer(new TMConfigGUIButtonMessage(0, x, y, z));
				TMConfigGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 8, this.topPos + 100, 79, 20).build();
		guistate.put("button:button_destory", button_destory);
		this.addRenderableWidget(button_destory);
		button_savenconfig = Button.builder(Component.translatable("gui.trading_machine.tm_config_gui.button_savenconfig"), e -> {
			if (true) {
				TradingMachineMod.PACKET_HANDLER.sendToServer(new TMConfigGUIButtonMessage(1, x, y, z));
				TMConfigGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 91, this.topPos + 100, 79, 20).build();
		guistate.put("button:button_savenconfig", button_savenconfig);
		this.addRenderableWidget(button_savenconfig);
		button_out64 = Button.builder(Component.translatable("gui.trading_machine.tm_config_gui.button_out64"), e -> {
			if (true) {
				TradingMachineMod.PACKET_HANDLER.sendToServer(new TMConfigGUIButtonMessage(2, x, y, z));
				TMConfigGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 110, this.topPos + 78, 19, 20).build();
		guistate.put("button:button_out64", button_out64);
		this.addRenderableWidget(button_out64);
		button_outall = Button.builder(Component.translatable("gui.trading_machine.tm_config_gui.button_outall"), e -> {
			if (true) {
				TradingMachineMod.PACKET_HANDLER.sendToServer(new TMConfigGUIButtonMessage(3, x, y, z));
				TMConfigGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 129, this.topPos + 78, 40, 20).build();
		guistate.put("button:button_outall", button_outall);
		this.addRenderableWidget(button_outall);
		button_out1 = Button.builder(Component.translatable("gui.trading_machine.tm_config_gui.button_out1"), e -> {
			if (true) {
				TradingMachineMod.PACKET_HANDLER.sendToServer(new TMConfigGUIButtonMessage(4, x, y, z));
				TMConfigGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 99, this.topPos + 78, 11, 20).build();
		guistate.put("button:button_out1", button_out1);
		this.addRenderableWidget(button_out1);
		button_in1 = Button.builder(Component.translatable("gui.trading_machine.tm_config_gui.button_in1"), e -> {
			if (true) {
				TradingMachineMod.PACKET_HANDLER.sendToServer(new TMConfigGUIButtonMessage(5, x, y, z));
				TMConfigGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 99, this.topPos + 58, 11, 20).build();
		guistate.put("button:button_in1", button_in1);
		this.addRenderableWidget(button_in1);
		button_in64 = Button.builder(Component.translatable("gui.trading_machine.tm_config_gui.button_in64"), e -> {
			if (true) {
				TradingMachineMod.PACKET_HANDLER.sendToServer(new TMConfigGUIButtonMessage(6, x, y, z));
				TMConfigGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 110, this.topPos + 58, 19, 20).build();
		guistate.put("button:button_in64", button_in64);
		this.addRenderableWidget(button_in64);
		button_inall = Button.builder(Component.translatable("gui.trading_machine.tm_config_gui.button_inall"), e -> {
			if (true) {
				TradingMachineMod.PACKET_HANDLER.sendToServer(new TMConfigGUIButtonMessage(7, x, y, z));
				TMConfigGUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 129, this.topPos + 58, 40, 20).build();
		guistate.put("button:button_inall", button_inall);
		this.addRenderableWidget(button_inall);
		UnTradable = new Checkbox(this.leftPos + 5, this.topPos + 22, 20, 20, Component.translatable("gui.trading_machine.tm_config_gui.UnTradable"),

				UnTradableProcedure.execute(world, x, y, z));
		guistate.put("checkbox:UnTradable", UnTradable);
		this.addRenderableWidget(UnTradable);
	}
}
