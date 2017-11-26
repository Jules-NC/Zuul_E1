package pkg_commands;

import pkg_core.Player;
import pkg_core.TransporterRoom;
import pkg_core.Room;

public class AleaCommand extends Command
{

    public AleaCommand()
    {
    }

    public void execute (Player player){
        //if(player.getRoom() instanceof TransporterRoom)
        try{
            Room r = player.getRoom();
            TransporterRoom.setAleaRoom(r);
        }
        catch(Exception e){
            player.getGameEngine().getGui().println("Impossible");
        }
    }
}
