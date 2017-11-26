package pkg_commands;

import pkg_core.Player;
import pkg_engine.GameEngine;

public class QuitCommand extends Command
{

    public QuitCommand()
    {
    }

    public void execute (Player player){
        if(!hasSecondWord()){
            
            player.getGameEngine().getGui().println("+++quittage+++reprise du début+++");
            player.getGameEngine().endGame();
        }
        player.getGameEngine().getGui().println("+++impossible de traiter la demande+++je calcule+++");
    }
}
