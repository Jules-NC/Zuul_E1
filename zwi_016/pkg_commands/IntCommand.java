package pkg_commands;

import pkg_core.Player;
import pkg_core.Item;
import pkg_core.Pnj;

public class IntCommand extends Command{
    private CommandWords commandWords;
    
    public IntCommand(){
    }
    
    public void execute(Player player){
        Pnj i = player.getRoom().getPnj(secondWord);
        
        try{
            i.interract(player, i);
        }
        catch(Exception e){
            player.getGameEngine().getGui().println("+++impossible+++manque chevreuil+++");
        }
    }
}