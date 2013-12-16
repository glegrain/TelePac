import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

/**
 * The Game engine !!!
 * 
 * Controller ??
 * The controller is bound to the view. This typically means that any user actions 
 * that are performed on the view will invoke a registered listener method in the 
 * controller class.
 * The controller is given a reference to the underlying model. 
 * 
 * After a view called the appropriate controller:
 * The controller accesses the model, 
 * possibly updating it in a way appropriate to the user's action.
 * 
 * In some architectures, the controller may also be responsible for updating the view.
 * 
 * Modern MVC:
 * ==> the controller mediates the flow of data between model and view objects in both directions.
 * If the model has been altered, it notifies interested listeners of the change. 
 * However, in this case, the change is sent to the controller.
 * 
 * @author Guillaume Legrain 
 * & Florian Martin & Michael Kolling and David J. Barnes
 * @version 2013-10-05
 * 
 */
public class GameEngine extends Observable implements Observer
{
    private Parser aParser;
    private UserInterface aGui;

    private GameModel aGameModel; //The controller is given a reference to the underlying model.
    private PlayerModel aPlayer;
    private TextView aTextView;

    /**
     * GameEngine constructor
     * @param pCurrentRoom The current room
     */
    public GameEngine()
    { 
        this.aGameModel = new GameModel(this);
        this.aParser = new Parser();
        this.aPlayer = this.aGameModel.getPlayer();
        //this.createRooms(); //Rooms are created in the gameModel
    }

    public void setGUI(UserInterface pUserInterface)
    {
        this.aGui = pUserInterface;
        //printWelcome();
        //this.aGui.addObserver(this.aGui);
        // TODO many methods described in TextView aren't call when using the GUI
        this.aGui.showImage(aGameModel.getCurrentRoom().getImageName()); // Should be done automatically
        //aTextView.printWelcome();  // Model changed so view should listen
    }

    public void setTextView()
    {
        this.aTextView = new TextView(this.aGameModel);
        this.aGameModel.addObserver(this);
        this.addObserver(this.aTextView);
        setChanged();
        notifyObservers("TextView ENABLED");
        aTextView.printWelcome(); // DRY !!!
    }

    /**
     * Universal print method, works with all views
     */
    private void print(final String pString)
    {
        // TODO remove hardcoded views
        if (this.aGui != null) {
            this.aGui.print(pString);
        }
        if (this.aTextView != null) { 
            this.aTextView.show(pString);
        }
    }

    /**
     * Universal println method, works with all views
     */
    private void println()
    {
        // TODO remove hardcoded views
        if (this.aGui != null) {
            this.aGui.println();
        }
        if (this.aTextView != null) { 
            this.aTextView.showln();
        }
    }

    /**
     * Universal println method, works with all views
     */
    private void println(final String pString)
    {
        // TODO remove hardcoded views
        if (this.aGui != null) {
            this.aGui.println(pString);
        }
        if (this.aTextView != null) { 
            this.aTextView.showln(pString);
        }
    }

    /**
     * Check valid direction and define the new current position
     * @param pCommand
     */
    public void goRoom(final Command pCommand)
    {
        if (!pCommand.hasSecondWord() ) {
            println("Go Where ?");
            return;
        }

        String vDirection = pCommand.getSecondWord();

        Room vNextRoom = aGameModel.getCurrentRoom().getExit(vDirection);
        if (vNextRoom == null) {
            println("There is a wall !");
        } else {
            this.aGameModel.goRoom(vNextRoom);
            // You have no changed room, rename vNextRoom to vCurrentRoom
            Room vCurrentRoom = vNextRoom; 
            // this.printLocationInfo(vCurrentRoom);  // update() ??
            if(vCurrentRoom.getImageName() != null) {
                aGui.showImage(vCurrentRoom.getImageName());
            }
        }
    }

    //     /**
    //      * print welcome message
    //      */
    //     private void printWelcome()
    //     {
    //         aGui.println( aGameModel.getWelcomeString() );
    //         aGui.println();
    //         this.printLocationInfo(this.aCurrentRoom);
    //         this.aGui.showImage(aCurrentRoom.getImageName());
    //         aTextView.showln();
    //     }
    // 
    //     /**
    //      * Displays the possible exits for a given room and the name of the current room.
    //      * @param Room
    //      */
    //     private void printLocationInfo(final Room pRoom)
    //     {
    //         aTextView.showln();
    //         aTextView.showln(aCurrentRoom.getLongDescription());
    //         aTextView.showln();
    //     }

    /**
     * Print help message and show available commands 
     */
    private void printHelp()
    {
        println();
        println(aGameModel.getHelpString());
        println("Possible commands are:");
        println(aParser.getCommands());
        println();
    }

