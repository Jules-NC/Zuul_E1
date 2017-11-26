package pkg_commands;

import pkg_core.Player;

public class BackCommand extends Command
{

    public BackCommand()
    {
    }
    
    public void execute (Player player){
        player.getGameEngine().getGui().println(player.back());
    }
}
