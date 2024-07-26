package github.pungu.init;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class fireWand extends Item{
   public fireWand(Settings settings){
    super(settings);
   } 
@Override
public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
	if (world.isClient) {
		return TypedActionResult.pass(user.getStackInHand(hand));
	}

	BlockPos frontOfPlayer = user.getBlockPos().offset(user.getHorizontalFacing(), 0);

	FireballEntity fireball = new FireballEntity(EntityType.FIREBALL, world);
    fireball.setVelocity(user.getRotationVector());
	fireball.setPosition(frontOfPlayer.toCenterPos());
	world.spawnEntity(fireball);

	// Nothing has changed to the item stack,
	// so we just return it how it was.
	return TypedActionResult.success(user.getStackInHand(hand));
}
}
