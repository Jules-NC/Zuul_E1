package pkg_commands; 

import pkg_core.Player;

public abstract class Command
{
    protected String secondWord;

    /**
     * Create a command object. First and second words must be supplied, but
     * the second may be null.
     * @param commandWord The CommandWord. UNKNOWN if the command word
     *                  was not recognised.
     * @param secondWord The second word of the command. May be null.
     */
    public Command()
    {
        this.secondWord = null;
    }

    /**
     * @return The second word of this command. Returns null if there was no
     * second word.
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    public void setSecondWord(String secondWord)
    {
        this.secondWord = secondWord;
    }

    /**
     * @return true if the command has a second word.
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }

    public abstract void execute(Player player);
}

