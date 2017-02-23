package red.man10;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.bukkit.plugin.java.JavaPlugin;

public final class mapclock extends JavaPlugin implements Listener{

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().fine("てst");
        getServer().getPluginManager().registerEvents (this,this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onMap(MapInitializeEvent e){
        getLogger().fine("map");
        MapView m = e.getMap();
        for(MapRenderer r:e.getMap().getRenderers()){
            e.getMap().removeRenderer(r);
        }
        e.getMap().addRenderer(new ClockFace());
    }
}