    /**
     * define the end of the game
     * @parma pCommand
     * @return boolean 
     */
    private boolean quit(final Command pCommand)
    {

        if (pCommand.hasSecondWord()) {
            println("Quit what ?");
            return false;
        }
        return true;
    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    public void interpretCommand(final String pCommandLine) 
    {
        //TODO: println(pCommandLine);
        Command vCommand = aParser.getCommand(pCommandLine);

        // boolean wantToQuit = false;
        CommandWord vCommandWord = vCommand.getCommandWord();

        if(vCommandWord == CommandWord.UNKNOWN) {
            setChanged();
            notifyObservers("Invalid command. I don't know what you mean...");
            //println("I don't know what you mean...");
            return;
            // return false;
        }

        //String vCommandWord = vCommand.getCommandWord();
        switch ( vCommandWord ) {
            case HELP :     
            this.printHelp();
            break;
            case GO :       
            this.goRoom(vCommand);
            break;
            case LOOK :     
            this.look();
            break;
            case ITEMS :    
            this.items();
            break;
            case EAT :      
            this.eat(vCommand);
            break;
            case TEST :     
            this.test(vCommand);
            break;
            case TAKE :     
            this.take(vCommand);
            break;
            case DROP :     
            this.drop(vCommand);
            break;
            case BACK :     
            this.goBack();
            break;
            case QUIT  :    
            //wantToQuit = quit(pCommandLine);
            this.endGame();
            break;
            default:
            // else command not recognised.
            // return wantToQuit;
            break;
        }

        // if        (vCommandWord == CommandWord.HELP)  {
        //     this.printHelp();
        // } else if (vCommandWord == CommandWord.GO)    {
        //     this.goRoom(vCommand);
        // } else if (vCommandWord == CommandWord.LOOK)  {
        //     this.look();
        // } else if (vCommandWord == CommandWord.ITEMS) {
        //     this.items();
        // } else if (vCommandWord == CommandWord.EAT)   {
        //     this.eat(vCommand);
        // } else if (vCommandWord == CommandWord.TEST)  {
        //     this.test(vCommand);
        // } else if (vCommandWord == CommandWord.TAKE)  {
        //     this.take(vCommand);
        // } else if (vCommandWord == CommandWord.DROP)  {
        //     this.drop(vCommand);
        // } else if (vCommandWord == CommandWord.BACK)  {
        //     this.goBack();
        // } else if (vCommandWord == CommandWord.QUIT)  {
        //     // wantToQuit = quit(pCommandLine);
        //     this.endGame();
        // }
        //         } else if (vCommandWord.equals("back") && this.back(vCommand)) {
        //             this.goBack();
        //         } else if (vCommandWord.equals("quit") && this.quit(vCommand)) {
        //             this.endGame();
        //        }

        // else command not recognised.
        // return wantToQuit;
    }

    private void endGame()
    {
        println(aGameModel.getGoodByeString());
        aGui.enable(false);
    }

    public void look()
    {
        println();
        println(this.aGameModel.getCurrentRoom().getLongDescription());
    }

    public void items()
    {
        println();
        println(this.aGameModel.getPlayer().getItemsInPossesion());
    }

    public void eat(final Command pCommand)
    {
        // TODO
        if (!pCommand.hasSecondWord()) {
            println("eat what ?");
            return;
        }

        String vItemName = pCommand.getSecondWord();

        println(this.aGameModel.take(vItemName));
    }

    public Boolean back(final Command pCommand) {
        if (pCommand.hasSecondWord()) {
            println("Back what ?");
            return false;
        }

        //TODO: GameModel should notify there is no previous room.
        //         if (this.aPreviousRoom.empty()) {
        //             println("I can't go back any futher !");
        //             return false;
        //         }

        return true;
    }

    private void goBack()
    {
        this.aGameModel.goBack();

        // TODO: Use getExit from the Room class
        //this.aCurrentRoom = this.aPreviousRoom.pop();;
        // this.printLocationInfo(this.aCurrentRoom);
        if(aGameModel.getCurrentRoom().getImageName() != null) {
            aGui.showImage(aGameModel.getCurrentRoom().getImageName());
        }
    }

    private void test(final Command pCommand)
    {
        if (!pCommand.hasSecondWord()) {
            println("Test what ?");
            return;
        }

        Test vTest = new Test( pCommand.getSecondWord(), this );
    }

    private void take(final Command pCommand)
    {
        if (!pCommand.hasSecondWord()) {
            println("take what ?");
            return;
        }

        String vItemName = pCommand.getSecondWord();

        println(this.aGameModel.take(vItemName));
    }

    private void drop(final Command pCommand)
    {
        if (!pCommand.hasSecondWord()) {
            println("drop what ?");
            return;
        }

        String vItemName = pCommand.getSecondWord();

        println(this.aGameModel.drop(vItemName));
    }

    // DEBUG METHOD //
    @Override
    public void update(Observable o, Object arg)
    {
        println("Something Changed !!! arg:" + arg);
        //System.out.println ("View      : Observable is " + o.getClass() + ", object passed is " + arg.getClass());
        //model Pull 
        //ignore obj and ask model for value
        //System.out.println("" + aGameModel.getCurrentRoom());
    }
}