package pkg_commands;

import java.util.HashMap;
import pkg_core.Player;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class CommandWords
{
    // A mapping between a command word and the CommandWord
    // associated with it.
    private HashMap<String, CommandWord> validCommands;
    private HashMap<CommandWord, Command> commands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        validCommands = new HashMap<String, CommandWord>();
        for(CommandWord command : CommandWord.values()) {
            if(command != CommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
        commands = new HashMap<CommandWord, Command>();
        commands.put(CommandWord.QUIT, new QuitCommand());
        commands.put(CommandWord.HELP, new HelpCommand(this));
        commands.put(CommandWord.GO, new GoCommand());
        commands.put(CommandWord.EAT, new EatCommand());
        commands.put(CommandWord.LOOK, new LookCommand());
        commands.put(CommandWord.TAKE, new TakeCommand());
        commands.put(CommandWord.DROP, new DropCommand());
        commands.put(CommandWord.BAG, new BagCommand());
        commands.put(CommandWord.USE, new UseCommand());
        commands.put(CommandWord.CHARGE, new ChargeCommand());
        commands.put(CommandWord.BACK, new BackCommand());
        commands.put(CommandWord.TEST, new TestCommand());
        commands.put(CommandWord.INTERRACT, new IntCommand());
        commands.put(CommandWord.ALEA, new AleaCommand());
        commands.put(CommandWord.END, new EndCommand());
        commands.put(CommandWord.WIN, new WinCommand());
    }

    /**
     * Find the CommandWord associated with a command word.
     * @param commandWord The word to look up.
     * @return The CommandWord correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }
    
    /**
     * Check whether a given String is a valid command word. 
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }
    
    /**
     * Print all valid commands to System.out.
     */
    public String showAll() 
    {
        String res = "";
        for(String command : validCommands.keySet()) {
            res += command + " | ";
        }
        return res;
    }
    
    public Command getCommand(CommandWord c){
        return commands.get(c);
    }
    
    public Command getCommand(String s){
        return commands.get(getCommandWord(s));
    }
}
