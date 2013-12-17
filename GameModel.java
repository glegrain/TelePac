import java.util.Observable;
import java.util.Stack;
import java.util.HashMap;

/**
 * GameModel represents the model of the game
 * 
 * Note that the model is not aware of the view or the controller--
 * it simply broadcasts change notifications to all interested listeners.
 * It uses an event-notification model to notify interested parties of a change.
 * i.e. GameModel is Observable
 * 
 * If the model has been altered, it notifies interested listeners, such as the view, of the change.
 * In some architectures, the controller may also be responsible for updating the view.
 * 
 * A more recent implementation of the MVC design places the controller between the model and the view.
 * (Apple Cocoa). The primary difference between this design and the more traditional version of MVC 
 * is that the notifications of state changes in model objects are communicated to the view through 
 * the controller. 
 * ==> the controller mediates the flow of data between model and view objects in both directions. 
 * 
 * @author Guillaume Legrain 
 * @version October 2013
 */
public class GameModel extends Observable
{
    // GameModel inherits addObserver() method from Observable
    // to send (change of) status messages to the Controller

    //private Room aCurrentRoom;
    private Stack<Room> aPreviousRoom;
    private HashMap<String,Room> aRooms;
    private PlayerModel aPlayer;
    private GameEngine aGameEngine;

    public GameModel(final GameEngine pGameEngine)
    {
        this.aRooms = new HashMap<String,Room>();
        this.aGameEngine = pGameEngine;
        this.createRooms();
    }

