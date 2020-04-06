package com.BloodThirster;

import org.bukkit.entity.Player;

public class Effects 
{
	public static void lifeSteal(Player playerDamager, Double damage, String temp2, String bt)
	{
		 String level=temp2.replace(bt, "");
		  level=level.replace(" ", "");
		  if(level!=null && level!="" && Essentials.checkIfInteger(level))
		  {
			  	int modifier=Integer.parseInt(level)/100;
			  	
			   
			    if(playerDamager.getHealth()+(damage*modifier)>playerDamager.getMaxHealth())
			    {
			    	playerDamager.setHealth(playerDamager.getMaxHealth());
			    }
			    else playerDamager.setHealth(playerDamager.getHealth() + damage*modifier);
			   
		  }
		  else
		  {
			 
			    if(playerDamager.getHealth()+damage/100>playerDamager.getMaxHealth())
			    {
			    	playerDamager.setHealth(playerDamager.getMaxHealth());
			    }
			    else playerDamager.setHealth(playerDamager.getHealth() + damage/100);
		  }
	}
}
