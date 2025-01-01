package tk.qikahome.tradingmachine.client.gui;

import tk.qikahome.tradingmachine.world.inventory.TFCCardRegisterMenu;
import tk.qikahome.tradingmachine.procedures.StringTFCNumberProcedure;
import tk.qikahome.tradingmachine.network.TFCCardRegisterButtonMessage;
import tk.qikahome.tradingmachine.TradingMachineMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class TFCCardRegisterScreen extends AbstractContainerScreen<TFCCardRegisterMenu> {
	private final static HashMap<String, Object> guistate = TFCCardRegisterMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox CardID;
	Button button_cancel;
	Button button_accept;

	public TFCCardRegisterScreen(TFCCardRegisterMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 175;
		this.imageHeight = 90;
	}

	private static final ResourceLocation texture = new ResourceLocation("trading_machine:textures/screens/tfc_card_register.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		CardID.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (CardID.isFocused())
			return CardID.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		CardID.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String CardIDValue = CardID.getValue();
		super.resize(minecraft, width, height);
		CardID.setValue(CardIDValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.trading_machine.tfc_card_register.label_please_enter_your_card_id"), 8, 6, -12829636, false);
		guiGraphics.drawString(this.font,

				StringTFCNumberProcedure.execute(entity), 8, 43, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		CardID = new EditBox(this.font, this.leftPos + 8, this.topPos + 20, 157, 18, Component.translatable("gui.trading_machine.tfc_card_register.CardID"));
		CardID.setMaxLength(32767);
		guistate.put("text:CardID", CardID);
		this.addWidget(this.CardID);
		button_cancel = Button.builder(Component.translatable("gui.trading_machine.tfc_card_register.button_cancel"), e -> {
			if (true) {
				TradingMachineMod.PACKET_HANDLER.sendToServer(new TFCCardRegisterButtonMessage(0, x, y, z));
				TFCCardRegisterButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 7, this.topPos + 60, 56, 20).build();
		guistate.put("button:button_cancel", button_cancel);
		this.addRenderableWidget(button_cancel);
		button_accept = Button.builder(Component.translatable("gui.trading_machine.tfc_card_register.button_accept"), e -> {
			if (true) {
				TradingMachineMod.PACKET_HANDLER.sendToServer(new TFCCardRegisterButtonMessage(1, x, y, z));
				TFCCardRegisterButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 110, this.topPos + 60, 56, 20).build();
		guistate.put("button:button_accept", button_accept);
		this.addRenderableWidget(button_accept);
	}
}