    /**
     * Initialise rooms
     */
    private void createRooms()
    {
        //         //Create Rooms
        //         Room vOutside = new Room("outside the main entrance of the university", "Images/outside.gif");
        //         //aRooms.put("Outside", vOutside);
        //         Room vTheatre = new Room("in a lecture theatre", "Images/castle.gif");
        //         //aRooms.put("Theatre", vTheatre);
        //         Room vPub = new Room("in the campus pub", "Images/courtyard.gif");
        //         //aRooms.put("Pub", vPub);
        //         Room vLab = new Room("in a computing lab", "Images/stairs.gif");
        //         //aRooms.put("Lab", vLab);
        //         Room vOffice = new Room("the computing admin office", "Images/dungeon.gif");
        //         //aRooms.put("Office", vOffice);
        //         Room vCave = new Room("in the cave", "Images/cave.gif");
        //         //aRooms.put("Cave", vCave);
        // 
        //         // Place Exits
        //         vOutside.setExit("Down", vCave);
        //         vOutside.setExit("South", vLab);
        //         vOutside.setExit("East", vTheatre);
        //         vOutside.setExit("West", vPub);
        // 
        //         vTheatre.setExit("West", vOutside);
        // 
        //         vPub.setExit("East", vOutside);
        //         vLab.setExit("North", vOutside);
        //         vLab.setExit("East", vOffice);
        // 
        //         vOffice.setExit("West", vLab );
        // 
        //         vCave.setExit("Up", vOutside);
        // 
        //         // Create    items
        //         Item vCherry = new Item("a cherry", 2.);
        //         Item vApple = new Item("an apple", 4.);
        //         Item vOrange = new Item("an orange", 3.);
        // 
        //         // Place items
        //         vOutside.addItem(vCherry);
        //         vTheatre.addItem(vApple);
        //         vLab.addItem(vOrange);
        //         vLab.addItem(vApple);
        // 
        //         //initialize current Room
        //         this.aPlayer = new PlayerModel("Bob", vOutside);
        // this.aCurrentRoom = vOutside;
        this.aPreviousRoom = new Stack<Room>();

        
        //Create Rooms
        // TODO: cleanup THIS BIG MESS !!!!!!!
        aRooms.put("r00", new Room("r00", "Images/r00.png")); aRooms.put("r01", new Room("r01", "Images/r01.png")); aRooms.put("r02", new Room("r02", "Images/r02.png")); aRooms.put("r03", new Room("r03", "Images/r03.png")); aRooms.put("r04", new Room("r04", "Images/r04.png")); aRooms.put("r05", new Room("r05", "Images/r05.png")); aRooms.put("r06", new Room("r06", "Images/r06.png")); 
        aRooms.put("r10", new Room("r10", "Images/r10.png")); aRooms.put("r11", new Room("r11", "Images/r11.png")); aRooms.put("r12", new Room("r12", "Images/r12.png")); aRooms.put("r13", new Room("r13", "Images/r13.png")); aRooms.put("r14", new Room("r14", "Images/r14.png")); aRooms.put("r15", new Room("r15", "Images/r15.png")); aRooms.put("r16", new Room("r16", "Images/r16.png")); 
        aRooms.put("r20", new Room("r20", "Images/r20.png")); aRooms.put("r21", new Room("r21", "Images/r21.png")); aRooms.put("r22", new Room("r22", "Images/r22.png")); aRooms.put("r23", new Room("r23", "Images/r23.png")); aRooms.put("r24", new Room("r24", "Images/r24.png")); aRooms.put("r25", new Room("r25", "Images/r25.png")); aRooms.put("r26", new Room("r26", "Images/r26.png")); 
        aRooms.put("r30", new Room("r30", "Images/r30.png")); aRooms.put("r31", new Room("r31", "Images/r31.png")); aRooms.put("r32", new Room("r32", "Images/r32.png")); aRooms.put("r33", new Room("r33", "Images/r33.png")); aRooms.put("r34", new Room("r34", "Images/r34.png")); aRooms.put("r35", new Room("r35", "Images/r35.png")); aRooms.put("r36", new Room("r36", "Images/r36.png")); 
        aRooms.put("r40", new Room("r40", "Images/r40.png")); aRooms.put("r41", new Room("r41", "Images/r41.png")); aRooms.put("r42", new Room("r42", "Images/r42.png")); aRooms.put("r43", new Room("r43", "Images/r43.png")); aRooms.put("r44", new Room("r44", "Images/r44.png")); aRooms.put("r45", new Room("r45", "Images/r45.png")); aRooms.put("r46", new Room("r46", "Images/r46.png")); 
        aRooms.put("r50", new Room("r50", "Images/r50.png")); aRooms.put("r51", new Room("r51", "Images/r51.png")); aRooms.put("r52", new Room("r52", "Images/r52.png")); aRooms.put("r53", new Room("r53", "Images/r53.png")); aRooms.put("r54", new Room("r54", "Images/r54.png")); aRooms.put("r55", new Room("r55", "Images/r55.png")); aRooms.put("r56", new Room("r56", "Images/r56.png")); 
        aRooms.put("r60", new Room("r60", "Images/r60.png")); aRooms.put("r61", new Room("r61", "Images/r61.png")); aRooms.put("r62", new Room("r62", "Images/r62.png")); aRooms.put("r63", new Room("r63", "Images/r63.png")); aRooms.put("r64", new Room("r64", "Images/r64.png")); aRooms.put("r65", new Room("r65", "Images/r65.png")); aRooms.put("r66", new Room("r66", "Images/r66.png"));

        // Set Exits
        //Col. 0
        aRooms.get("r00").setExit("South", aRooms.get("r10"));    /*aRooms.get("r00").setExit("East", aRooms.get("r01"));*/
        aRooms.get("r10").setExit("South", aRooms.get("r20"));    /*aRooms.get("r10").setExit("East", aRooms.get("r11"));*/
        aRooms.get("r20").setExit("South", aRooms.get("r30"));    aRooms.get("r20").setExit("East", aRooms.get("r21"));
        aRooms.get("r30").setExit("South", aRooms.get("r40"));    /*aRooms.get("r30").setExit("East", aRooms.get("r31"));*/
        aRooms.get("r40").setExit("South", aRooms.get("r50"));    /*aRooms.get("r40").setExit("East", aRooms.get("r41"));*/
        aRooms.get("r50").setExit("South", aRooms.get("r60"));   /*aRooms.get("r50").setExit("East", aRooms.get("r51"));*/
        /*aRooms.get("r60").setExit("South", aRooms.get(""));*/     aRooms.get("r60").setExit("East", aRooms.get("r61"));

        aRooms.get("r10").setExit("North", aRooms.get("r00"));
        aRooms.get("r20").setExit("North", aRooms.get("r10"));
        aRooms.get("r30").setExit("North", aRooms.get("r20"));
        aRooms.get("r40").setExit("North", aRooms.get("r30"));
        aRooms.get("r50").setExit("North", aRooms.get("r40"));
        aRooms.get("r60").setExit("North", aRooms.get("r50"));

        //Col. 1
        /*aRooms.get("r01").setExit("North", aRooms.get(""));*/   /*aRooms.get("r01").setExit("East", aRooms.get("r02"));*/
        aRooms.get("r11").setExit("North", aRooms.get("r01"));    aRooms.get("r11").setExit("East", aRooms.get("r12"));
        /*aRooms.get("r21").setExit("North", aRooms.get("r11"));*/  aRooms.get("r21").setExit("East", aRooms.get("r22"));
        aRooms.get("r31").setExit("North", aRooms.get("r21"));  /*aRooms.get("r31").setExit("East", aRooms.get("r32"));*/
        aRooms.get("r41").setExit("North", aRooms.get("r31"));  /*aRooms.get("r41").setExit("East", aRooms.get("r42"));*/
        aRooms.get("r51").setExit("North", aRooms.get("r41"));  /*aRooms.get("r51").setExit("East", aRooms.get("r52"));*/
        aRooms.get("r61").setExit("North", aRooms.get("r51"));    aRooms.get("r61").setExit("East", aRooms.get("r62"));

        aRooms.get("r01").setExit("South", aRooms.get("r11"));   /*aRooms.get("r01").setExit("West", aRooms.get("r00"));*/
        /*aRooms.get("r11").setExit("South", aRooms.get("r21"));*/ /*aRooms.get("r11").setExit("West", aRooms.get("r10"));*/
        aRooms.get("r21").setExit("South", aRooms.get("r31"));     aRooms.get("r21").setExit("West", aRooms.get("r20"));
        aRooms.get("r31").setExit("South", aRooms.get("r41"));   /*aRooms.get("r31").setExit("West", aRooms.get("r30"));*/
        aRooms.get("r41").setExit("South", aRooms.get("r51"));   /*aRooms.get("r41").setExit("West", aRooms.get("r40"));*/
        aRooms.get("r51").setExit("South", aRooms.get("r61"));   /*aRooms.get("r51").setExit("West", aRooms.get("r50"));*/
        /*aRooms.get("r61").setExit("South", aRooms.get(""));*/      aRooms.get("r61").setExit("West", aRooms.get("r60"));

        //Col. 2
        /*aRooms.get("r02").setExit("North", aRooms.get(""));*/     aRooms.get("r02").setExit("East", aRooms.get("r03"));
        /*aRooms.get("r12").setExit("North", aRooms.get("r02"));*/  aRooms.get("r12").setExit("East", aRooms.get("r13"));
        /*aRooms.get("r22").setExit("North", aRooms.get("r12"));*//*aRooms.get("r22").setExit("East", aRooms.get("r23"));
        aRooms.get("r32").setExit("North", aRooms.get("r22"));  /*aRooms.get("r32").setExit("East", aRooms.get("r33"));*/
        aRooms.get("r42").setExit("North", aRooms.get("r32"));  /*aRooms.get("r42").setExit("East", aRooms.get("r43"));*/
        aRooms.get("r52").setExit("North", aRooms.get("r42"));    aRooms.get("r52").setExit("East", aRooms.get("r53"));
        /*aRooms.get("r62").setExit("North", aRooms.get("r52"));*/  aRooms.get("r62").setExit("East", aRooms.get("r63"));

        /*aRooms.get("r02").setExit("South", aRooms.get("r12"));*/  aRooms.get("r02").setExit("West", aRooms.get("r01"));
        /*aRooms.get("r12").setExit("South", aRooms.get("r22"));*/  aRooms.get("r12").setExit("West", aRooms.get("r11"));
        aRooms.get("r22").setExit("South", aRooms.get("r32"));  /*aRooms.get("r22").setExit("West", aRooms.get("r21"));*/
        aRooms.get("r32").setExit("South", aRooms.get("r42"));  /*aRooms.get("r32").setExit("West", aRooms.get("r31"));*/
        aRooms.get("r42").setExit("South", aRooms.get("r52"));  /*aRooms.get("r42").setExit("West", aRooms.get("r41"));*/
        /*aRooms.get("r52").setExit("South", aRooms.get("r62"));*/  aRooms.get("r52").setExit("West", aRooms.get("r51"));
        /*aRooms.get("r62").setExit("South", aRooms.get(""));*/     aRooms.get("r62").setExit("West", aRooms.get("r61"));   

        //Col. 3
        /*aRooms.get("r03").setExit("North", aRooms.get(""));*/     aRooms.get("r03").setExit("East", aRooms.get("r04"));
        /*aRooms.get("r13").setExit("North", aRooms.get("r03"));*/  aRooms.get("r13").setExit("East", aRooms.get("r14"));
        aRooms.get("r23").setExit("North", aRooms.get("r13"));  /*aRooms.get("r23").setExit("East", aRooms.get("r24"));*/
        aRooms.get("r33").setExit("North", aRooms.get("r23"));  /*aRooms.get("r33").setExit("East", aRooms.get("r34"));*/
        aRooms.get("r43").setExit("North", aRooms.get("r33"));  /*aRooms.get("r43").setExit("East", aRooms.get("r44"));*/
        aRooms.get("r53").setExit("North", aRooms.get("r43"));  /*aRooms.get("r53").setExit("East", aRooms.get("r54"));*/
        aRooms.get("r63").setExit("North", aRooms.get("r53"));  /*aRooms.get("r63").setExit("East", aRooms.get("r64"));*/

        /*aRooms.get("r03").setExit("South", aRooms.get("r13"));*/  aRooms.get("r03").setExit("West", aRooms.get("r02"));
        aRooms.get("r13").setExit("South", aRooms.get("r23"));    aRooms.get("r13").setExit("West", aRooms.get("r12"));
        aRooms.get("r23").setExit("South", aRooms.get("r33"));  /*aRooms.get("r23").setExit("West", aRooms.get("r22"));*/
        aRooms.get("r33").setExit("South", aRooms.get("r43"));  /*aRooms.get("r33").setExit("West", aRooms.get("r32"));*/
        aRooms.get("r43").setExit("South", aRooms.get("r53"));  /*aRooms.get("r43").setExit("West", aRooms.get("r42"));*/
        aRooms.get("r53").setExit("South", aRooms.get("r63"));    aRooms.get("r53").setExit("West", aRooms.get("r52"));
        /*aRooms.get("r63").setExit("South", aRooms.get(""));*/     aRooms.get("r63").setExit("West", aRooms.get("r62"));

        //Col. 4
        /*aRooms.get("r04").setExit("North", aRooms.get(""));*/     aRooms.get("r04").setExit("East", aRooms.get("r05"));
        /*aRooms.get("r14").setExit("North", aRooms.get("r04"));*//*aRooms.get("r14").setExit("East", aRooms.get("r15"));*/
        aRooms.get("r24").setExit("North", aRooms.get("r14"));  /*aRooms.get("r24").setExit("East", aRooms.get("r25"));*/
        aRooms.get("r34").setExit("North", aRooms.get("r24"));    aRooms.get("r34").setExit("East", aRooms.get("r35"));
        aRooms.get("r44").setExit("North", aRooms.get("r34"));  /*aRooms.get("r44").setExit("East", aRooms.get("r45"));*/
        aRooms.get("r54").setExit("North", aRooms.get("r44"));    aRooms.get("r54").setExit("East", aRooms.get("r55"));
        aRooms.get("r64").setExit("North", aRooms.get("r54"));  /*aRooms.get("r64").setExit("East", aRooms.get("r65"));*/

        /*aRooms.get("r04").setExit("South", aRooms.get("r14"));*/  aRooms.get("r04").setExit("West", aRooms.get("r03"));
        aRooms.get("r14").setExit("South", aRooms.get("r24"));  /*aRooms.get("r14").setExit("West", aRooms.get("r13"));*/
        aRooms.get("r24").setExit("South", aRooms.get("r34"));    aRooms.get("r24").setExit("West", aRooms.get("r23"));
        aRooms.get("r34").setExit("South", aRooms.get("r44"));    aRooms.get("r34").setExit("West", aRooms.get("r33"));
        aRooms.get("r44").setExit("South", aRooms.get("r54"));  /*aRooms.get("r44").setExit("West", aRooms.get("r43"));*/
        aRooms.get("r54").setExit("South", aRooms.get("r64"));    aRooms.get("r54").setExit("West", aRooms.get("r53"));
        /*aRooms.get("r64").setExit("South", aRooms.get(""));*/   /*aRooms.get("r64").setExit("West", aRooms.get("r63"));*/

        //Col. 5
        /*aRooms.get("r05").setExit("North", aRooms.get(""));*/     aRooms.get("r05").setExit("East", aRooms.get("r06"));
        aRooms.get("r15").setExit("North", aRooms.get("r05"));  /*aRooms.get("r15").setExit("East", aRooms.get("r16"));*/
        aRooms.get("r25").setExit("North", aRooms.get("r15"));  /*aRooms.get("r25").setExit("East", aRooms.get("r26"));*/
        /*aRooms.get("r35").setExit("North", aRooms.get("r25"));*/  aRooms.get("r35").setExit("East", aRooms.get("r36"));
        /*aRooms.get("r45").setExit("North", aRooms.get("r35"));*/  aRooms.get("r45").setExit("East", aRooms.get("r46"));
        aRooms.get("r55").setExit("North", aRooms.get("r45"));  /*aRooms.get("r55").setExit("East", aRooms.get("r56"));*/
        aRooms.get("r65").setExit("North", aRooms.get("r55"));  /*aRooms.get("r65").setExit("East", aRooms.get("r56"));*/

        aRooms.get("r05").setExit("South", aRooms.get("r15"));    aRooms.get("r05").setExit("West", aRooms.get("r04"));
        aRooms.get("r15").setExit("South", aRooms.get("r25"));  /*aRooms.get("r15").setExit("West", aRooms.get("r14"));*/
        aRooms.get("r25").setExit("South", aRooms.get("r35"));  /*aRooms.get("r25").setExit("West", aRooms.get("r24"));*/
        /*aRooms.get("r35").setExit("South", aRooms.get("r45"));*/  aRooms.get("r35").setExit("West", aRooms.get("r34"));
        aRooms.get("r45").setExit("South", aRooms.get("r55"));  /*aRooms.get("r45").setExit("West", aRooms.get("r44"));*/
        aRooms.get("r55").setExit("South", aRooms.get("r65"));    aRooms.get("r55").setExit("West", aRooms.get("r54"));
        /*aRooms.get("r65").setExit("South", aRooms.get(""));*/   /*aRooms.get("r65").setExit("West", aRooms.get("r64"));*/

        //Col. 6
        /*aRooms.get("r06").setExit("North", aRooms.get(""));*/
        aRooms.get("r16").setExit("North", aRooms.get("r06"));
        /*aRooms.get("r26").setExit("North", aRooms.get("r16"));*/ 
        aRooms.get("r36").setExit("North", aRooms.get("r26"));
        aRooms.get("r46").setExit("North", aRooms.get("r36"));
        /*aRooms.get("r56").setExit("North", aRooms.get("r46"));*/
        /*aRooms.get("r66").setExit("North", aRooms.get("r56"));*/

        aRooms.get("r06").setExit("South", aRooms.get("r16"));  /*aRooms.get("r06").setExit("West", aRooms.get("r05"));*/
        /*aR    ooms.get("r16").setExit("South", aRooms.get("r26"));*//*aRooms.get("r16").setExit("West", aRooms.get("r15"));*/
        aRooms.get("r26").setExit("South", aRooms.get("r36"));    aRooms.get("r26").setExit("West", aRooms.get("r25"));
        aRooms.get("r36").setExit("South", aRooms.get("r46"));  /*aRooms.get("r36").setExit("West", aRooms.get("r35"));*/
        /*aRooms.get("r46").setExit("South", aRooms.get("r56"));*/  aRooms.get("r46").setExit("West", aRooms.get("r45"));
        /*aRooms.get("r56").setExit("South", aRooms.get("r66"));*//*aRooms.get("r56").setExit("West", aRooms.get("r55"));*/
        /*aRooms.get("r66").setExit("South", aRooms.get(""));*/     aRooms.get("r66").setExit("West", aRooms.get("r65"));

        
        // Place Items
        aRooms.get("r22").addItem(new Item("strawberry", 6));
        aRooms.get("r52").addItem(new Item("apple", 5));
        aRooms.get("r13").addItem(new Item("orange", 10));
        aRooms.get("r35").addItem(new Item("cherry", 3));
        aRooms.get("r65").addItem(new Item("key", 3));

        aRooms.get("r00").addItem(new Item("cookie"));
        
        aRooms.get("r60").addItem(new Beamer(aRooms.get("r60")));
        
        // Initialize current Room
        //this.aCurrentRoom = aRooms.get("r00");
        //initialize current Room and player
        // TODO: ask for player name
        // String vName = javax.swing.JOptionPane.showInputDialog( "What is your name ?" );
        this.aPlayer = new PlayerModel(this.aGameEngine, "Bob", aRooms.get("r00"), 10);


        // Notify interested listeners
        setChanged();
        notifyObservers();
    }

