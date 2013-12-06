import java.util.HashMap;

/**
 * Game.java
 * TelePac entry class
 *
 * @author Guillaume Legrain
 * @version %I%, %G%
 *
 */
public class Game {

	private Parser aParser;
	private Room aCurrentRoom;
	private HashMap<String, Room> aRooms;

	public Game(){
		this.aParser = new Parser();
		this.createRooms();
	}
	
	public void play() {
		this.printWelcome();
		boolean vFinished = false;
		while (!vFinished) {
			Command vCommand = aParser.getCommand();
			vFinished = processCommand(vCommand);
		}
		System.out.println("Thank you for playing.  Good bye.");
	}

	private void createRooms(){
		this.aRooms = new HashMap<String,Room>();

		//Create Rooms
		// TODO: cleanup
		aRooms.put("r00", new Room("r00", "Images/r00.png")); aRooms.put("r01", new Room("r01", "Images/r01.png")); aRooms.put("r02", new Room("r02", "Images/r02.png")); aRooms.put("r03", new Room("r03", "Images/r03.png")); aRooms.put("r04", new Room("r04", "Images/r04.png")); aRooms.put("r05", new Room("r05", "Images/r05.png")); aRooms.put("r06", new Room("r06", "Images/r06.png")); 
		aRooms.put("r10", new Room("r10", "Images/r10.png")); aRooms.put("r11", new Room("r11", "Images/r11.png")); aRooms.put("r12", new Room("r12", "Images/r12.png")); aRooms.put("r13", new Room("r13", "Images/r13.png")); aRooms.put("r14", new Room("r14", "Images/r14.png")); aRooms.put("r15", new Room("r15", "Images/r15.png")); aRooms.put("r16", new Room("r16", "Images/r16.png")); 
		aRooms.put("r20", new Room("r20", "Images/r20.png")); aRooms.put("r21", new Room("r21", "Images/r21.png")); aRooms.put("r22", new Room("r22", "Images/r22.png")); aRooms.put("r23", new Room("r23", "Images/r23.png")); aRooms.put("r24", new Room("r24", "Images/r24.png")); aRooms.put("r25", new Room("r25", "Images/r25.png")); aRooms.put("r26", new Room("r26", "Images/r26.png")); 
		aRooms.put("r30", new Room("r30", "Images/r30.png")); aRooms.put("r31", new Room("r31", "Images/r31.png")); aRooms.put("r32", new Room("r32", "Images/r32.png")); aRooms.put("r33", new Room("r33", "Images/r33.png")); aRooms.put("r34", new Room("r34", "Images/r34.png")); aRooms.put("r35", new Room("r35", "Images/r35.png")); aRooms.put("r36", new Room("r36", "Images/r36.png")); 
		aRooms.put("r40", new Room("r40", "Images/r40.png")); aRooms.put("r41", new Room("r41", "Images/r41.png")); aRooms.put("r42", new Room("r42", "Images/r42.png")); aRooms.put("r43", new Room("r43", "Images/r43.png")); aRooms.put("r44", new Room("r44", "Images/r44.png")); aRooms.put("r45", new Room("r45", "Images/r45.png")); aRooms.put("r46", new Room("r46", "Images/r46.png")); 
		aRooms.put("r50", new Room("r50", "Images/r50.png")); aRooms.put("r51", new Room("r51", "Images/r51.png")); aRooms.put("r52", new Room("r52", "Images/r52.png")); aRooms.put("r53", new Room("r53", "Images/r53.png")); aRooms.put("r54", new Room("r54", "Images/r54.png")); aRooms.put("r55", new Room("r55", "Images/r55.png")); aRooms.put("r56", new Room("r56", "Images/r56.png")); 
		aRooms.put("r60", new Room("r60", "Images/r60.png")); aRooms.put("r61", new Room("r61", "Images/r61.png")); aRooms.put("r62", new Room("r62", "Images/r62.png")); aRooms.put("r63", new Room("r63", "Images/r63.png")); aRooms.put("r64", new Room("r64", "Images/r64.png")); aRooms.put("r65", new Room("r65", "Images/r65.png")); aRooms.put("r66", new Room("r66", "Images/r66.png"));
		
		// Set Exits
		//TODO

		// Place Items
		// TODO

		// Initialize current Room
		aCurrentRoom = aRooms.get("r00");
	}

	/**
	 * Check valid direction and define the new current position
	 * @param pNextRoom
	 */
	public void goRoom(final Command pCommand) {
        if(!pCommand.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = pCommand.getaSecondWord();

        // Try to leave current room.
        Room nextRoom = aCurrentRoom.getaExit(direction);

        if (nextRoom == null)
        	System.out.println("There is no door!");
        else {
//            currentRoom = nextRoom;
//            gui.println(currentRoom.getLongDescription());
//            if(currentRoom.getImageName() != null)
//                gui.showImage(currentRoom.getImageName());
        }
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
    	System.out.println();
    	System.out.println("Welcome to TelePac");
    	System.out.println("TelePac is a revolutionary game");
    	System.out.println("Type 'help' if you need help.");
    	System.out.println();
    	System.out.println(aCurrentRoom.getLongDescription());
    	System.out.println(aCurrentRoom.getaImageName());
    }
    
    /**
     * Print out some help information
     */
    private void printHelp() {
    	System.out.println("You are lost. You are alone. You wander");
    	System.out.println("around the maze.");
    	//TODO: System.out.println("Your command words are: " + parser.showCommands());
    }
	
    private boolean processCommand(Command pCommand) {
        boolean vWantToQuit = false;

        if(pCommand.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = pCommand.getaCommandWord();
        if (commandWord.equals("help"))
            printHelp();
        else if (commandWord.equals("go"))
            goRoom(pCommand);
        else if (commandWord.equals("quit"))
            vWantToQuit = quit(pCommand);

        return vWantToQuit;
    }
    
    private boolean quit(final Command pCommand) {
    	if(pCommand.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
    	return true;
    }
    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Game vGame = new Game();
		vGame.play();
	}

}
