package com.example.discord_bot_2022.listeners.impl;

import com.example.discord_bot_2022.listeners.DeleteReactionListener;
import org.javacord.api.event.message.reaction.ReactionAddEvent;
import org.springframework.stereotype.Component;

@Component
public class DeleteReactionListenerImpl implements DeleteReactionListener {

    @Override
    public void onReactionAdd(ReactionAddEvent reactionAddEvent){
        if(reactionAddEvent.getEmoji().equalsEmoji("\uD83D\uDC4E"))
            reactionAddEvent.deleteMessage();

        if(reactionAddEvent.getEmoji().equalsEmoji("\uD83D\uDC4E"))
            reactionAddEvent.deleteMessage();
        //create switch case. check picks a card, x stays.
    }
}
