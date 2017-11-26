package pkg_commands;

import pkg_core.Player;
public class UseCommand extends Command
{

    public UseCommand()
    {
    }
    
    public void execute (Player player){
        player.getGameEngine().getGui().println(player.use(secondWord));
    }
}