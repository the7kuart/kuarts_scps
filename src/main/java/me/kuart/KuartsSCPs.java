package me.kuart;

import com.mojang.logging.LogUtils;
import me.kuart.init.BlockInit;
import me.kuart.init.EntityInit;
import me.kuart.init.ItemsInit;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(KuartsSCPs.MOD_ID)
public class KuartsSCPs
{

    public static final String MOD_ID = "krtscp";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final CreativeModeTab SCP_TAB = new CreativeModeTab("krtscptab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemsInit.HUMAN_SPAWN_EGG.get());
        }
    };

    public KuartsSCPs()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        EntityInit.ENTITIES.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        ItemsInit.ITEMS.register(modEventBus);


    }





}
