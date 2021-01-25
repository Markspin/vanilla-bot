package com.rscvanilla.bot.api.action;

import com.rscvanilla.bot.api.BaseAction;
import com.rscvanilla.bot.api.wrappers.RSPlayer;
import com.rscvanilla.bot.mc.MudClientHooker;

import javax.inject.Inject;
import java.util.Objects;

public class PlayerAction extends BaseAction {

    @Inject
    public PlayerAction(MudClientHooker hooker) {
        super(hooker);
    }

    public String[] getPlayerNamesInDistance(int distance) {
        var allPlayers = hooker.getPlayerList();
        var userName = hooker.getUser().getName();

        var players = allPlayers
                .stream()
                .filter(Objects::nonNull)
                .filter(it -> !it.getName().equalsIgnoreCase(userName))
                .filter(it -> it.isDistanceLessThanEqual(hooker.getUser(), distance))
                .map(RSPlayer::getName).toArray(String[]::new);

        return players;
    }
}
