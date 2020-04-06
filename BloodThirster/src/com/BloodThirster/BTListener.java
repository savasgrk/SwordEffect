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
		player.sendMessage("Welcome");
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
					  Player playerDamager = (Player) damager;
					  double damage = event.getDamage();
					  
					  if(temp2.contains(bt))
					  {
						  Effects.lifeSteal(playerDamager, damage, temp2, bt);
					  }
					  temp.remove(temp.size()-1);
				  }
				  
			  }//modifier was not declared here, but you probably would like to steal only a portion of dealt damage
		  }
	}
	
}
