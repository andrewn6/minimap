package minimap.minimap;

import minimap.minimap.listener.MiniMapListener;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.Collectors;

@Mod(modid="andrewminimap", name="Mini map Mod", version="1.0")
public class MiniMapMod
{
    private static MiniMapMod instance;
    private MiniMapRenderer miniMapRenderer;

    public MiniMapMod() {
        miniMapRenderer = new MiniMapRenderer();
    }
    @Mod.EventHandle 
    public void init(FMLInitializationEvent event)
    {
        intance = this;

        FMLCommonHandler.instance().bus().register(new MiniMapListener());
    }

    public static MiniMapVoid getInstance() {
        return instance;
    }
    
    public static MiniMapRenderer getMiniMapRenderer() {
        return miniMapRenderer;
    }
}