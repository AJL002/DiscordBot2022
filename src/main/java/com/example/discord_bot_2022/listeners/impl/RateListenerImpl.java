package com.example.discord_bot_2022.listeners.impl;

import com.example.discord_bot_2022.listeners.RateListener;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RateListenerImpl implements RateListener {
    private final static Pattern pattern = Pattern.compile("!rate (\\w*)(\\p{Blank}*?)");

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if(messageCreateEvent.getMessageContent().toLowerCase().contains("!rate")) {
            Matcher matcher = pattern.matcher(messageCreateEvent.getMessageContent());
            System.out.println(matcher.matches());
            System.out.println(messageCreateEvent.getMessageContent());
            int number = 5;
            if(number == 5) {
                //Do the rating
                int rating = (int) Math.floor(Math.random() * 100) + 1;
                String temp = messageCreateEvent.getMessageContent().toLowerCase().replace("!rate", "").replace("[", "").replace("]", "");

                messageCreateEvent.getChannel()

                        .sendMessage(messageCreateEvent.getMessageAuthor().getDisplayName() + " is " + rating + "%" + temp);
            }
            else {
                //Send helpful message
                messageCreateEvent.getChannel().sendMessage("Please use: '!rate [word]'");
            }
        }
    }
}
