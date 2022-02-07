package me.mrcoder.pugui.events;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.mrcoder.pugui.Main;

public class InventoryClick implements Listener {
	
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
    	final Player p = (Player) e.getWhoClicked();
    	if (e.getInventory().getSize() < 53) {
    		return;
    	}
        if (e.getInventory().getItem(20).getItemMeta().getDisplayName().equals("§aSpeed Upgrade")) {
        	e.setCancelled(true);
        }
        final ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem == null || clickedItem.getType() == Material.AIR) {
        	return;
        }
        if (clickedItem.getItemMeta().getDisplayName().equals("§aSpeed Upgrade")) {
        	if (!p.getInventory().getItemInMainHand().containsEnchantment(Main.getInstance().speed)) {
           		final long balance = (long) Main.getEconomy().getBalance(Bukkit.getPlayer(p.getName()));
            	if ((balance - 100000000000L) >= 0) {
            		p.closeInventory();
            		Main.getEconomy().withdrawPlayer(p, 100000000000L);
            		p.sendMessage(Main.getInstance().getString("success-upgrade"));
            		p.getInventory().getItemInMainHand().addUnsafeEnchantment(Main.getInstance().speed, 1);
            		ItemMeta meta = p.getInventory().getItemInMainHand().getItemMeta();
            		ArrayList<String> lore = new ArrayList<>();
            		if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§fDiamond Pickaxe")) {
            			p.getInventory().getItemInMainHand().getItemMeta().setDisplayName("§bDiamond Pickaxe"); 
            			p.updateInventory();
            		}
            		lore.add("§7Speed");
            		meta.setLore(lore);
            		p.getInventory().getItemInMainHand().setItemMeta(meta);
            		p.updateInventory();
            	} else {
            		p.closeInventory();
            		p.sendMessage(Main.getInstance().getString("insufficient-money"));
            	}
        	} else {
        		p.sendMessage(Main.getInstance().getString("failed-upgrade"));
        		p.closeInventory();
        	}
        }
        if (clickedItem.getItemMeta().getDisplayName().equals("§aExplosion Upgrade")) {
        	if (!p.getInventory().getItemInMainHand().containsEnchantment(Main.getInstance().explosion)) {
        		final long balance = (long) Main.getEconomy().getBalance(Bukkit.getPlayer(p.getName()));
            	if ((balance - 1000000000000L) >= 0) {
            		p.closeInventory();
            		Main.getEconomy().withdrawPlayer(p, 1000000000000L);
            		p.getInventory().getItemInMainHand().addUnsafeEnchantment(Main.getInstance().explosion, 1);
            		ItemMeta meta = p.getInventory().getItemInMainHand().getItemMeta();
            		ArrayList<String> lore = new ArrayList<>();
            		if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§fDiamond Pickaxe")) {
            			p.getInventory().getItemInMainHand().getItemMeta().setDisplayName("§bDiamond Pickaxe"); 
            			p.updateInventory();
            		}
            		lore.add("§7Explosion");
            		meta.setLore(lore);
            		p.getInventory().getItemInMainHand().setItemMeta(meta);
            		p.updateInventory();
            		p.sendMessage(Main.getInstance().getString("success-upgrade"));
            	} else {
            		p.closeInventory();
            		p.sendMessage(Main.getInstance().getString("insufficient-money"));
            	}
        	} else {
        		p.sendMessage(Main.getInstance().getString("failed-upgrade"));
        		p.closeInventory();
        	}
        }
        if (clickedItem.getItemMeta().getDisplayName().equals("§aEfficiency Upgrade")) {
        	final long balance = (long) Main.getEconomy().getBalance(Bukkit.getPlayer(p.getName()));
        	if ((balance - 50000000000L) >= 0) {
        		if (p.getInventory().getItemInMainHand().containsEnchantment(Enchantment.DIG_SPEED)) {
        			if (p.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.DIG_SPEED) >= 20) {
        				p.sendMessage(Main.getInstance().getString("failed-upgrade"));
        				p.closeInventory();
        			} else {
        				p.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.DIG_SPEED, 20);
        				Main.getEconomy().withdrawPlayer(p, 50000000000L);
        				p.sendMessage(Main.getInstance().getString("success-upgrade"));
        				p.closeInventory();
        			}
        		} else {
        			p.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.DIG_SPEED, 20);
        			Main.getEconomy().withdrawPlayer(p, 50000000000L);
        			p.sendMessage(Main.getInstance().getString("success-upgrade"));
        			p.closeInventory();
        		}
        	} else {
        		p.closeInventory();
        		p.sendMessage(Main.getInstance().getString("insufficient-money"));
        	}
        }
        if (clickedItem.getItemMeta().getDisplayName().equals("§aFortune Upgrade")) {
        	final long balance = (long) Main.getEconomy().getBalance(Bukkit.getPlayer(p.getName()));
        	if ((balance - 50000000000L) >= 0) {
        		if (p.getInventory().getItemInMainHand().containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
        			if (p.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) >= 10) {
        				p.sendMessage(Main.getInstance().getString("failed-upgrade"));
        				p.closeInventory();
        			} else {
        				p.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
        				Main.getEconomy().withdrawPlayer(p, 200000000000L);
        				p.sendMessage(Main.getInstance().getString("success-upgrade"));
        				p.closeInventory();
        			}
        		} else {
        			p.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
        			Main.getEconomy().withdrawPlayer(p, 200000000000L);
        			p.sendMessage(Main.getInstance().getString("success-upgrade"));
        			p.closeInventory();
        		}
        	} else {
        		p.closeInventory();
        		p.sendMessage(Main.getInstance().getString("insufficient-money"));
        	}
        }
        if (clickedItem.getItemMeta().getDisplayName().equals("§aKey Upgrade")) {
        	final long balance = (long) Main.getEconomy().getBalance(Bukkit.getPlayer(p.getName()));
        	if ((balance - 200000000000L) >= 0) {
        		if (!p.getInventory().getItemInMainHand().containsEnchantment(Main.getInstance().key)) {
        			Main.getEconomy().withdrawPlayer(p, 200000000000L);
               		p.getInventory().getItemInMainHand().addUnsafeEnchantment(Main.getInstance().key, 1);
            		ItemMeta meta = p.getInventory().getItemInMainHand().getItemMeta();
            		ArrayList<String> lore = new ArrayList<>();
            		if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§fDiamond Pickaxe")) {
            			p.getInventory().getItemInMainHand().getItemMeta().setDisplayName("§bDiamond Pickaxe"); 
            			p.updateInventory();
            		}
            		lore.add("§7Key Finder");
            		meta.setLore(lore);
            		p.getInventory().getItemInMainHand().setItemMeta(meta);
            		p.updateInventory();
            		p.sendMessage(Main.getInstance().getString("success-upgrade"));
    				p.closeInventory();
        		} else {
            		p.sendMessage(Main.getInstance().getString("failed-upgrade"));
            		p.closeInventory();
        		}
        	} else {
        		p.closeInventory();
        		p.sendMessage(Main.getInstance().getString("insufficient-money"));
        	}
        }
    }
    
    @EventHandler
    public void onInventoryDrag(final InventoryDragEvent e) {
        if (e.getInventory().getItem(20).getItemMeta().getDisplayName().equals("§aSpeed Upgrade")) {
        	e.setCancelled(true);
        }
    }
}