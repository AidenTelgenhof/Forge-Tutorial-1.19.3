package net.aiden.tutorialmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EightBallItem extends Item {
    public EightBallItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            outputRandomMessage(player);
            player.getCooldowns().addCooldown(this, 20);
        }

        return super.use(level, player, hand);
    }

    private void outputRandomMessage(Player player) {
        player.sendSystemMessage(Component.literal(getRandomMessage()));
    }

    private String getRandomMessage() {
        ArrayList<String> phrases = new ArrayList<String>(
         Arrays.asList("It is certain.", "it is decidedly so.", "Without a doubt.", "Yes definitely.", "You may rely on it", "As I see it, yes.", "Most likely.", "Outlook good.", "Yes.", "Signs point to yes.","Reply hazy, try again.", "Ask again later.", "Better not tell you now.", "Cannot predict now.", "Concentrate and ask again.", "Don't count on it.", "My reply is no.", "My sources say no.", "Outlook not so good.", "Very doubtful."));
        int index = (int)(Math.random() * 20);
        return phrases.get(index);
    }
}
