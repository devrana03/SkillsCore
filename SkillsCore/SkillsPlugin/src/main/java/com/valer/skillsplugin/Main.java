package com.valer.skillsplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("locatest").setExecutor(new LightningSkill());

    }

}
