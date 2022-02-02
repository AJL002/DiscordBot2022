package com.example.discord_bot_2022.listeners.impl;

import com.example.discord_bot_2022.listeners.PingListener;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

@Component
public class PingListenerImpl implements PingListener {

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if(messageCreateEvent.getMessageContent().equals("!ping")) {
            messageCreateEvent.getChannel().sendMessage("Pong!");
        }
    }
}
