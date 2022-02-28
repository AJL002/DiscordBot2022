package com.example.discord_bot_2022.listeners.impl;

import com.example.discord_bot_2022.listeners.BlackjackListener;
import org.javacord.api.entity.emoji.Emoji;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

import java.util.Hashtable;
import java.util.Random;

@Component
public class BlackjackListenerImpl implements BlackjackListener {
    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        Hashtable<String, String> deck = new Hashtable<>();
        {   //DECK HASHTABLE
            //HEARTS
            deck.put(":a::heart:", "1");
            deck.put(":two::heart:", "2");
            deck.put(":three::heart:", "3");
            deck.put(":four::heart:", "4");
            deck.put(":five::heart:", "5");
            deck.put(":six::heart:", "6");
            deck.put(":seven::heart:", "7");
            deck.put(":eight::heart:", "8");
            deck.put(":nine::heart:", "9");
            deck.put(":ten::heart:", "10");
            deck.put("JackOhReally:895893197224546304:heart:", "10");
            deck.put(":woman::heart:", "10");
            deck.put(":crown::heart:", "10");
            //CLUBS
            deck.put(":a::clubs:", "1");
            deck.put(":two::clubs:", "2");
            deck.put(":three::clubs:", "3");
            deck.put(":four::clubs:", "4");
            deck.put(":five::clubs:", "5");
            deck.put(":six::clubs:", "6");
            deck.put(":seven::clubs:", "7");
            deck.put(":eight::clubs:", "8");
            deck.put(":nine::clubs:", "9");
            deck.put(":ten::clubs:", "10");
            deck.put("JackOhReally:895893197224546304:clubs:", "10");
            deck.put(":woman::clubs:", "10");
            deck.put(":crown::clubs:", "10");
            //DIAMONDS
            deck.put(":a::diamonds:", "1");
            deck.put(":two::diamonds:", "2");
            deck.put(":three::diamonds:", "3");
            deck.put(":four::diamonds:", "4");
            deck.put(":five::diamonds:", "5");
            deck.put(":six::diamonds:", "6");
            deck.put(":seven::diamonds:", "7");
            deck.put(":eight::diamonds:", "8");
            deck.put(":nine::diamonds:", "9");
            deck.put(":ten::diamonds:", "10");
            deck.put("JackOhReally:895893197224546304:diamonds:", "10");
            deck.put(":woman::diamonds:", "10");
            deck.put(":crown::diamonds:", "10");
            //SPADES
            deck.put(":a::spades:", "1");
            deck.put(":two::spades:", "2");
            deck.put(":three::spades:", "3");
            deck.put(":four::spades:", "4");
            deck.put(":five::spades:", "5");
            deck.put(":six::spades:", "6");
            deck.put(":seven::spades:", "7");
            deck.put(":eight::spades:", "8");
            deck.put(":nine::spades:", "9");
            deck.put(":ten::spades:", "10");
            deck.put("JackOhReally:895893197224546304:spades:", "10");
            deck.put(":woman::spades:", "10");
            deck.put(":crown::spades:", "10");
        }

        if (messageCreateEvent.getMessageContent().toLowerCase().contains("!blackjack") || messageCreateEvent.getMessageContent().toLowerCase().contains("!bj")) {
            Random rand = new Random();
            String[] val = {":a:", ":two:", ":three:",":four:", ":five:", ":six:", ":seven:", ":eight:", ":nine:", ":ten:", "JackOhReally:895893197224546304", ":woman:", ":crown:"};
            String[] face = {":heart:", ":clubs:", ":diamonds:", ":spades:"};
            int x = rand.nextInt(val.length);
            int y = rand.nextInt(face.length);
            String card = val[x]+face[y];

            messageCreateEvent.getChannel().sendMessage(card);
            messageCreateEvent.getChannel().sendMessage(deck.get(card));
        }



    }

}
