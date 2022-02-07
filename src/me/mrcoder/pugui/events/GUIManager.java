package me.mrcoder.pugui.events;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.mrcoder.pugui.Main;

public class GUIManager implements Listener {
	
	private final Inventory inv;
	
	public GUIManager(ItemStack hand) {
		inv = Bukkit.createInventory(null, 54, "Pickaxe Upgrades");
		initializeItems();
	}

    public void initializeItems() {
    	ItemStack potion = createGuiItem(Material.FEATHER, 
    			"§aSpeed Upgrade", 
    			"§7This upgrade increases", 
    			"§7your speed when you", 
    			"§7are holding the pickaxe.", 
    			"§r", 
    			Main.getInstance().getString("level-lore") + "1", 
    			Main.getInstance().getString("cost-lore") + "100B");
    	inv.setItem(20, potion);
    	ItemStack tnt = createGuiItem(Material.TNT, 
    			"§aExplosion Upgrade", 
    			"§7This upgrade breaks blocks", 
    			"§7with an explosive effect.", 
    			"§7It breaks with a 3x3 radius.", 
    			"§r",
    			Main.getInstance().getString("level-lore") + "1", 
    			Main.getInstance().getString("cost-lore") + "1T");
    	inv.setItem(21, tnt);
    	ItemStack eff = createGuiItem(Material.DIAMOND_PICKAXE, 
    			"§aEfficiency Upgrade", 
    			"§7This upgrade will increase", 
    			"§7your mining speed.", 
    			"§r",
    			Main.getInstance().getString("level-lore") + "1", 
    			Main.getInstance().getString("cost-lore") + "50B");
    	inv.setItem(22, eff);
    	ItemStack fort = createGuiItem(Material.EMERALD, 
    			"§aFortune Upgrade", 
    			"§7With this upgrade the amount", 
    			"§7of blocks broken will increase.", 
    			"§r",
    			Main.getInstance().getString("level-lore") + "1", 
    			Main.getInstance().getString("cost-lore") + "200B");
    	inv.setItem(23, fort);
    	ItemStack key = createGuiItem(Material.TRIPWIRE_HOOK, 
    			"§aKey Upgrade", 
    			"§7This upgrade gives you a 10% chance to", 
    			"§7get crate keys while you are mining.", 
    			"§r",
    			Main.getInstance().getString("level-lore") + "1", 
    			Main.getInstance().getString("cost-lore") + "200B");
    	inv.setItem(24, key);
    	inv.setItem(3, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
    	inv.setItem(4, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
    	inv.setItem(5, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
    	inv.setItem(11, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
    	inv.setItem(12, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
    	inv.setItem(13, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
    	inv.setItem(14, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
    	inv.setItem(15, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
    	inv.setItem(19, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
    	inv.setItem(25, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
    	inv.setItem(28, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
    	inv.setItem(29, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
    	inv.setItem(33, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
    	inv.setItem(34, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
    	inv.setItem(38, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
    	inv.setItem(39, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
    	inv.setItem(41, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
    	inv.setItem(42, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
    	inv.setItem(48, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
    	inv.setItem(49, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
    	inv.setItem(50, new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1));
    	fillEmptySlots(inv, new ItemStack(Material.WHITE_STAINED_GLASS_PANE));
    }
 
    protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }

    public void openInventory(final HumanEntity ent) {
        ent.openInventory(inv);
    }
    
    public void fillEmptySlots(Inventory inv, ItemStack item) {
        for (int i = 0; i < inv.getSize(); i++) {
            if (inv.getItem(i) == null || inv.getItem(i).getType().equals(Material.AIR)) {
                inv.setItem(i, item);
            }
        }
    }
}