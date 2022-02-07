package me.mrcoder.enchants;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import me.mrcoder.pugui.Main;

public class SpeedUpgrade extends Enchantment implements Listener {

	public SpeedUpgrade(String namespaced) {
		super(new NamespacedKey(Main.getInstance(), namespaced));
	}

	@Override
	public boolean canEnchantItem(ItemStack arg0) {
		return true;
	}

	@Override
	public boolean conflictsWith(Enchantment arg0) {
		return false;
	}

	@Override
	public EnchantmentTarget getItemTarget() {
		return null;
	}

	@Override
	public int getMaxLevel() {
		return 1;
	}

	@Override
	public String getName() {
		return "SpeedUpgrade";
	}

	@Override
	public int getStartLevel() {
		return 1;
	}

	@Override
	public boolean isCursed() {
		return false;
	}

	@Override
	public boolean isTreasure() {
		return false;
	}
	
	/*
	public void speed() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			@Override
			public void run() {
				for (Player p : Bukkit.getServer().getOnlinePlayers()) {
					if (p == null) { continue; }
					if (p.getInventory().getItemInMainHand() == null) { p.removePotionEffect(PotionEffectType.SPEED); }
					if (p.getInventory().getItemInMainHand().getItemMeta().getLore().contains("§7Speed")) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1, 1));
					} else {
						p.removePotionEffect(PotionEffectType.SPEED);
					}
				}
			}
		}, 1, 1);
	}
	*/
}
