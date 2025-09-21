package com.valer.skillsplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        //Skills Testing/Workspace Command
        getCommand("locatest").setExecutor(new LightningSkill());

        //Utility Command || To Get Yaw
        getCommand("yaw").setExecutor(new YawCommand());

        //Utility Command || To Get To Ingame Workspace
        getCommand("workspace").setExecutor(new HomeCommand());

        // Testing Command || Undecided
        getCommand("entitytrack").setExecutor(new EntityTrack());
    }

}