    /**
     * Check valid direction and define the new current position
     * @param pCommand
     */
    public void goRoom(final Room pNextRoom)
    {
        //         if (!pCommand.hasSecondWord() ) {
        //             aGui.println("Go Where ?");
        //             return;
        //         }
        // 
        //         String vDirection = pCommand.getSecondWord();
        // 
        //         Room vNextRoom = this.aCurrentRoom.getExit(vDirection);
        //         if (vNextRoom == null) {
        //             aGui.println("There is a wall !");
        //         } else {
        //             this.aPreviousRoom.push(this.aCurrentRoom);
        //             this.aCurrentRoom = vNextRoom;
        //             this.printExitsAndCurrentRoom(this.aCurrentRoom);
        //             if(aCurrentRoom.getImageName() != null) {
        //                 aGui.showImage(aCurrentRoom.getImageName());
        //             }
        //         }

        this.aPreviousRoom.push(this.aPlayer.getCurrentRoom());
        this.aPlayer.setCurrentRoom(pNextRoom);
        this.aPlayer.decrementTimeLimit();

        // Notify interested listeners (Views) (should be the controller in modern MVC?) 
        setChanged();
        notifyObservers(this.aPlayer.getCurrentRoom());
    }

    public void goBack()
    {
        if (this.aPreviousRoom.empty()) {
            setChanged();
            notifyObservers("You cannot go back any futher.");
            return;
        }

        this.aPlayer.setCurrentRoom(this.aPreviousRoom.pop());

        // Notify interested listeners
        // notification should be done in the PlayerModel
        setChanged();
        notifyObservers();
    }

