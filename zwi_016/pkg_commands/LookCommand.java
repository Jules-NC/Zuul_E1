package pkg_commands;

import pkg_core.Player;

public class LookCommand extends Command
{

    public LookCommand()
    {
    }
    
    public void execute (Player player){
        player.getGameEngine().getGui().println(player.getRoom().getLongDescription());
    }
}
