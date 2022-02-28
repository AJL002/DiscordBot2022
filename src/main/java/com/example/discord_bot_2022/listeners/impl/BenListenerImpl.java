package com.example.discord_bot_2022.listeners.impl;

import com.example.discord_bot_2022.listeners.BenListener;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Random;

@Component
public class BenListenerImpl implements BenListener {

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        if (messageCreateEvent.getMessageContent().toLowerCase().startsWith("!ben") || messageCreateEvent.getMessageContent().toLowerCase().startsWith("!b")) {
            Random rand = new Random();

            int x = (rand.nextInt(7));
            int yn = (rand.nextInt(4));
            if(yn == 0){
                x = 0;
//                System.out.println("zero x");
            }
            else if (yn == 1){
                x = 1;
//                System.out.println("one x");
            }
            System.out.println(x);

            switch(x){
                case 0:
                    messageCreateEvent.getChannel().sendMessage("Yes.");
                    break;
                case 1:
                    messageCreateEvent.getChannel().sendMessage("No.");;
                    break;
                case 2:
                    messageCreateEvent.getChannel().sendMessage("https://tenor.com/view/ugh-gif-24966261");
                    break;
                case 3:
                    messageCreateEvent.getChannel().sendMessage("Ho ho ho!");
                    break;
                case 4:
                    messageCreateEvent.getChannel().sendMessage("https://c.tenor.com/UZOcqAyMu4QAAAAd/talking-ben-eating.gif");
                    break;
                case 5:
                    messageCreateEvent.getChannel().sendMessage("https://c.tenor.com/hdPVLfpe81cAAAAC/talking-ben-drinking.gif");
                    break;
                case 6:
                    messageCreateEvent.getChannel().sendMessage("https://c.tenor.com/A2S_WFksjYwAAAAM/talking-tom-burp.gif");
                    break;
            }

        }
    }
}
