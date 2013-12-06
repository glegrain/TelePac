import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Write a description of class Room here.
 * 
 * @author Guillaume Legrain & Florian Martin 
 * @version 2013-10-05
 */
public class Room
{
    private String aDescription;
    private HashMap<String, Room> aExits; //Stores exits of this Room
    private ItemList aItems;
    private String aImageName;

    /**
     * Create a room described "description" containing an Item.
     * Initially, it has no exits. 
     * "description" is something like "a kitchen" or
     * "an open court yard".
     * @param pDescription The room's description.
     * @param pItem The room's item
     * @param pImageName The room's image path
     */
    public Room(final String pDescription, final String pImageName, final Item pItem)
    {
        this(pDescription, pImageName);
        this.addItem(pItem);

    }

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param pDescription The room's description
     */
    public Room(final String pDescription, final String pImageName)
    {
        this.aDescription = pDescription;
        this.aExits = new HashMap<String, Room>();
        this.aItems = new ItemList();
        this.aImageName = pImageName;
    }

    /**
     * Set exits for a room
     * @deprecated Use setExit instead
     * @param pNorthExit
     * @param pSouthExit
     * @param pEastExit
     * @parma pWestExit
     */
    public void setExits(final Room pNorthExit, final Room pSouthExit, final Room pEastExit, final Room pWestExit)
    {
        this.setExit("North", pNorthExit);
        this.setExit("South", pSouthExit);
        this.setExit("East", pEastExit);
        this.setExit("West", pWestExit);
        //         if (pNorthExit != null) {
        //             //exits.put("North", pNorthExit);
        //             this.setExit("North", pNorthExit);
        //         }
        //         if (pSouthExit != null) {
        //             exits.put("South", pSouthExit);
        //         }
        //         if (pEastExit != null) {
        //             exits.put("East", pEastExit);
        //         }
        //         if (pWestExit != null) {
        //             exits.put("West", pWestExit);
        //         }
    }

    /**
     * Define an exit from this room.
     * @param pDirection The direction for the exit.
     * @param pNeighbor The room in the given direction.
     */
    public void setExit(final String pDirection, final Room pNeighbor)
    {
        if ( pNeighbor != null) {
            aExits.put(pDirection, pNeighbor);
        }
    }

    /**
     * Set room's item
     * @param pItem The room's item
     */
    public void addItem(final Item pItem)
    {
        if (pItem != null) {
            this.aItems.setItem(pItem);
        }
    }
    
    /**
     * Check if the room has a given item String
     * @param pItem
     * @return
     */
    public boolean hasItemNamed(final String pItemName)
    {
        return this.aItems.hasItemNamed(pItemName);
    }
    
    public ItemList getItems()
    {
        return this.aItems;
    }
    
    /**
     * Check if the room has a given Item
     * @param pItem
     * @return
     */
    public boolean hasItem(final Item pItem)
    {
        return this.aItems.hasItem(pItem);
    }
    
    /**
     * Get the room's item
     * @return The room's item
     */
    public String getItemsString()
    {
        
        if ( this.aItems.isEmpty() ) {
            return "This Room contains no items.";
        }
        
       return this.aItems.getItemsString();
    }
    
    /**
     * get item reference from item name
     * @param pItemName
     * @return
     */
    public Item getItem(final String pItemName)
    {
        if ( this.aItems.hasItemNamed(pItemName)) {
            return aItems.getItemNamed(pItemName);
        } else {
            return null; // throw exception ??
        }
    }
    
    /**
     * get item reference from item name and remove from current room
     * @param pItemName
     * @return
     */
    public Item getItemAndRemove(final String pItemName)
    {
        Item vItem  = getItem(pItemName);
        this.aItems.remove(pItemName);
        return vItem;
    }
    
    
    /**
     * Go to another Room
     * @param pDirection
     */
    public Room leaveRoom(final String pDirection)
    {
        return aExits.get(pDirection);
        //TODO: print info
    }
    
    /**
     *@return an exit the direction indicates 
     */
    public Room getExit(final String pDirection) {
        return aExits.get(pDirection);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getDescription()
    {
        return this.aDescription;
    }

    /**
     * Return a long description of this room, of the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A description of the room, including exits.
     */
    public String getLongDescription()
    {
        return "You are " + aDescription + ".\n" 
        + this.getItemsString() + "\n"
        + this.getExitString();
    }

    /**
     * Return a description of the room’s exits,
     * for example, "Exits: north west".
     * @return A description of the available exits.
     */
    // This method finds all the names for exits in the HashMap
    // The keys in the HasMap are the names of the exits
    public String getExitString() {
        StringBuilder vReturnString = new StringBuilder("Possible exits:");
        Set<String> vKeys = aExits.keySet();
        for(String vExit : vKeys) {
            vReturnString.append( " " + vExit);
        }
        return vReturnString.toString();
    }

    /**
     * Return a string describing the room's image name
     */
    public String getImageName()
    {
        return this.aImageName;
    }
}
