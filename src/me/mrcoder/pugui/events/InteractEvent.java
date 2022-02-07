package me.mrcoder.pugui.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractEvent implements Listener {

	@EventHandler
	public void onUse(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
			switch (e.getItem().getType()) {
			case WOODEN_PICKAXE:
			case STONE_PICKAXE:
			case IRON_PICKAXE:
			case GOLDEN_PICKAXE:
			case DIAMOND_PICKAXE:
			case NETHERITE_PICKAXE:
				GUIManager gui = new GUIManager(e.getItem());
				gui.openInventory(p);
				break;
			default:
				break;
			}
		}
	}
}