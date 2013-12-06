import java.util.HashMap;

/**
 * Room.java
 *
 * @author Guillaume Legrain
 * @version %I%, %G%
 *
 */
public class Room {
	private String aDescription;
	private HashMap<String, Room> aExits;
	private String aImageName;

	
	/**
	 * Create a Room described "pDescription" with a given image.
	 * Initially, it has no exits.
	 * @param aDescription
	 * @param imageName
	 */
	public Room(final String aDescription,final  String imageName) {
		this.aDescription = aDescription;
		this.aImageName = imageName;
		aExits = new HashMap<String, Room>();
	}

	/**
	 * @return the aDescription
	 */
	public String getaDescription() {
		return aDescription;
	}
	
	
	/**
	 * @param String pDirection
	 * @return Room
	 */
	public Room getaExit(final String pDirection) {
		return aExits.get(pDirection);
	}

	/**
	 * @return the aImageName
	 */
	public String getaImageName() {
		return aImageName;
	}

	/**
	 * @param aDescription the aDescription to set
	 */
	public void setaDescription(String aDescription) {
		this.aDescription = aDescription;
	}
	
	/**
	 * Define an exit from this room.
	 * @param aExits the aExits to set
	 */
	public void setExit(final String pDirection, final Room pNeighbor) {
		this.aExits.put(pDirection, pNeighbor);
	}

	public String getLongDescription() {
		// TODO
		return this.getaDescription();
	}

}
