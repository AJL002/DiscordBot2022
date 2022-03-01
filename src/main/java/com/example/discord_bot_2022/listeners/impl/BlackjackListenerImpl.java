package com.example.discord_bot_2022.listeners.impl;

import com.example.discord_bot_2022.listeners.BlackjackListener;
import com.example.discord_bot_2022.services.MessagingService;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Component
public class BlackjackListenerImpl implements BlackjackListener {
    private static boolean status = false;
    private static boolean loop = true;
    @Autowired
    private MessagingService messagingService;
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
            String[] val = {":a:", ":two:", ":three:",":four:", ":five:", ":six:", ":seven:", ":eight:", ":nine:", ":keycap_ten:", "<:JackOhReally:895893197224546304>", ":woman:", ":crown:"};
            String bencard = val[rand.nextInt(val.length)];
            String bencard2 = val[rand.nextInt(val.length)];
            String usercard = val[rand.nextInt(val.length)];
            String usercard2 = val[rand.nextInt(val.length)];

            if(!status){
                status = true;

                messagingService.sendMessage(messageCreateEvent.getMessageAuthor(),
                        "Simplified Blackjack",
                        "Can you beat Ben?",
                        "✅ = hit     \uD83D\uDED1 = stay",
                        "Ben",
                        bencard,
                        messageCreateEvent.getMessageAuthor().getDisplayName(),
                        usercard + usercard2 + "= " + (Integer.parseInt(deck.get(usercard)) + Integer.parseInt(deck.get(usercard2))),
                        "https://media.discordapp.net/attachments/938298237142564904/948021991418499082/talking_ben.jpg",
                        messageCreateEvent.getChannel()
                        )
                .thenAccept(message -> {
                    message.addReaction("✅");
//                    message.addReaction("\uD83D\uDED1");
//                    message.addReaction("\uD83D\uDC4E");
                    message.addReactionAddListener(
                        listener -> {
//                            listener.addReactionsToMessage("✅");
                            int goal = (Integer.parseInt(deck.get(usercard)) + Integer.parseInt(deck.get(usercard2)));
                            while(goal < 21){
                                int stop = 0;
                                System.out.println(listener.getEmoji().toString());
                                System.out.println(listener.removeAllReactionsFromMessage());
                                if(listener.getEmoji().equalsEmoji("✅") && loop == true)
                                {
                                    listener.removeReactionByEmojiFromMessage("UnicodeEmoji (emoji: ✅)");
                                    System.out.println("Hello");
                                    String card = val[rand.nextInt(val.length)];
                                    message.edit(new EmbedBuilder()
                                            .setTitle("Simplified Blackjack")
                                            .setDescription("Can you beat Ben?")
                                            .setFooter("✅ = hit     \uD83D\uDED1 = stay")
                                            .addInlineField("Ben", bencard)
                                            .addInlineField(messageCreateEvent.getMessageAuthor().getDisplayName(),usercard + usercard2 + card + "= " + (goal += Integer.parseInt(deck.get(card))))
                                            .setThumbnail("https://media.discordapp.net/attachments/938298237142564904/948021991418499082/talking_ben.jpg")
                                    );
                                    loop = false;
                                }
                                message.removeAllReactions();
                                message.removeReactionByEmoji("✅");
                                listener.removeAllReactionsFromMessage();
                                System.out.println("fart");

                                if(goal == 21)
                                {
                                    System.out.println("WINNER!");
                                    status = false;
                                    break;
                                }

                                if(goal > 21)
                                {
                                    System.out.println("LOSER!");
                                    status = false;
                                    break;
                                }



                                if(false){
                                    message.edit(new EmbedBuilder()
                                        .setTitle("Winner")
                                        .setDescription("You got **" + "21**!")
                                        .setFooter("Play again?"));
                                    status = false;
                                }
                            }
                    });
                });
            }














//            MessageAuthor user = messageCreateEvent.getMessageAuthor();
////            messageCreateEvent.getChannel().sendMessage(card);
////            messageCreateEvent.getChannel().sendMessage(deck.get(card));
//

//
//            EmbedBuilder embed = new EmbedBuilder()
//                    .setTitle("Blackjack w/ Ben")
//                    .setDescription("Can you beat Ben?")
//                    .setAuthor("Ben", "https://outfit7talkingfriends.fandom.com/wiki/Ben", "https://media.discordapp.net/attachments/938298237142564904/948021991418499082/talking_ben.jpg")
//                    .addInlineField("Ben", bencard)
//                    .addInlineField("You", usercard)
//                    .setColor(Color.green);
//
//            messageCreateEvent.getChannel().sendMessage(embed);



//            embed.addReactionAddListener();

//            messageCreateEvent.addReactionsToMessage("✅");
//            messageCreateEvent.addReactionsToMessage("\uD83D\uDED1");








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
