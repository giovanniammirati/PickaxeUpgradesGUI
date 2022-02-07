package me.mrcoder.pugui.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.mrcoder.pugui.Main;

public class BlockBreakEvent implements Listener {
	
	public final Block getBlock() {
		return getBlock();
	}
	
	public final Player getPlayer() {
		return getPlayer();
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		if (e.getPlayer().getInventory().getItemInMainHand().containsEnchantment(Main.getInstance().explosion)) {
		    for (int xOff = -1; xOff <= 1; ++xOff) {
		        for (int yOff = -1; yOff <= 1; ++yOff) {
		            for (int zOff = -1; zOff <= 1; ++zOff) {
		                e.getBlock().getRelative(xOff, yOff, zOff).breakNaturally();
		            }
		        }
		    }
		}
	}
}
