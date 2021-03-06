package com.example.discord_bot_2022.listeners.impl;

import com.example.discord_bot_2022.listeners.TierListener;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class TierListenerImpl implements TierListener {

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        String msg = messageCreateEvent.getMessageContent();

        if(messageCreateEvent.getMessageContent().startsWith("!tier")) {
            if (msg.equalsIgnoreCase("!tier")){
                messageCreateEvent.getChannel().sendMessage("`Please try again`");

            }
            else{
                Random rand = new Random();

                String[] list = msg.replace("!tier ", "").split(" ");
                List<String> S = new ArrayList<>();
                List<String> A = new ArrayList<>();
                List<String> B = new ArrayList<>();
                List<String> C = new ArrayList<>();
                List<String> D = new ArrayList<>();
                List<String> F = new ArrayList<>();

                for (String s : list) {
                    int x = rand.nextInt(6);

                    switch (x) {
                        case 0:
                            S.add(s);
                            break;
                        case 1:
                            A.add(s);
                            break;
                        case 2:
                            B.add(s);
                            break;
                        case 3:
                            C.add(s);
                            break;
                        case 4:
                            D.add(s);
                            break;
                        case 5:
                            F.add(s);
                            break;
                    }
                }

                messageCreateEvent.getChannel().sendMessage(
                        new EmbedBuilder()
                                .setTitle("**Tier List**")
                                .setDescription("S: " + Arrays.toString(S.toArray()).replace("[", "").replace("]", "") + "\n"
                                + "A: " + Arrays.toString(A.toArray()).replace("[", "").replace("]", "") + "\n"
                                + "B: " + Arrays.toString(B.toArray()).replace("[", "").replace("]", "") + "\n"
                                + "C: " + Arrays.toString(C.toArray()).replace("[", "").replace("]", "") + "\n"
                                + "D: " + Arrays.toString(D.toArray()).replace("[", "").replace("]", "") + "\n"
                                + "F: " + Arrays.toString(F.toArray()).replace("[", "").replace("]", "") + "\n")
                                //.setThumbnail("https://cdn.discordapp.com/attachments/938298237142564904/949583664931557396/yguyg.PNG")
                                .setFooter("Generated by " + messageCreateEvent.getMessageAuthor().getDisplayName())
                );


            }
        }
    }
}
