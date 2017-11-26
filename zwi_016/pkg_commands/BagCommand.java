package pkg_commands;

import pkg_core.Player;
public class BagCommand extends Command
{

    public BagCommand()
    {
    }
    
    public void execute (Player player){
        player.getGameEngine().getGui().println(player.getItemList().desc()+"\nMax-Poids: "+player.pdsCourr());
    }
}
