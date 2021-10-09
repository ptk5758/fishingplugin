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

import java.util.ArrayList;
import java.util.Random;

public class Pish {
    PlayerFishEvent event;
    Player player;
    FishHook hook;

    public static ArrayList<Material> materials = new ArrayList<Material>() ;

    Pish(PlayerFishEvent e) {
        this.event = e;
        this.player = e.getPlayer();
        setRandomMaterials();
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

        //Utill.randomBoolean(10)
        String eventValue = fishCatchEvent();
        switch (eventValue) {
            case "DIAMOND":
                sendDiamond();
                break;
            case "EVENT":
                sendMessageByPlayer("미구현");
                break;
            case "ITEM":
                sendItem();
                break;
            case "MONSTER":
                spawnMonster();
                break;
        }

        if(!eventValue.equals("NORMAL")){
            this.event.setCancelled(true);
        }

    }

    private String fishCatchEvent() {
        String result = "NORMAL";

        if(Utill.randomBoolean(5)) {
            result = "DIAMOND";
        }

        if(Utill.randomBoolean(10)) {
            result = "EVENT";
        }

        if(Utill.randomBoolean(80)) {
            result = "ITEM";
        }

        if(Utill.randomBoolean(30)) {
            result = "MONSTER";
        }


        return result;
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

    private void sendItem() {
        ItemStack item = new ItemStack(materials.get(new Random().nextInt(materials.size())));
        Inventory inven = this.player.getPlayer().getInventory();
        inven.addItem(item);
    }

    private void setRandomMaterials() {
        this.materials.add(Material.APPLE);
        this.materials.add(Material.GRAVEL);
        this.materials.add(Material.SOUL_SAND);
        this.materials.add(Material.ORANGE_GLAZED_TERRACOTTA);
        this.materials.add(Material.PINK_GLAZED_TERRACOTTA);
        this.materials.add(Material.PUMPKIN_SEEDS);
        this.materials.add(Material.MELON_SEEDS);
        this.materials.add(Material.IRON_ORE);
        this.materials.add(Material.GOLD_ORE);
        this.materials.add(Material.SPRUCE_SAPLING);
        this.materials.add(Material.ACACIA_SAPLING);
        this.materials.add(Material.BAMBOO_SAPLING);
        this.materials.add(Material.BIRCH_SAPLING);
        this.materials.add(Material.DARK_OAK_SAPLING);
        this.materials.add(Material.JUNGLE_SAPLING);
        this.materials.add(Material.KELP);
        this.materials.add(Material.VINE);
        this.materials.add(Material.BLACK_DYE);
        this.materials.add(Material.BLUE_DYE);
        this.materials.add(Material.BROWN_DYE);
        this.materials.add(Material.CYAN_DYE);
        this.materials.add(Material.GRAY_DYE);
        this.materials.add(Material.LIME_DYE);
        this.materials.add(Material.GREEN_DYE);
        this.materials.add(Material.PINK_DYE);
        this.materials.add(Material.PURPLE_DYE);
        this.materials.add(Material.RED_DYE);
        this.materials.add(Material.MAGENTA_DYE);
        this.materials.add(Material.YELLOW_DYE);
        this.materials.add(Material.BRICK);
        this.materials.add(Material.PAPER);
        this.materials.add(Material.EGG);
        this.materials.add(Material.DIAMOND_HORSE_ARMOR);
        this.materials.add(Material.GOLDEN_HORSE_ARMOR);
        this.materials.add(Material.IRON_HORSE_ARMOR);
        this.materials.add(Material.LEATHER_HORSE_ARMOR);
        this.materials.add(Material.CHORUS_FRUIT);
        this.materials.add(Material.BROWN_MUSHROOM);
        this.materials.add(Material.RED_MUSHROOM);
        this.materials.add(Material.POTTED_BROWN_MUSHROOM);
        this.materials.add(Material.POTTED_RED_MUSHROOM);
        this.materials.add(Material.CACTUS);
        this.materials.add(Material.SAND);
        this.materials.add(Material.PUFFERFISH);
        this.materials.add(Material.POTATO);
        this.materials.add(Material.BAKED_POTATO);
        this.materials.add(Material.POISONOUS_POTATO);

    }
}
