package pkg_commands;

import pkg_core.Player;
import pkg_engine.GameEngine;

public class WinCommand extends Command
{

    public WinCommand(){}

    public void execute (Player player){
        player.getGameEngine().getGui().println("+++perdu+++c'est la fin+++je meurs+++");
        player.setWin();
        player.getGameEngine().endGame();
        //player.getGameEngine().getGui().showImage("Images/win.jpg");
    }
}
