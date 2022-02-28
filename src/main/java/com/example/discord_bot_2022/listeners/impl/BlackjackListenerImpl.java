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
            deck.put(":keycap_ten::heart:", "10");
            deck.put("<:JackOhReally:895893197224546304>:heart:", "10");
            deck.put(":woman::heart:", "10");
            deck.put(":crown::heart:", "10");
            //SQUARES AKA CLUBS
            deck.put(":a::orange_square:", "1");
            deck.put(":two::orange_square:", "2");
            deck.put(":three::orange_square:", "3");
            deck.put(":four::orange_square:", "4");
            deck.put(":five::orange_square:", "5");
            deck.put(":six::orange_square:", "6");
            deck.put(":seven::orange_square:", "7");
            deck.put(":eight::orange_square:", "8");
            deck.put(":nine::orange_square:", "9");
            deck.put(":keycap_ten::orange_square:", "10");
            deck.put("<:JackOhReally:895893197224546304>:orange_square:", "10");
            deck.put(":woman::orange_square:", "10");
            deck.put(":crown::orange_square:", "10");
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
            deck.put(":keycap_ten::diamonds:", "10");
            deck.put("<:JackOhReally:895893197224546304>:diamonds:", "10");
            deck.put(":woman::diamonds:", "10");
            deck.put(":crown::diamonds:", "10");
            //CIRCLES AKA SPADES
            deck.put(":a::orange_circle:", "1");
            deck.put(":two::orange_circle:", "2");
            deck.put(":three::orange_circle:", "3");
            deck.put(":four::orange_circle:", "4");
            deck.put(":five::orange_circle:", "5");
            deck.put(":six::orange_circle:", "6");
            deck.put(":seven::orange_circle:", "7");
            deck.put(":eight::orange_circle:", "8");
            deck.put(":nine::orange_circle:", "9");
            deck.put(":keycap_ten::orange_circle:", "10");
            deck.put("<:JackOhReally:895893197224546304>:orange_circle:", "10");
            deck.put(":woman::orange_circle:", "10");
            deck.put(":crown::orange_circle:", "10");
        }

        if (messageCreateEvent.getMessageContent().toLowerCase().contains("!blackjack") || messageCreateEvent.getMessageContent().toLowerCase().contains("!bj")) {
            Random rand = new Random();
            String[] val = {":a:", ":two:", ":three:",":four:", ":five:", ":six:", ":seven:", ":eight:", ":nine:", ":ten:", "<:JackOhReally:895893197224546304>", ":woman:", ":crown:"};
            String[] face = {":heart:", ":orange_square:", ":diamonds:", ":orange_circle:"};
            int x = rand.nextInt(val.length);
            int y = rand.nextInt(face.length);
            String card = val[x]+face[y];

            messageCreateEvent.getChannel().sendMessage(card);
            messageCreateEvent.getChannel().sendMessage(deck.get(card));
        }



    }

}
