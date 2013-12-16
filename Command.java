
/**
 * This class is part of the "TelePac" application. 
 * "TelePac" is a very simple, text based adventure game.  
 *
 * This class holds information about a command that was issued by the user.
 * A command currently consists of two parts: a CommandWord and a string
 * (for example, if the command was "take map", then the two parts
 * are TAKE and "map").
 * 
 * The way this is used is: Commands are already checked for being valid
 * command words. If the user entered an invalid command (a word that is not
 * known) then the CommandWord is UNKNOWN.
 *
 * If the command had only one word, then the second word is <null>.
 * 
 * @author  Michael Kolling and David J. Barnes + Guillaume Legrain
 * @version 2006.03.30 + 2013.12.16
 */
public class Command
{
    private CommandWord aCommandWord;
    private String aSecondWord;
   // private String aCommandWord;
    
    /**
     * Create a command object. First and second words must be supplied, but
     * the second may be null.
     * @param commandWord The CommandWord. UNKNOWN if the command word
     *                  was not recognised.
     * @param secondWord The second word of the command. May be null.
     */
    public Command(final CommandWord pCommandWord, final String pSecondWord)
    {
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;
    }
    
    /**
     * Constructor - initialise the command words.
     * @param pCommandWord First word enter as a command
       */
    public Command(final CommandWord pCommandWord)
    {
        this.aCommandWord = pCommandWord;
        this.aSecondWord = null;
    }
    
    /**
     * Accessor - return first word
     * @return aCommandWord The command word.
     */
    public CommandWord getCommandWord() { return this.aCommandWord;}
    
    /**
     * Accessor - return second word
     * @return aSecondWord The second word of this command. Returns null if there was no
     * second word.
     */
    public String getSecondWord() { return this.aSecondWord;}
    
    /**
     * Check if the command has a second word
     * @return boolean 
     */
    public boolean hasSecondWord() { return this.aSecondWord != null;}
    
    /**
     * Check if the command is not valid
     * @return boolean true if this command was not understood.
     */
    public boolean isUnknown()
    {
        return (this.aCommandWord == CommandWord.UNKNOWN);
    }
}
