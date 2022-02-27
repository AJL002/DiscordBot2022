package com.example.discord_bot_2022.listeners.impl;

import com.example.discord_bot_2022.listeners.CircleListener;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CircleListenerImpl implements CircleListener {
    private final static Pattern pattern = Pattern.compile("!circle (\\d+(\\.\\d+)?)"); // Works with whole numbers and decimals (\\d+(\\.\\d+)?

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if(messageCreateEvent.getMessageContent().startsWith("!circle")){
            Matcher matcher = pattern.matcher(messageCreateEvent.getMessageContent());

            if(matcher.matches()){
                double radius = Double.parseDouble(matcher.group(1));
                double area = Math.PI * (Math.pow(radius, 2));
                messageCreateEvent.getChannel()
                        .sendMessage("The area of a circle with a radius of " + matcher.group(1) + " is " + String.format("%.3f", area));

            }
            else{
                messageCreateEvent.getChannel().sendMessage("Please use: `!circle [radius]`");

            }
        }
    }
}
