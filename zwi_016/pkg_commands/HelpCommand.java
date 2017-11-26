package pkg_commands;

import pkg_core.Player;

public class HelpCommand extends Command{
    private CommandWords commandWords;
    public HelpCommand(CommandWords words){
        commandWords = words;
    }
    
    public void execute(Player player){
        player.getGameEngine().getGui().println(commandWords.showAll());
    }
}