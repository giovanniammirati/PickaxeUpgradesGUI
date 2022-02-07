package me.mrcoder.pugui;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import me.mrcoder.commands.PUGUICmd;
import me.mrcoder.enchants.ExplosionUpgrade;
import me.mrcoder.enchants.KeyUpgrade;
import me.mrcoder.enchants.SpeedUpgrade;
import me.mrcoder.pugui.events.BlockBreakEvent;
import me.mrcoder.pugui.events.InteractEvent;
import me.mrcoder.pugui.events.InventoryClick;
import net.milkbowl.vault.economy.Economy;
import net.minecraft.server.v1_16_R2.Enchantment;

public class Main extends JavaPlugin implements Listener {
	
	public static Main plugin;
    private static Economy econ = null;
    public SpeedUpgrade speed;
    public ExplosionUpgrade explosion;
    public KeyUpgrade key;

	public void onEnable() {
		plugin = this;
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getServer().getPluginManager().registerEvents(new InventoryClick(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new InteractEvent(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new BlockBreakEvent(), this);
		this.getCommand("pugui").setExecutor(new PUGUICmd());
		this.getLogger().info("Plugin successfully enabled.");
		this.saveDefaultConfig();
		this.setupEconomy();
		speed = new SpeedUpgrade("speed");
		explosion = new ExplosionUpgrade("explosion");
		key = new KeyUpgrade("key");
		// speed.speed();
	}
	
	@SuppressWarnings("unchecked")
	public void onDisable() {
		try {
			Field byNameField = Enchantment.class.getDeclaredField("byName");
			Field byKeyField = Enchantment.class.getDeclaredField("byKey");
			byNameField.setAccessible(true);
			byKeyField.setAccessible(true);
			HashMap<NamespacedKey, Enchantment> byKey = (HashMap<NamespacedKey, Enchantment>) byKeyField.get(null);
			HashMap<String, Enchantment> byName = (HashMap<String, Enchantment>) byNameField.get(null);
			if (byKey.containsKey(speed.getKey())) {
				byKey.remove(speed.getKey());
			}
			if (byName.containsKey(speed.getName())) {
				byName.remove(speed.getName());
			}
			if (byKey.containsKey(explosion.getKey())) {
				byKey.remove(explosion.getKey());
			}
			if (byName.containsKey(explosion.getName())) {
				byName.remove(explosion.getName());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		this.getLogger().info("Plugin successfully disabled.");
	}
	
	private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        this.getLogger().info("Hooked into Vault.");
        if (rsp == null) {
            return false;
        } 
        econ = rsp.getProvider();
        return econ != null;
    }
	
	public static Main getInstance() {
		return plugin;
	}
	
    public static Economy getEconomy() {
        return econ;
    }
	
	public String getString(String name) {
		return getConfig().getString(name).replaceAll("&", "§");
	}
	 
	public void loadEnchants() {
		try {
			try {
				Field f = Enchantment.class.getDeclaredField("acceptingNew");
				f.setAccessible(true);
				f.set(null, true);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			org.bukkit.enchantments.Enchantment.registerEnchantment(speed);
			org.bukkit.enchantments.Enchantment.registerEnchantment(explosion);
			org.bukkit.enchantments.Enchantment.registerEnchantment(key);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
