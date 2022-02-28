package com.example.discord_bot_2022.listeners.impl;

import com.example.discord_bot_2022.listeners.EmojiRateListener;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.event.message.reaction.ReactionAddEvent;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Random;

@Component
public class EmojiRateListenerImpl implements EmojiRateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent){

        if (messageCreateEvent.getMessageContent().toLowerCase().contains("!react")){
            Random rand = new Random();
            int x = rand.nextInt(10);
            System.out.println(x);

            switch(x){

                case 0:
                    messageCreateEvent.addReactionsToMessage("1️⃣");
                    break;
                case 1:
                    messageCreateEvent.addReactionsToMessage("2️⃣");
                    break;
                case 2:
                    messageCreateEvent.addReactionsToMessage("3️⃣");
                    break;
                case 3:
                    messageCreateEvent.addReactionsToMessage("4️⃣");
                    break;
                case 4:
                    messageCreateEvent.addReactionsToMessage("5️⃣");
                    break;
                case 5:
                    messageCreateEvent.addReactionsToMessage("6️⃣");
                    break;
                case 6:
                    messageCreateEvent.addReactionsToMessage("7️⃣");
                    break;
                case 7:
                    messageCreateEvent.addReactionsToMessage("8️⃣");
                    break;
                case 8:
                    messageCreateEvent.addReactionsToMessage("9️⃣");
                    break;
                case 9:
                    messageCreateEvent.addReactionsToMessage("\uD83D\uDD1F");
                    break;
            }


        }


    }


}
