package red.man10;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

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

    @EventHandler
    public void onShoot(ProjectileLaunchEvent e){
        new BukkitRunnable(){
            int a = 0;
            @Override
            public void run() {
                Entity ee = e.getEntity();
                World w = e.getEntity().getWorld();
                Effect e = Effect.HAPPY_VILLAGER;
                Location l = ee.getLocation();
                w.playEffect(l,e,1);
                if(a > 50){
                    this.cancel();
                }
                a++;
            }
        }.runTaskTimer(this, 0, 0);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("givec")){
            ArrayList<String> lore = new ArrayList<String>();
            Player p = (Player) sender;
            ItemStack map = new ItemStack(Material.EMPTY_MAP);
            ItemMeta mapim = map.getItemMeta();
            lore.add("ID:1");
            mapim.setLore(lore);
            map.setItemMeta(mapim);
            p.getInventory().addItem(map);
            p.sendMessage("pop!");
        }
        return true;
    }

}
