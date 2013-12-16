import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

/**
 * Write a description of class PlayerModel here.
 * 
 * @author Guillaume Legrain 
 * @version 2013-11
 */
public class PlayerModel extends Observable
{
    // instance variables
    private String aName;
    private Room aCurrentRoom;
    private ItemList aItemsInPossesion; // NOTE: A HashMap might be preferable since we wouldn't need to go trough a loop to get an Item
    private double maxWeight;
    private int aTimeLimit; // Limit the number of moves to the player
    private GameEngine aEngine;

    /**
     * Constructor for objects of class PlayerModel
     */
    public PlayerModel(final GameEngine aEngine, final String pName, final Room pStartRoom, final int pTimeLimit)
    {
        // initialise instance variables
        this.aName = pName;
        this.maxWeight = 20; // TODO: make default value dynamic
         this.aItemsInPossesion = new ItemList();
        this.setCurrentRoom(pStartRoom);
        this.aTimeLimit = pTimeLimit;
        //this.addObserver(this.aEngine); // SHould be done in Game.java ??
    }

    /**
     * Get the player's name
     */
    public String getName()
    {
        return aName;
    }

    public Room getCurrentRoom()
    {
        // TODO: check if aCurrentRoom is initialized
        return this.aCurrentRoom;
    }

    public void setCurrentRoom(final Room pCurrentRoom)
    {
        this.aCurrentRoom = pCurrentRoom;
    }

    // TODO: eat fruits and take key
    public boolean eatItem(final String pItemName)
    {
        return this.pickUpItem(pItemName);
    }
    
    /**
     * Pick up an item
     * returns true if the item was successfully picked up
     * // TODO: return String to specify why the you can't pick up an item
     * // TODO: see eat 
     * @param pItemName
     * @return
     */
    public boolean pickUpItem(final String pItemName)
    {
        double vMagicCookieIncrement = 100.; // TODO: set this as a GameModel attribute
        // try .. catch statement if getItem trows an exception
        if (this.aCurrentRoom.hasItemNamed(pItemName) ) {
            Item vPickedUpItem = this.aCurrentRoom.getItemAndRemove(pItemName);
            if ( vPickedUpItem.isNamed("cookie") ) {
                this.maxWeight += vMagicCookieIncrement;
                this.aTimeLimit *= 10; // Allows the player 10* more moves.
            }
            // check if the player can carry the item
            if ( aItemsInPossesion.getTotalWeight() + vPickedUpItem.getWeight() <= this.maxWeight ) { 
                aItemsInPossesion.setItem(vPickedUpItem);
                return true;
            } else {
                return false;
            }
            
        } else {
            return false;
        }
    }

    /**
     * Drop the item called pItemName
     * returns true if the item was successfully dropped
     * 
     * @param pItemName
     * @return Item
     */
    public boolean dropItem(final String pItemName)
    {
        if ( this.aItemsInPossesion.hasItemNamed(pItemName) ) {
            // remove Item from inventory
            Item vItem = this.aItemsInPossesion.remove(pItemName);
            // then put this item in the room
            this.aCurrentRoom.addItem(vItem);
            return true;
        } else {
            return false;
        }
        //         for (Item vItem : this.aItemsInPossesion) {
        //             if ( vItem.toString().equals(pItemName) ) {
        //                 this.aItemsInPossesion.remove(vItem);
        //                 return true;
        //             }
        //         }
        //         return false;
    }
    
    public String getItemsInPossesion()
    {
        if (this.aItemsInPossesion.isEmpty()) {
            return "You don't have any items";
        }
        StringBuilder vReturnString = new StringBuilder("You currently have:\n");
        vReturnString.append(this.aItemsInPossesion.getItemsString());
        
        return vReturnString.toString();
        
    }
    
    // TODO: change S.o.p for GUI
    public void decrementTimeLimit()
    {
        if ( this.aTimeLimit <= 0) {
            System.out.println("GAME OVER ! \nYou don't have any moves left");
            aEngine.interpretCommand( CommandWord.QUIT.toString() );
            // FIXME: show quit message
            //return "You don't have any moves left";
        } else {
            this.aTimeLimit--;
            System.out.println("You have " + this.aTimeLimit + " moves left.");
            //return "You have " + this.aTimeLimit + " moves left.";
        }
        
        //TODO: add Observer
        setChanged();
        notifyObservers(this.aTimeLimit);
    }
    
    
    public int getTimeLimit()
    {
        return this.aTimeLimit;
    }
}
