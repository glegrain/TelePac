
/**
 * Item class
 * 
 * @author Guillaume Legrain
 * @version 2013-10-05
 */
public class Item
{
    // instance variables
    private String aDescription;
    private double aWeight;
    

    /**
     * Constructor for objects of class Item
     * 
     * @param pDescription The item's description
     * @param pWeight The item's weight
     */
    public Item(final String pDescription, final double pWeight)
    {
        // initialise instance variables
       this.aDescription = pDescription;
       this.aWeight = pWeight;
    }
    
    /**
     * Default constructor for objects of class Item
     * 
     * @param pDescription The item's description
     */
    public Item(final String pDescription)
    {
        this(pDescription, 0);
    }  
    
    
    /**
     * Get Item's description
     * @return The Item's description
     */
    public String getDescription()
    {
        return this.aDescription;
    }
    
    @Override
    public String toString()
    {
        return this.getDescription();
    }
    
    /**
     * Get Item's weight
     * @return The Item's weight
     */
    public double getWeight()
    {
        return this.aWeight;
    }
    
    /**
     * Check if items are equals
     */
    @Override
    public boolean equals(Object o)
    {
        if (o == this) {
            return true;
        }
        if ( o == null) {
            return false;
        }
        if ( o.getClass() == this.getClass()) {
            Item vItem = (Item) o;
            if ( vItem.toString().equals(this.toString())) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Check if the item is named pName
     * @param pItemName
     * @return
     */
    public boolean isNamed(final String pName) {
        return this.getDescription().equals(pName);
    }
}
