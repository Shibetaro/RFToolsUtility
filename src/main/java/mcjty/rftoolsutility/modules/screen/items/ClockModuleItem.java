package mcjty.rftoolsutility.modules.screen.items;

import mcjty.rftoolsbase.api.screens.IModuleGuiBuilder;
import mcjty.rftoolsbase.tools.GenericModuleItem;
import mcjty.rftoolsutility.RFToolsUtility;
import mcjty.rftoolsutility.modules.screen.ScreenConfiguration;
import mcjty.rftoolsutility.modules.screen.modules.ClockScreenModule;
import mcjty.rftoolsutility.modules.screen.modulesclient.ClockClientScreenModule;
import net.minecraft.item.ItemStack;

public class ClockModuleItem extends GenericModuleItem {

    public ClockModuleItem() {
        super(new Properties()
                .maxStackSize(16)
                .defaultMaxDamage(1)
                .group(RFToolsUtility.setup.getTab()));
    }

    @Override
    protected int getUses(ItemStack stack) {
        return ScreenConfiguration.CLOCK_RFPERTICK.get();
    }

//    @Override
//    public int getMaxItemUseDuration(ItemStack stack) {
//        return 1;
//    }

    @Override
    public Class<ClockScreenModule> getServerScreenModule() {
        return ClockScreenModule.class;
    }

    @Override
    public Class<ClockClientScreenModule> getClientScreenModule() {
        return ClockClientScreenModule.class;
    }

    @Override
    public String getModuleName() {
        return "Clock";
    }

    @Override
    public void createGui(IModuleGuiBuilder guiBuilder) {
        guiBuilder.
                label("Label:").text("text", "Label text").color("color", "Label color").nl().
                toggle("large", "Large", "Large or small font").nl();
    }
}