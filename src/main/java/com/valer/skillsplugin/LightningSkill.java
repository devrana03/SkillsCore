package com.valer.skillsplugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class LightningSkill implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
           List<Location> locations = blockPlaceTwo(player.getLocation());
           mobTracker((Player)sender, locations);
        }
        return false;
    }


    public List<Location> blockPlaceTwo(Location loc) {
        List<Location> locations = new ArrayList<>();

        for (double t = 0, radius = 10; t <= 360 && radius >= 0; t += 1) {
            double r = Math.toRadians(t);
            double x = (Math.cos(r) * radius + loc.getX());
            double z = (Math.sin(r) * radius + loc.getZ());

            Location location = new Location(loc.getWorld(), Math.round(x), Math.round(loc.getY()), Math.round(z));
            Location location1 = new Location(loc.getWorld(), Math.round(x), Math.round(loc.getY())+1, Math.round(z));
            Location location2 = new Location(loc.getWorld(), Math.round(x), Math.round(loc.getY())+2, Math.round(z));
            if (!locations.contains(location)) {
                locations.add(location);
                System.out.println(location + " added to list!");
            }
            if (!locations.contains(location1)) {
                locations.add(location1);
                System.out.println(location1 + " added to list!");
            }
            if (!locations.contains(location2)) {
                locations.add(location2);
                System.out.println(location2 + " added to list!");
            }
            for (Location block : locations) {
                Block newBlock = block.getWorld().getBlockAt(block);
                newBlock.setType(Material.DIAMOND_BLOCK);
            }
            if (t >= 360) {
                t = 0;
                radius--;
            }
        }
        System.out.println("Amount of blocks added: " + locations.size());
        return locations;
    }

    public void mobTracker(Player player, List<Location> blocks) {

    }










    public void blockPlaceThree(Location loc) {
        for (double t = 90, radius = 10; t <= 270 && radius >= 0; t += 1) {
            double r = Math.toRadians(t);
            double x = (Math.cos(r) * radius + loc.getX());
            double z = (Math.sin(r) * radius + loc.getZ());
            Block block = Bukkit.getWorld("world").getBlockAt((int) Math.round(x), (int) Math.round(loc.getBlockY()), (int) Math.round(z));
            block.setType(Material.DIAMOND_BLOCK);
            if (t >= 270) {
                t = 90;
                radius--;
            }
        }

    }
}

