package net.pl3x.bukkit.stub;

import net.pl3x.bukkit.stub.api.NMSHandler;
import net.pl3x.bukkit.stub.command.CmdCow;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Stub extends JavaPlugin {
    private NMSHandler nmsHandler;

    public NMSHandler getNMSHandler() {
        return nmsHandler;
    }

    @Override
    public void onEnable() {
        String packageName = this.getServer().getClass().getPackage().getName();
        String version = packageName.substring(packageName.lastIndexOf('.') + 1);

        try {
            final Class<?> clazz = Class.forName("net.pl3x.bukkit.stub.nms." + version + ".NMSHandler");
            if (NMSHandler.class.isAssignableFrom(clazz)) {
                nmsHandler = (NMSHandler) clazz.getConstructor().newInstance();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            getLogger().severe("Could not find support for " + version + " server version");
            setEnabled(false);
            return;
        }

        getCommand("cow").setExecutor(new CmdCow(this));

        getLogger().info("Loading nms support for " + version);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("Plugin is disabled. See logs for more information.");
        return true;
    }
}
