package com.BloodThirster;

import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

public class BTListener implements Listener
{
	public BTListener(StartUp plugin)
	{
		
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		Player player= (Player) event.getPlayer();
		player.sendMessage("hola");
		
		ItemStack item=new ItemSmith().buildWeapon(1); //item and amount
		ItemStack item1=new ItemSmith().LifeSteal(1, 100);
		player.getInventory().addItem(item);
		player.getInventory().addItem(item1);
	}
	@EventHandler
	public void onPlayerAttack(EntityDamageByEntityEvent event)
	{
		 Entity damager = event.getDamager();
		 String bt="BloodThirster";
		  if(damager instanceof Player)
		  {
			  //(((Player) damager).getItemInHand().getItemMeta().getLocalizedName().equals("BloodThirster")))
			  if((((Player) damager).getItemInHand().getItemMeta().hasLore()))
			  {
				  ArrayList temp=(ArrayList) ((Player) damager).getItemInHand().getItemMeta().getLore();
				  while(!temp.isEmpty())
				  {
					  String temp2=(String) temp.get(temp.size()-1);
					  if(temp2.contains(bt))
					  {
						  String level=temp2.replace(bt, "");
						  level=level.replace(" ", "");
						  if(level!=null && level!="" && Essentials.checkIfInteger(level))
						  {
							  	int modifier=Integer.parseInt(level)/100;
							  	Player playerDamager = (Player) damager;
							    double damage = event.getDamage();
							    if(playerDamager.getHealth()+(damage*modifier)>playerDamager.getMaxHealth())
							    {
							    	playerDamager.setHealth(playerDamager.getMaxHealth());
							    }
							    else playerDamager.setHealth(playerDamager.getHealth() + damage*modifier);
							   
						  }
						  else
						  {
							  Player playerDamager = (Player) damager;
							    double damage = event.getDamage();
							    if(playerDamager.getHealth()+damage/100>playerDamager.getMaxHealth())
							    {
							    	playerDamager.setHealth(playerDamager.getMaxHealth());
							    }
							    else playerDamager.setHealth(playerDamager.getHealth() + damage/100);
						  }
						  
					  }
					  temp.remove(temp.size()-1);
				  }
				  
			  }//modifier was not declared here, but you probably would like to steal only a portion of dealt damage
		  }
	}
	
}
