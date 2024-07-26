package github.pungu.init;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import github.pungu.SmilingCritters;

public class initialize {
    public static final Item SKIBIDI_WAND = register("skibidi_wand", new fireWand(new Item.Settings().maxCount(1)));
    public static final Item WIND_WAND = register("wind_wand", new windWand(new Item.Settings().maxCount(1)));
    public static final Item BARON_BUNNY = register("baron_bunny", new baronBunny(new Item.Settings().maxCount(16)));


    public static <T extends Item> T register(String name, T item){
        return Registry.register(Registries.ITEM, SmilingCritters.id(name), item);


    }


    public static void init(){

    }
}
