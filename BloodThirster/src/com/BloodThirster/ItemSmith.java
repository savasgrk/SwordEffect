package com.BloodThirster;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class ItemSmith 
{
	public ItemStack makeItem(Material m, String name, String desc, int amount)
	{
		ItemStack item = new ItemStack(m, amount);
		
		//create the item's meta data (name, lore/desc etc)
		ItemMeta im= item.getItemMeta();
		im.setDisplayName(name);
		
		//creates the lore
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(desc);
		im.setLore(lore);
		//Hides the vanilla item tooltip text
		im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		//sets the item's meta data to the custom im meta data
		item.setItemMeta(im);
		return item;
		
	}
	public ItemStack buildWeapon(int amount)
	{
		Material m=Material.GOLDEN_SWORD;
		String name= (ChatColor.GOLD + "" + ChatColor.BOLD +"Sword of King Midas");
		String desc=(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + " The golden sword of the great king Midas himself");
		return makeItem(m, name, desc, amount);
		
		
	}
	public ItemStack LifeSteal(int amount, int level)
	{
		Material m=Material.DIAMOND_SWORD;
		String name= (ChatColor.BLUE + "" + ChatColor.BOLD +"Sword of King Midas");
		String desc=("BloodThirster" +level);
		return makeItem(m, name, desc, amount);
	}
	public ItemStack makeEffectItem(Material m, String name, ArrayList desc, int amount)
	{
		ItemStack item = new ItemStack(m, amount);
		
		//create the item's meta data (name, lore/desc etc)
		ItemMeta im= item.getItemMeta();
		im.setDisplayName(name);
		
		//creates the lore
		
		
		im.setLore(desc);
		//Hides the vanilla item tooltip text
		//sets the item's meta data to the custom im meta data
		item.setItemMeta(im);
		return item;
		
	}
}
