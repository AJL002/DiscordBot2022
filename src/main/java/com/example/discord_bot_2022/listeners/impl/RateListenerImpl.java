package com.example.discord_bot_2022.listeners.impl;

import com.example.discord_bot_2022.listeners.RateListener;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RateListenerImpl implements RateListener {
    private final static Pattern pattern = Pattern.compile("!rate (\\w+)");

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if(messageCreateEvent.getMessageContent().startsWith("!rate")) {
            Matcher matcher = pattern.matcher(messageCreateEvent.getMessageContent());
            if(matcher.matches()) {
                //Do the rating
                int rating = (int) Math.floor(Math.random() * 100) + 1;
                messageCreateEvent.getChannel()
                        .sendMessage(messageCreateEvent.getMessageAuthor().getDisplayName() + " is " + rating + "% " + matcher.group(1));
            }
            else {
                //Send helpful message
                messageCreateEvent.getChannel().sendMessage("Please use: '!rate [word]'");
            }
        }
    }
}
