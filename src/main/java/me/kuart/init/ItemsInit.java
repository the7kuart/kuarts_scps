package me.kuart.init;

import me.kuart.KuartsSCPs;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemsInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, KuartsSCPs.MOD_ID);

    public static final RegistryObject<Item> HUMAN_SPAWN_EGG = ITEMS.register("human_spawn_egg",()-> new ForgeSpawnEggItem(EntityInit.HUMAN,0x00AFAF, 0xBD8B72,new Item.Properties().tab(KuartsSCPs.SCP_TAB)));
    public static final RegistryObject<Item> SCP173_SPAWN_EGG = ITEMS.register("scp173_spawn_egg",()-> new ForgeSpawnEggItem(EntityInit.SCP173,0xE7E7E7, 0xE8EDF1,new Item.Properties().tab(KuartsSCPs.SCP_TAB)));
    public static final RegistryObject<Item> SCP939_SPAWN_EGG = ITEMS.register("scp939_spawn_egg",()-> new ForgeSpawnEggItem(EntityInit.SCP939,0xE7E7E7, 0xE8EDF1,new Item.Properties().tab(KuartsSCPs.SCP_TAB)));



}
