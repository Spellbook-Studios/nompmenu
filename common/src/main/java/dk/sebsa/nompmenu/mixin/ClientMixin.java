package dk.sebsa.nompmenu.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.screens.multiplayer.JoinMultiplayerScreen;
import net.minecraft.client.gui.screens.multiplayer.SafetyScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Minecraft.class)
public class ClientMixin {
    @ModifyVariable(at = @At("HEAD"), method = "setScreen", argsOnly = true)
    private Screen hideMPMenu(Screen variable) {
        if(variable instanceof JoinMultiplayerScreen || variable instanceof SafetyScreen) return new TitleScreen();
        return variable;
    }
}
