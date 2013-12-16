import java.util.HashMap;

/**
 * This class is part of the "TelePac" application. 
 * "TelePac" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau + Guillaume Legrain
 * @version 2008.03.30 + 2013.11.20 + 2013.12.16
 */
public class CommandWords
{
     // A mapping between a command word and the CommandWord
    // associated with it.
    private HashMap<String, CommandWord> aValidCommands;
    // a constant array that holds all valid command words
//     private static final String[] sValidCommands = {
//             "go", "quit", "help","look","eat","back","test","take", "drop", "items"
//     };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        this.aValidCommands = new HashMap<String, CommandWord>();
        this.aValidCommands.put("go", CommandWord.GO);
        this.aValidCommands.put("quit", CommandWord.QUIT);
        this.aValidCommands.put("help", CommandWord.HELP);
        this.aValidCommands.put("look", CommandWord.LOOK);
        this.aValidCommands.put("eat", CommandWord.EAT);
        this.aValidCommands.put("back", CommandWord.BACK);
        this.aValidCommands.put("test", CommandWord.TEST);
        this.aValidCommands.put("take", CommandWord.TAKE);
        this.aValidCommands.put("drop", CommandWord.DROP);
    } // CommandWords()

    /**
     * Find the CommandWord associated with a command word.
     * @param commandWord The word to look up.
     * @return The CommandWord correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public CommandWord getCommandWord(final String pCommandWord)
    {
        CommandWord vCommand = this.aValidCommands.get(pCommandWord);
        if(vCommand != null) {
            return vCommand;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }
    
    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(final String pString )
    {
//         for ( int i=0; i<sValidCommands.length; i++ ) {
//             if ( sValidCommands[i].equals( pString ) )
//                 return true;
//         } // for
//         // if we get here, the string was not found in the commands
//         return false;
        return this.aValidCommands.containsKey(pString);
    } // isCommand()

    /**
     * get all valid commands in a single String.
     * @return String
     */
    // TODO: use StringBuilder
    public String getCommandList()
    {
        String vCommandList = "";
        for(String vCommand : this.aValidCommands.keySet()) {
            vCommandList += vCommand + " ";
        }
        return vCommandList;
    } //getCommandList()
} // CommandWords
