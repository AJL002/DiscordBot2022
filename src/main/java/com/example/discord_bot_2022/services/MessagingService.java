package com.example.discord_bot_2022.services;

import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;

import java.util.concurrent.CompletableFuture;

public interface MessagingService {

    CompletableFuture<Message> sendMessage(MessageAuthor author, String title, String description, String footer, String field1, String value1, String field2, String value2, String thumbnail, TextChannel channel);
    void sendMessage(MessageAuthor author, String title, String description, String footer, String field1, String value1, String field2, String value2, String thumbnail, TextChannel channel, boolean withDelete);
}
