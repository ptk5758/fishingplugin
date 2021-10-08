package fishing.main;

import fishing.util.Utill;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Pish {
    PlayerFishEvent event;
    Player player;
    FishHook hook;

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
        this.hook = this.event.getHook();
        this.hook.remove();

        if(Utill.randomBoolean(10)){
            sendDiamond();
            this.event.setCancelled(true);
        } else {
            if(Utill.randomBoolean(80)){
                spawnMonster();
                this.event.setCancelled(true);
            } else {
                sendMessageByPlayer("기본이벤트");

            }
        }
    }

    private void spawnMonster() {
        this.hook.getLocation().getWorld().spawnEntity(this.hook.getLocation(), EntityType.FIREBALL);
    }

    private void sendMessageByPlayer(String msg) {
        this.player.sendMessage(msg);
    }

    private void sendDiamond() {
        Inventory inven = this.player.getPlayer().getInventory();
        inven.setItem(1, new ItemStack(Material.DIAMOND));
    }
}
