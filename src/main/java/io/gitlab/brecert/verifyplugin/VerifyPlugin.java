package io.gitlab.brecert.verifyplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class VerifyPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
    		// Safely generate config if none.
    		saveDefaultConfig();
        getCommand("verify").setExecutor(new VerifyCommand(this));
    }
}
