package pkg_commands;

import pkg_core.Player;
public class ChargeCommand extends Command
{

    public ChargeCommand()
    {
    }
    
    public void execute (Player player){
        player.getGameEngine().getGui().println(player.charge(secondWord));
    }
}
