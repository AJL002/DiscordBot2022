package com.example.discord_bot_2022.listeners.impl;

import com.example.discord_bot_2022.listeners.BlackjackListener;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

import java.util.Hashtable;

@Component
public class BlackjackListenerImpl implements BlackjackListener {
    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if (messageCreateEvent.getMessageContent().toLowerCase().startsWith("!blackjack") || messageCreateEvent.getMessageContent().toLowerCase().startsWith("!bj")) {

            messageCreateEvent.addReactionsToMessage("<450849768600502283>");


        }

        Hashtable<String, Integer> deck = new Hashtable<>();
        {   //DECK HASHTABLE
            deck.put("OneHearts", 1);


        }

    }
}