    public String take(final String pItemName)
    {
        if (this.aPlayer.pickUpItem(pItemName) ) {
            return "You picked up a " + pItemName;
        } else {
            return "Ouups, I can't find your " + pItemName;
        }
        // TODO: Show inventory
    }

    public String drop(final String pItemName)
    {
        if (this.aPlayer.dropItem(pItemName) ) {
            return "You dropped your " + pItemName;
        } else {
            return "Ouups, I can't find your " + pItemName;
        }
        // TODO: Show inventory
    }

    //  Accessors
    /**
     * Returns the current Room
     * @Return Room
     */

    public Room getCurrentRoom()
    {
        return this.aPlayer.getCurrentRoom();
    }

    /**
     * Returns a String containing the welcome message
     * @returns String
     */
    public String getWelcomeString()
    {
        return "Welcome to this exciting new game \n" +
        "Type '" + CommandWord.HELP +  "' if you need help.";
    }

    /**
     * Returns a String containing the Good Bye message
     * @returns String
     */
    public String getGoodByeString()
    {
        return "Thank you for playing.  Good bye.";
    }

    public String getHelpString()
    {
        return "You are lost. You are alone." + "\n"
        + "You wander around at the university.";
    }

    public String getLocationInfoString() 
    {
        return this.getCurrentRoom().getLongDescription();
    }

    public PlayerModel getPlayer()
    {
        return this.aPlayer;
    }
    
    public String useBeamer(final String pBeamerName)
    {
        if ( this.aPlayer.hasItemNamed(pBeamerName) ) {
            Beamer vBeamer = (Beamer) this.aPlayer.getItemNamed(pBeamerName);
            this.goRoom(vBeamer.getOriginRoom());
            return "Teleportation done !\n" + this.getLocationInfoString();
        } else {
            return "You cannot teleport";
        }
    }
}
