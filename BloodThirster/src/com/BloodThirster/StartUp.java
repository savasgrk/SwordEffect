package com.BloodThirster;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class StartUp extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		getLogger().info("Hellowworld2 has been enabled");
		PluginManager pm=getServer().getPluginManager();
		BTListener listener= new BTListener(this);
		pm.registerEvents(listener, this);

	}
	@Override
	public void onDisable()
	{
		getLogger().info("helloworld has been disabled");
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		Player player =(Player) sender;
		if(sender instanceof Player)
		{
			
			String lowerCmd= cmd.getName().toLowerCase();
			switch(lowerCmd)
			{
				case "givesword":
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
						}
						else if(args.length==0)
						{	
							Inventory inv=player.getInventory();
							ItemStack item=new ItemSmith().buildWeapon(1);
							inv.addItem(item);
						}	
						
						else
						{
							player.sendMessage("Your command was not recognized");
							return true;
						}
						return true;
					}
				case "effectsword":
					if(args!=null)
					{
						if(args[0].equals("bloodthirster"))
						{
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
								
						}
						player.sendMessage("Your command was not recognized, args[0]!=BloodThirster equals " + args[0]);
						return true;
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
					
				default:
					player.sendMessage("Your command was not recognized");
					return true;
			
			}
		}
		player.sendMessage("Your command was not recognized");
		return true;
	}
}
