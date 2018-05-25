package io.gitlab.brecert.verifyplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;


public class VerifyCommand implements CommandExecutor {
    VerifyPlugin plugin;

    public VerifyCommand(VerifyPlugin plugin) { this.plugin = plugin; }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player;
        java.util.UUID uuid;
        try {
            player = (Player) sender;
            uuid = player.getUniqueId();
        }
        catch (Exception e) {
            // player = null;
            // uuid = null;

            sender.sendMessage("This command must be issued by a player.");
            return true;
        }

        // Make sure min args are met.
        // TODO: Find a better way to do this.
        if (args.length < 1) {
            sender.sendMessage("Usage:");
            sender.sendMessage("verify <key>");

            return true;
        }

        String code;
        try {
            code = plugin.getConfig().getString(uuid.toString());
            if(code.equals(args[0])) {
                sender.sendMessage("Match!");
            }
            else {
                sender.sendMessage("No match.");
            }
        }
        // Todo: Actually specify the error, please..
        catch (Exception err) {
            sender.sendMessage("User does not exist..");
        }

        return true;
    }
}
