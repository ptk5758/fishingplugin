package fishing.main;

import fishing.util.Utill;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Pish {
    PlayerFishEvent event;
    Player player;

    Pish(PlayerFishEvent e) {
        this.event = e;
        this.player = e.getPlayer();
    }

    public void setFishingState(PlayerFishEvent.State state) {
        switch (state) {
            case BITE: //낚시바늘이 땡겨지고 물고기를 낚을수있는 그순간 인상태
                //sendMessageByPlayer("BITE 을했따");
                break;
            case CAUGHT_ENTITY: //엔티티드를 낚시대로 우클릭으로 매달았을때
                //sendMessageByPlayer("CAUGHT_ENTITY 을했따");
                break;
            case FISHING: //낚시대를 던졌을때
                //sendMessageByPlayer("FISHING 을했따");
                break;
            case CAUGHT_FISH: //물고기를 잡는대 성공하면
                onPishEvent();
                break;
            case FAILED_ATTEMPT: //못낚았을때
                //sendMessageByPlayer("FAILED_ATTEMPT 을했따");
                break;
            case IN_GROUND: //낚시대가 땅바닥으로 쳐밖았을때
                //sendMessageByPlayer("IN_GROUND 을했따");
                break;
            case REEL_IN: //낚시대가 땅에 안박히고 동시에 BITE가 일어나지 않았을대
                //sendMessageByPlayer("REEL_IN 을했따");
                break;
            default:
                //sendMessageByPlayer("default 을했따");
                break;
        }

    }
    //Event.isCancelled(); 해당 이벤트가 최소됐으면 true 리턴 아니면 false
    private void onPishEvent() {
        FishHook hook = this.event.getHook();
        hook.remove();
        this.event.setCancelled(true);
        randomFishingEvent(Utill.randomValue());
    }

    private void sendMessageByPlayer(String msg) {
        this.player.sendMessage(msg);
    }
    private void randomFishingEvent(int random) {

        sendDiamond();
        /*if(random >= 0 && random <= 10) {
            sendMessageByPlayer("다이아를 낚았다");
            sendDiamond();
        } else if (random >= 11 && random <= 20) {
            sendMessageByPlayer("무언가 색다른 이벤트");
        } else if (random >= 21 && random <= 40) {
            sendMessageByPlayer("몬스터가 소환 되는 이벤트");
        } else {
            sendMessageByPlayer("원래 물고기 이벤트");
        }*/

    }
    private void sendDiamond() {
        Inventory inven = this.player.getPlayer().getInventory();
        inven.setItem(1, new ItemStack(Material.DIAMOND));
    }
}
