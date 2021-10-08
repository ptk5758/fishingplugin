package fishing.main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
public class FishingListener implements Listener {
    @EventHandler
    public void fishingEvent(PlayerFishEvent event) {
        event.getPlayer().sendMessage("너는낚시를 했다");
    }
}
