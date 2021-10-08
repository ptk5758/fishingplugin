package fishing.main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
public class FishingListener implements Listener {

    Pish pish;

    @EventHandler
    public void fishingEvent(PlayerFishEvent event) {
        this.pish = new Pish(event.getPlayer());
        this.pish.setFishingState(event.getState());
    }
}
