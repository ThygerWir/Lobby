package net.redbee.lobby;

import net.redbee.lobby.commands.*;
import net.redbee.lobby.listeners.JoinListener;
import net.redbee.lobby.listeners.PadListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Lobby extends JavaPlugin {

    private static Lobby instance;

    private void registerListeners() {

        Bukkit.getPluginManager().registerEvents(new PadListener(), this);
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);

    }

    public static String PREFIX = null;

    @Override
    public void onEnable() {

        instance = this;

        saveDefaultConfig();

        getLogger().info("Loading commands...");

        new CoreCommand();
        new FlyCommand();
        new GmsCommand();
        new GmcCommand();
        new GmaCommand();
        new GmspCommand();

        getLogger().info("Loading listeners...");
        registerListeners();

        PREFIX = getConfig().getString("PREFIX");

        getLogger().info("The plugin was successfully enabled!");

    }

    public static Lobby getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static String getMessage(String key, Object... format) {

        return ChatColor.translateAlternateColorCodes('&', String.format(getInstance().getConfig().getString(key), format));

    }

}
