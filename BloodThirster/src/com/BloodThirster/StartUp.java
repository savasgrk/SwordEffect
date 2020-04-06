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
					return Commands.giveSword(args, player);
				case "effectsword":
					return Commands.effectSword(args, player);					
				default:
					player.sendMessage("Your command was not recognized");
					return true;
			
			}
		}
		player.sendMessage("Your command was not recognized");
		return true;
	}
}
