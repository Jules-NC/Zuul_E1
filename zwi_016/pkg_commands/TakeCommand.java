package pkg_commands;

import pkg_core.Player;
import pkg_core.Item;

public class TakeCommand extends Command
{

    public TakeCommand()
    {
    }
    
    public void execute (Player player){
        player.getGameEngine().getGui().println(player.take(secondWord));
    }
}
