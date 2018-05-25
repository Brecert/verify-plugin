package io.gitlab.brecert.verifyplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class VerifyPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("verify").setExecutor(new VerifyCommand(this));
    }
}
