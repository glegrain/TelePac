import java.util.Observable;
import java.util.Observer;

/**
 * TextView is a textual view of the Zuul game. It prints out texts to the 
 * screen.
 * 
 * "The view registers as a listener on the model" oracle.com
 * 
 * @author Poul Henriksen & Guillaume Legrain
 * @version  1.0 (February 2005) - October 2013
 */
public class TextView implements Observer
{
    private GameModel aGameModel;

    public TextView(final GameModel pGameModel)
    {
        this.aGameModel = pGameModel;
    }

    public void printWelcome()
    {
        show("\n" + aGameModel.getWelcomeString() + "\n");
        printLocationInfo();
    }

    private void printLocationInfo()
    {
        show(aGameModel.getLocationInfoString());
    }

    public void printGoodBye() 
    {
        show(aGameModel.getGoodByeString());
    }

    public void printHelp()
    {
        show(aGameModel.getHelpString());
    }

    public void show(String pString) 
    {
        System.out.println( pString);
    }

    public void showln(String pString)
    {
        System.out.println(pString);
    }
    
    public void showln()
    {
        System.out.println();
    }

    public void update(Observable o, Object arg)
    {
        System.out.println("UPDATE: " + arg);
        printLocationInfo();
    }
}
