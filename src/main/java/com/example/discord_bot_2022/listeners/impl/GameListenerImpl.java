package com.example.discord_bot_2022.listeners.impl;

import com.example.discord_bot_2022.listeners.GameListener;
import org.javacord.api.entity.DiscordClient;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class GameListenerImpl implements GameListener {
    private final static Pattern pattern = Pattern.compile("!game (\\p{Punct}\\p{Punct}\\p{Punct}\\p{Digit}\\p{Digit}\\p{Digit}\\p{Digit}\\p{Digit}\\p{Digit}\\p{Digit}\\p{Digit}\\p{Digit}\\p{Digit}\\p{Digit}\\p{Digit}\\p{Digit}\\p{Digit}\\p{Digit}\\p{Digit}\\p{Digit}\\p{Digit}\\p{Punct})");

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if (messageCreateEvent.getMessageContent().startsWith("!game")) {
            Matcher matcher = pattern.matcher(messageCreateEvent.getMessageContent());
            System.out.println(matcher);
            Optional<User> mentionedUser = messageCreateEvent.getMessageAuthor().asUser();
            User otherUser = messageCreateEvent.getMessage().getMentionedUsers().get(0);
            System.out.println(messageCreateEvent.getMessageContent());
            if(matcher.matches()){
                messageCreateEvent.getChannel()
                        .sendMessage("That user's name is " + otherUser.getName());
            }
            else{
                messageCreateEvent.getChannel().sendMessage("Try again!");

            }
        }
    }
}
