package com.BloodThirster;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Commands 
{
	public static boolean giveSword(String[] args, Player player)
	{
		if(args!=null)
		{
			if(args.length==1)
			{
				
				if(!Essentials.checkIfInteger(args[0]))
				{
					player.sendMessage("Your command was not recognized");
					return true;
				}
				
				Inventory inv=player.getInventory();
				ItemStack item=new ItemSmith().buildWeapon(Integer.parseInt(args[0]));
				inv.addItem(item);
				return true;
			}
			else if(args.length==0)
			{	
				Inventory inv=player.getInventory();
				ItemStack item=new ItemSmith().buildWeapon(1);
				inv.addItem(item);
				return true;
			}	
			
			else
			{
				player.sendMessage("Your command was not recognized");
				return true;
			}
			
		}
		else
		{
			Inventory inv=player.getInventory();
			ItemStack item=new ItemSmith().buildWeapon(1);
			inv.addItem(item);
			return true;
			
		}
	}
	public static boolean effectSword(String[] args1, Player player)
	{
		if(args1!=null)
		{
			String lowercase=args1[0].toLowerCase();
			switch(lowercase)
			{
				case "bt":
					if(args1.length==2 && Essentials.checkIfInteger(args1[1]))
					{
							return addLore(player, "BloodThirster", args1[1]);
					}
					else 
					{
						player.sendMessage("Your command was not recognized");
						return true;
					}
						
					
				default:
					player.sendMessage("Your command was not recognized  " + lowercase + " ");
					return true;	
					
			}
		}
		player.sendMessage("Your command was not recognized, args==null");
		return true;
		/*switch(args[0])
		{
			case "BloodThirster":
				if(args.length==2 && Essentials.checkIfInteger(args[1]))
				{
					
						ArrayList lore;
						if(player.getItemInHand().getItemMeta().hasLore())
						{
								lore=(ArrayList) player.getItemInHand().getItemMeta().getLore();
						}
						else lore=new ArrayList();
						lore.add("BloodThirster"+ args[1]);
						ItemStack item=new ItemSmith().makeEffectItem(player.getItemInHand().getType(), player.getItemInHand().getItemMeta().getDisplayName(), lore, 1); 
						
						player.setItemInHand(item);
						
						player.sendMessage("Your command was recognized" +player.getItemInHand().getItemMeta().getLore().toString());
						return true;
					
				}
				else 
				{
					player.sendMessage("Your command was not recognized");
					return true;
				}
					
				
			default:
				player.sendMessage("Your command was not recognized");
				return true;	
				
		}*/
	}
	public static boolean addLore(Player player, String desc, String level)
	{
		ArrayList lore;
		if(player.getItemInHand().getItemMeta().hasLore())
		{
				lore=(ArrayList) player.getItemInHand().getItemMeta().getLore();
		}
		else lore=new ArrayList();
		lore.add(desc+ level);
		ItemStack item=new ItemSmith().makeEffectItem(player.getItemInHand().getType(), player.getItemInHand().getItemMeta().getDisplayName(), lore, player.getItemInHand().getItemMeta().getAttributeModifiers(), player.getItemInHand().getItemMeta().getEnchants(),  1); 
		
		player.setItemInHand(item);
		
		player.sendMessage("Your command was recognized" +player.getItemInHand().getItemMeta().getLore().toString());
		return true;
	}
}
