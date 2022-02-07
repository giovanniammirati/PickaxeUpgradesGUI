package me.mrcoder.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

public class PUGUICmd implements Listener,CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String alias, String[] args) {
		s.sendMessage("§r");
		s.sendMessage("§3PickaxeUpgradesGUI §bby TechyBW.");
		s.sendMessage("§7§o(( §f§oRight click with a pickaxe to open. §7§o))§r");
		s.sendMessage("§r");
		return true;
	}
}
