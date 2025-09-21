package com.valer.skillsplugin;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;

public class EntityTrack implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            List<Entity> entityList = player.getNearbyEntities(5, 2, 5);
            if (entityList.size() == 0) {
                player.sendMessage(ChatColor.RED + "There are no nearby entities!");
            }
            for (Entity entity : entityList) {
                player.sendMessage(entity.getName());
                for (int i = 0; i < 5; i++){
                    entity.getWorld().strikeLightning(entity.getLocation());
                }
                }
            }
        return false;
    }
}
