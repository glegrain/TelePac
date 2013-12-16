/**
 * Representations for all the valid command words for the game
 * along with a string in a particular language.
 * 
 * @author Michael Kolling and David J. Barnes + Guillaume Legrain
 * @version 2006.03.30 + 2013.12.16
 */
public enum CommandWord
{
    // A value for each command word along with its
    // corresponding user interface string.
    GO("go"), QUIT("quit"), HELP("help"), LOOK("look"), EAT("eat"),
    BACK("back"), TEST("test"), TAKE("take"), DROP("drop"),
    ITEMS("items"), UNKNOWN("?");
    
     // The command string.
    private String aCommandString;
    
    /**
     * Initialise with the corresponding command word.
     * @param commandWord The command string.
     */
    CommandWord(final String pCommandString)
    {
        this.aCommandString = pCommandString;
    }
    
    /**
     * @return The command word as a string.
     */
    @Override
    public String toString()
    {
        return aCommandString;
    }
}