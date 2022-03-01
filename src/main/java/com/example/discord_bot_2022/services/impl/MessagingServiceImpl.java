package com.example.discord_bot_2022.services.impl;

import com.example.discord_bot_2022.listeners.BlackjackListener;
import com.example.discord_bot_2022.listeners.DeleteReactionListener;
import com.example.discord_bot_2022.services.MessagingService;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.listener.message.reaction.ReactionAddListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;


@Component
public class MessagingServiceImpl implements MessagingService  {
    @Autowired
    private DeleteReactionListener deleteReactionListener;
    @Override
    public CompletableFuture<Message> sendMessage(MessageAuthor author, String title, String description, String footer, String field1, String value1, String field2, String value2, String thumbnail, TextChannel channel) {
        int red = (int) Math.floor(Math.random() * 255);
        int green = (int) Math.floor(Math.random() * 255);
        int blue = (int) Math.floor(Math.random() * 255);
        return new MessageBuilder().setEmbed(new EmbedBuilder()
                .setAuthor(author)
                .setTitle(title)
                .setDescription(description)
                .setFooter(footer)
                .addInlineField(field1,value1)
                .addInlineField(field2, value2)
                .setThumbnail(thumbnail)
                .setColor(new Color(red, green, blue)))
                    .send(channel);
    }

    @Override
    public void sendMessage(MessageAuthor author, String title, String description, String footer, String field1, String value1, String field2, String value2, String thumbnail, TextChannel channel, boolean withDelete) {
        this.sendMessage(author, title, description, footer, field1, value1, field2, value2, thumbnail, channel)
                .thenAccept(message -> message.addReactionAddListener(deleteReactionListener).removeAfter(1, TimeUnit.NANOSECONDS));
    }
}
