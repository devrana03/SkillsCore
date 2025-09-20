package com.valer.skillsplugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LightningSkill implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage(player.getLocation().toString());
            System.out.println(player.getLocation().toString());
            blockPlaceTwo(player.getLocation());
        }
        return false;
    }


    public void blockPlaceTwo(Location loc) {
        for (double t = 0, radius = 10; t <= 360 && radius >= 0; t += 1) {
            double r = Math.toRadians(t);
            double x = (Math.cos(r) * radius + loc.getX());
            double z = (Math.sin(r) * radius + loc.getZ());
            Block block = Bukkit.getWorld("world").getBlockAt((int) x, (int)loc.getBlockY(), (int)z);
            block.setType(Material.DIAMOND_BLOCK);
            if (t == 360) {
                t = 0;
                radius--;
            }
        }
    }

    }

