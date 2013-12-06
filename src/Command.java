
/**
 * Command.java
 */

/**
 * @author Guillaume Legrain
 * @version %I%, %G%
 *
 */
public class Command {

	private String aCommandWord;
	private String aSecondWord;
	
	/**
	 * Create a command object.
	 * @param aCommandWord
	 * @param aSecondWord
	 */
	public Command(final String pCommandWord, final String pSecondWord) {
		this.aCommandWord = pCommandWord;
		this.aSecondWord = pSecondWord;
	}
	
	/**
	 * @return the aCommandWord
	 */
	public String getaCommandWord() {
		return aCommandWord;
	}

	/**
	 * @return the aSecondWord
	 */
	public String getaSecondWord() {
		return aSecondWord;
	}

	/**
     * Return true if this command was not understood.
     */
    public boolean isUnknown()
    {
        return (aCommandWord == null);
    }
	
	/**
     * Return true if the command has a second word.
     */
	public boolean hasSecondWord(){
		return (aSecondWord != null);
	}
	
}
