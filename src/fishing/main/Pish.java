package fishing.main;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerFishEvent;

public class Pish {
    Player player;

    Pish(Player p) {
        this.player = p;
    }

    public void setFishingState(PlayerFishEvent.State state) {
        switch (state) {
            case BITE:
                sendMessageByPlayer("BITE 을했따");
                break;
            case CAUGHT_ENTITY:
                sendMessageByPlayer("CAUGHT_ENTITY 을했따");
                break;
            case FISHING:
                sendMessageByPlayer("FISHING 을했따");
                break;
            case CAUGHT_FISH:
                sendMessageByPlayer("CAUGHT_FISH 을했따");
                break;
            case FAILED_ATTEMPT:
                sendMessageByPlayer("FAILED_ATTEMPT 을했따");
                break;
            case IN_GROUND:
                sendMessageByPlayer("IN_GROUND 을했따");
                break;
            case REEL_IN:
                sendMessageByPlayer("REEL_IN 을했따");
                break;
            default:
                sendMessageByPlayer("default 을했따");
                break;
        }

    }

    private void sendMessageByPlayer(String msg) {
        this.player.sendMessage(msg);
    }
}
