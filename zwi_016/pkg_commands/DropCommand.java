package pkg_commands;

import pkg_core.Player;
import pkg_core.Item;
public class DropCommand extends Command
{

    public DropCommand()
    {
    }
    
    public void execute (Player player){
        player.getGameEngine().getGui().println(player.drop(secondWord));
    }
}
