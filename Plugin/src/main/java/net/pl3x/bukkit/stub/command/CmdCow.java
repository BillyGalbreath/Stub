package net.pl3x.bukkit.stub.command;

import net.pl3x.bukkit.stub.Stub;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class CmdCow implements CommandExecutor {
    private final Stub plugin;

    public CmdCow(Stub plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Entity cow = plugin.getNMSHandler().spawnCow(player.getLocation(), player);
            if (cow == null) {
                sender.sendMessage("Unable to summon cow");
            } else {
                sender.sendMessage("Summoned a cow via NMS");
            }
        } else {
            sender.sendMessage("Player only command");
        }
        return true;
    }
}
