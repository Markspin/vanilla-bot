package rscvanilla.bot.api.actions;

import rscvanilla.bot.api.models.wrappers.RSPlayerCharacter;
import rscvanilla.bot.mc.MudClientHooker;

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
                .map(RSPlayerCharacter::getName).toArray(String[]::new);

        return players;
    }
}