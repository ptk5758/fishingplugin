package fishing.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("이것이 낚시플러그인이다!");
        Bukkit.getPluginManager().registerEvents(new FishingListener(), this);
    }
}
