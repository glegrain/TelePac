
/**
 * Write a description of class Command here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Command
{
    private String aCommandWord;
    private String aSecondWord;
    
    /**
     * Constructor - initialise the command words.
     * @param pCommandWord First word enter as a command
     * @param pSecondWord Second word enter 
     */
    public Command(final String pCommandWord, final String pSecondWord)
    {
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;
    }
    
    /**
     * Constructor - initialise the command words.
     * @param pCommandWord First word enter as a command
       */
    public Command(final String pCommandWord)
    {
        this.aCommandWord = pCommandWord;
        this.aSecondWord = null;
    }
    
    /**
     * Accessor - return first word
     * @return aCommandWord
     */
    public String getCommandWord() { return this.aCommandWord;}
    
    /**
     * Accessor - return second word
     * @return aSecondWord
     */
    public String getSecondWord() { return this.aSecondWord;}
    
    /**
     * Check if the command has a second word
     * @return boolean
     */
    public boolean hasSecondWord() { return !(this.aSecondWord == null);}
    
    /**
     * Check if the command is not valid
     * @return boolean
     */
    //TODO: Cleanup hardcoded commands!
    public boolean isUnknown()
    {
        return (this.aCommandWord == null);
    }
}
