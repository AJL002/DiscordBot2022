package com.example.discord_bot_2022.listeners.impl;

import com.example.discord_bot_2022.listeners.BlackjackListener;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.emoji.Emoji;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.component.ActionRow;
import org.javacord.api.entity.message.component.Button;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Component
public class BlackjackListenerImpl implements BlackjackListener {
    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        Hashtable<String, String> deck = new Hashtable<>();
        {   //DECK HASHTABLE
            //HEARTS
            deck.put(":a:", "1");
            deck.put(":two:", "2");
            deck.put(":three:", "3");
            deck.put(":four:", "4");
            deck.put(":five:", "5");
            deck.put(":six:", "6");
            deck.put(":seven:", "7");
            deck.put(":eight:", "8");
            deck.put(":nine:", "9");
            deck.put(":keycap_ten:", "10");
            deck.put("<:JackOhReally:895893197224546304>", "10");
            deck.put(":woman:", "10");
            deck.put(":crown:", "10");
        }

        if (messageCreateEvent.getMessageContent().toLowerCase().contains("!blackjack") || messageCreateEvent.getMessageContent().toLowerCase().contains("!bj")) {
            Random rand = new Random();
            String[] val = {":a:", ":two:", ":three:",":four:", ":five:", ":six:", ":seven:", ":eight:", ":nine:", ":ten:", "<:JackOhReally:895893197224546304>", ":woman:", ":crown:"};
            String card = val[rand.nextInt(val.length)];
            String user = messageCreateEvent.getMessageAuthor().getDisplayName();
            EmbedBuilder embed = new EmbedBuilder()
                    .setTitle("Blackjack w/ Ben")
                    .setDescription("Can you beat Ben?")
                    .setAuthor("Ben", "https://outfit7talkingfriends.fandom.com/wiki/Ben", "https://media.discordapp.net/attachments/938298237142564904/948021991418499082/talking_ben.jpg")
                    .addInlineField("Ben", "")
                    .addInlineField(user, "")
                    .setColor(Color.green);
            messageCreateEvent.getChannel().sendMessage(embed);




//            messageCreateEvent.getChannel().sendMessage("Welcome to Blackjack!");
            messageCreateEvent.getChannel().sendMessage(deck.get(card));




            //Component interaction demo
//            TextChannel channel = messageCreateEvent.getChannel();
//            new MessageBuilder()
//                    .setContent("Choose an option")
//                    .addComponents(
//                            ActionRow.of(Button.success("success", "Hit"),
//                                    Button.danger("danger", "Stay")
//                                    ))
//                    .send(channel);
        }
    }
}
