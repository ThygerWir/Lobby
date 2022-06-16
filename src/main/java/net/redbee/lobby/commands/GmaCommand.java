package net.redbee.lobby.commands;

import net.redbee.lobby.Lobby;
import net.redbee.lobby.commands.constructor.AbstractCommand;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.redbee.lobby.Lobby.PREFIX;

public class GmaCommand extends AbstractCommand {
    public GmaCommand() {
        super("gma");
    }

    @Override
    public void execute(CommandSender sender, String label, String[] args) {

        // Присваиваем игроку отправителя.
        Player player = (Player) sender;

        // Проверяем наличие у игрока режима, который он хочет получить.
        if (player.getGameMode() == GameMode.ADVENTURE) {

            // Отсылаем сообщение об уже установленном режиме игры.
            player.sendMessage(PREFIX + Lobby.getMessage("COMMANDS.GM_ALREADY"));
        return;
        }

        // Проверяем наличие права у игрока
        if (player.hasPermission("redlobby.gma")) {

            // Выдаём ему игровой режим
            player.setGameMode(GameMode.ADVENTURE);
            // Отсылаем сообщение об успешной выдаче
            player.sendMessage(PREFIX + Lobby.getInstance().getConfig().getString("COMMANDS.GMA_SUCCESS"));

        // Во всех остальных случаях будет высылаться сообщение о нехватке прав
        } else {

            player.sendMessage(PREFIX + Lobby.getInstance().getConfig().getString("COMMON.NO_PERMS"));

        }
    }
}