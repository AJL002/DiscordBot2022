package com.example.discord_bot_2022.listeners.impl;

import com.example.discord_bot_2022.listeners.BlackjackListener;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

import java.util.Hashtable;

@Component
public class BlackjackListenerImpl implements BlackjackListener {
    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if (messageCreateEvent.getMessageContent().toLowerCase().contains("!blackjack") || messageCreateEvent.getMessageContent().toLowerCase().contains("!bj")) {

            messageCreateEvent.addReactionsToMessage("<:FatAlbertThinking:450849768600502283>");


        }

        Hashtable<String, Integer> deck = new Hashtable<>();
        {   //DECK HASHTABLE
            deck.put("OneHearts", 1);


        }

    }
}
