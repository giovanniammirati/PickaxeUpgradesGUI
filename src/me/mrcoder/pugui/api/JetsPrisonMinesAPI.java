package me.mrcoder.pugui.api;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.bukkit.Location;
import org.bukkit.block.Block;

import me.jet315.prisonmines.manager.MineManager;
import me.jet315.prisonmines.mine.Mine;
import me.jet315.prisonmines.properties.Properties;

public class JetsPrisonMinesAPI {

    @Inject
    private MineManager mineManager;
    
    @Inject
    private Properties properties;
 
    @Inject
    //public void JetsPrisonMinesAPI() {}
    
    public Properties getProperties() { return this.properties; }
    
    public MineManager getMineManager() { return this.mineManager; }

    public Collection<Mine> getMines() {
        return mineManager.getActiveMines().values();
    }

    public ArrayList<Mine> getMinesByBlock(Block block) {
        return mineManager.getMinesByBlock(block);
    }

    public ArrayList<Mine> getMinesByLocation(Location loc) {
        return mineManager.getMinesByLocation(loc);
    }
 
    public Mine getMineByName(String mineName) {
        return mineManager.getMineByName(mineName);
    }
 
}
