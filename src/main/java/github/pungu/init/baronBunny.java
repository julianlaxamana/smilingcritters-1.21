package github.pungu.init;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class baronBunny extends Item{
   public baronBunny(Settings settings){
    super(settings);
   } 
@Override
public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
	if (world.isClient) {
		return TypedActionResult.pass(user.getStackInHand(hand));
	}

	
	BlockPos frontOfPlayer = user.getBlockPos().offset(user.getHorizontalFacing(), 0);

	IronGolemEntity golem = new IronGolemEntity(EntityType.IRON_GOLEM, world);
	TntEntity tnt = new TntEntity(EntityType.TNT, world);
	golem.setAiDisabled(true);
	golem.setPosition(frontOfPlayer.toCenterPos());
	golem.setHealth(10.0f);
	golem.setOnGround(true);
	tnt.setOnGround(true);
	tnt.setNoGravity(true);
	tnt.setPosition(frontOfPlayer.toCenterPos());
	tnt.isInvisibleTo(user);
	golem.isInvisibleTo(user);
	world.spawnEntity(golem);
	world.spawnEntity(tnt);

	user.getStackInHand(hand).decrement(1);
	// Nothing has changed to the item stack,
	// so we just return it how it was.
	return TypedActionResult.success(user.getStackInHand(hand));
}
}
