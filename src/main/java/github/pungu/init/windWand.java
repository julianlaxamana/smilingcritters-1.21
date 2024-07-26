package github.pungu.init;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.WindChargeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class windWand extends Item{
   public windWand(Settings settings){
    super(settings);
   } 
@Override
public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
	if (world.isClient) {
		return TypedActionResult.pass(user.getStackInHand(hand));
	}

	BlockPos frontOfPlayer = user.getBlockPos().offset(user.getHorizontalFacing(), 0);

	WindChargeEntity windball = new WindChargeEntity(EntityType.WIND_CHARGE, world);
    windball.setVelocity(user.getRotationVector());
	windball.setPosition(frontOfPlayer.toCenterPos());
	world.spawnEntity(windball);

	// Nothing has changed to the item stack,
	// so we just return it how it was.
	return TypedActionResult.success(user.getStackInHand(hand));
}
}
