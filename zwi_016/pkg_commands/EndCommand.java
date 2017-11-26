package pkg_commands;

import pkg_core.Player;
import pkg_engine.GameEngine;

public class EndCommand extends Command
{

    public EndCommand(){}

    public void execute (Player player){
        player.getGameEngine().getGui().println("+++perdu+++c'est la fin+++je meurs+++");
        player.getGameEngine().endGame();
        //player.getGameEngine().getGui().showImage("Images/win.jpg");
    }
}
