import java.util.StringTokenizer;
import java.util.Scanner;

/**
 * This class is part of the "TelePac" application. 
 * "TelePac" is a very simple, text based adventure game.  
 * 
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author  Michael Kolling and David J. Barnes + D.Bureau + Guillaume Legrain
 * @version 2008.03.30 + 2013.09.15 + 2013.12.16
 */
public class Parser 
{
    private CommandWords aValidCommands;  // holds all valid command words
    //private Scanner      aReader;         // source of command input

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() 
    {
        this.aValidCommands = new CommandWords();
        //this.aReader        = new Scanner( System.in );
    } // Parser()

    /**
     * @return The next command from the user using command prompt.
     * @deprecated Use GUI version instead
     * 
     */
    // TODO: implement for text based version
    public Command getCommand() 
    {
        System.out.print( "> " );  // print prompt
        return this.getCommand( (new Scanner(System.in)).nextLine() );
    }
    
    /**
     * @return The next command from the user.
     */
    public Command getCommand(final String pInputLine) 
    {
        //String vInputLine;   // will hold the full input line
        String vWord1 = null;
        String vWord2 = null;

        //System.out.print( "> " );  // print prompt

        //vInputLine = this.aReader.nextLine();

        // Find up to two words on the line.
        //Scanner vTokenizer = new Scanner( vInputLine );
        StringTokenizer vTokenizer = new StringTokenizer(pInputLine);
        
        if ( vTokenizer.hasMoreTokens() ) {
            vWord1 = vTokenizer.nextToken();      // get first word
            if ( vTokenizer.hasMoreTokens() ) {
                vWord2 = vTokenizer.nextToken();  // get second word
                // note: we just ignore the rest of the input line.
            } // if
        } // if

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).
        if ( this.aValidCommands.isCommand( vWord1 ) ) {
            return new Command( this.aValidCommands.getCommandWord(vWord1), vWord2 );
        }
        else {
            return new Command( null, null ); 
        }
    } // getCommand()
    
    /**
     *get commands come from aValidCommands 
     */
    public String getCommands()
    {
        return this.aValidCommands.getCommandList();
    }

} // Parser
