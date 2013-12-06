
/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau + Guillaume Legrain
 * @version 2008.03.30 + 2013.11.20
 */
public class CommandWords
{
    // a constant array that holds all valid command words
    private static final String[] sValidCommands = {
            "go", "quit", "help","look","eat","back","test","take", "drop", "items"
    };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    } // CommandWords()

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand( final String pString )
    {
        for ( int i=0; i<sValidCommands.length; i++ ) {
            if ( sValidCommands[i].equals( pString ) )
                return true;
        } // for
        // if we get here, the string was not found in the commands
        return false;
    } // isCommand()

    /**
     * get all valid commands in a single String.
     * @return String
     */
    // TODO: use StringBuilder
    public String getCommandList()
    {
        String vCommandList = "";
        for(String vCommand : sValidCommands) {
            vCommandList += vCommand + " ";
        }
        return vCommandList;
    } //getCommandList()
} // CommandWords
