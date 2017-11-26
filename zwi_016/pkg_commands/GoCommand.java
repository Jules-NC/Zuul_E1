package pkg_commands;

import pkg_core.Player;
import pkg_core.Room;

public class GoCommand extends Command{

    public void execute(Player player){
        if(hasSecondWord() == false)
            player.getGameEngine().getGui().println("+++tentative d'exécution+++tentative échouée+++cause+++pas de destination+++");

        Room nextRoom = player.getRoom().getExit(secondWord);
        if (nextRoom == null)
            player.getGameEngine().getGui().println("+++execution+++erreur+++impossible de trouver+++la sortie demandée+++");
        else {
            player.setRoom(nextRoom);
            if(nextRoom.isTrap())
                player.cutStack();
            //System.out.println("TRAP");

            if(player.hasLoose() == false)
                player.getGameEngine().getGui().println(player.getRoom().getLongDescription());
        }

        if(player.getRoom().getImageName() != null && player.hasLoose() == false)
            player.getGameEngine().getGui().showImage(player.getRoom().getImageName());
    }
}