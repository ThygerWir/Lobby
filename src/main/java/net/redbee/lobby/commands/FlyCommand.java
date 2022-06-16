package net.redbee.lobby.commands;

import net.redbee.lobby.Lobby;
import net.redbee.lobby.commands.constructor.AbstractCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.redbee.lobby.Lobby.PREFIX;

public class FlyCommand extends AbstractCommand {

    public FlyCommand() {
        super("fly");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {

        Player player = (Player) sender;

        // Проверяем наличие прав у игрока
        if (player.hasPermission("redlobby.fly")) {

            player.setAllowFlight(!player.getAllowFlight());
            player.sendMessage(PREFIX + Lobby.getMessage("COMMANDS.FLY_SUCCESS") + (player.getAllowFlight() ? "§aВкл" : "§cВыкл"));

        // Во всех остальных случаях будет высылаться сообщение о нехватке прав
        } else {

            player.sendMessage(PREFIX + Lobby.getMessage("COMMON.NO_PERMS"));

        }
    }
}
