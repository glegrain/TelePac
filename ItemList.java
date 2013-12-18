import java.util.HashMap;
import java.util.Set;

/**
 * ItemList
 * 
 * @author Guillaume Legrain
 * @version 2013.12.02
 */
public class ItemList extends HashMap<String, Item>
{

    //private HashMap<String, Item> aItems;

    /**
     * Constructor for objects of class ItemList
     */
    public ItemList()
    {
        super();
        //this.aItems = new HashMap<String, Item>();
    }

    /**
     * Return the Item named
     * @param pItemName
     * @return Item named
     */
    public Item getItemNamed(final String pItemName) {
        return this.get(pItemName);
    }

    //     public void setItemNamed(final String pItemName)
    //     {
    //         this.setItem(pItemName, new Item(pItemName));
    //     }
    /**
     * Set Item in ItemList
     * @param pItem
     */
    public void setItem(final Item pItem)
    {
        this.setItem(pItem.toString(), pItem);
    }

    
    // Should not be used
    /**
     * Set Item in ItemList
     * @param pItemName
     * @param pItem
     */
    public void setItem(final String pItemName, final Item pItem)
    {
        this.put(pItemName, pItem);
    }

    /**
     * Check if there is the Item
     * @param pItem
     * @return boolean
     */
    public boolean hasItem(final Item pItem)
    {
        return this.containsValue(pItem);
    }

    /**
     * Check if there is the Item named
     * @param pItemName
     * @return boolean
     */
    public boolean hasItemNamed(final String pItemName)
    {
        return this.containsKey(pItemName);
    }

    /**
     * Return the name of the Item in the ItemList
     * @return String
     */
    public String getItemsString()
    {
        if (this.isEmpty()) {
            return "no items";
        }
        StringBuilder vReturnString = new StringBuilder("items:");
        Set<String> vKeys = this.keySet();
        for(String vItem : vKeys) {
            vReturnString.append( " " + vItem);
        }
        return vReturnString.toString();
    }

    /**
     * @param pItem
     */
    public void removeItem(final Item pItem) {
        if ( this.hasItem(pItem) ) {
            this.remove(pItem.toString()); //UGLY !!!
        }
    }
    
    // isEmpty (inherited method)
    // remove (inherited method)
    // size (inherited method) 
    
    /**
     * same as size()
     * @return
     */
    public int getNumberOfItems()
    {
        return this.size();
    }
    
    public double getTotalWeight() {
        double vTotalWeight = 0;
        for (Item vItem : this.values()) {
            vTotalWeight += vItem.getWeight();
        }
        return vTotalWeight;
    }
}
