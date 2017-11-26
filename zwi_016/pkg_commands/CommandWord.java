package pkg_commands;
public enum CommandWord
{
    // A value for each command word along with its
    // corresponding user interface string.
    GO("go"), QUIT("quit"), HELP("help"),EAT("eat"),LOOK("look"),BACK("back"),TEST("test"),TAKE("take"),DROP("drop"),WIN("win"), BAG("bag"),CHARGE("charge"),USE("use"), INTERRACT("interract"), ALEA("alea"), END("end"), UNKNOWN("?");
    
    // The command string.
    private String commandString;
    
    /**
     * Initialise with the corresponding command word.
     * @param commandWord The command string.
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return commandString;
    }
}
