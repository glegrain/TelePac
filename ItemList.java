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

    public Item getItemNamed(final String pItemName) {
        return this.get(pItemName);
    }

//     public void setItemNamed(final String pItemName)
//     {
//         this.setItem(pItemName, new Item(pItemName));
//     }

    public void setItem(final Item pItem)
    {
        this.setItem(pItem.toString(), pItem);
    }

    
    // Should not be used
    public void setItem(final String pItemName, final Item pItem)
    {
        this.put(pItemName, pItem);
    }

    public boolean hasItem(final Item pItem)
    {
        return this.containsValue(pItem);
    }

    public boolean hasItemNamed(final String pItemName)
    {
        return this.containsKey(pItemName);
    }
    
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
