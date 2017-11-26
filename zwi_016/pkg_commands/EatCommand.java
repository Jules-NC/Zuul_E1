package pkg_commands;

import pkg_core.Player;

public class EatCommand extends Command
{

    public EatCommand()
    {
    }
    
    public void execute (Player player){
        player.getGameEngine().getGui().println(player.eat());
    }
}
