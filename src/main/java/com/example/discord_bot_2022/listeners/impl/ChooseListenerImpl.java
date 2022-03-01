package com.example.discord_bot_2022.listeners.impl;

import com.example.discord_bot_2022.listeners.ChooseListener;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ChooseListenerImpl implements ChooseListener {

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        String msg = messageCreateEvent.getMessageContent().toLowerCase();
        if(msg.contains("!choose")){
            String[] temp = msg.replace("!choose ", "").split(" ");
//            System.out.println(temp[0] + temp[1]);
//            messageCreateEvent.getChannel().sendMessage(temp[0] + temp[1]);

            Random rand = new Random();
            int choice = (rand.nextInt(3));
            int response = (rand.nextInt(4));

            if(choice == 0){
                response = 0;
            }
            else if (choice == 1){
                response = 1;
            }

            switch(response){
                case 0:
                    messageCreateEvent.getChannel().sendMessage(temp[0]);
                    break;
                case 1:
                    messageCreateEvent.getChannel().sendMessage(temp[1]);
                    break;
                case 2:
                    messageCreateEvent.getChannel().sendMessage("I don't like either one.");
                    break;
                case 3:
                    messageCreateEvent.getChannel().sendMessage("I like both.");
                    break;
            }
        }
    }
}
