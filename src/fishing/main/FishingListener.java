package fishing.main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
public class FishingListener implements Listener {

    @EventHandler
    public void fishingEvent(PlayerFishEvent event) {
        Pish pish = new Pish(event);
        pish.setFishingState(event.getState());
    }
}
