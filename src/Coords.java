/**
 * Coords.java
 * Class to represent the Room position in the maze.
 * Inspired from http://stackoverflow.com/questions/11721013/store-x-and-y-coordinates
 * 
 * @author Guillaume Legrain
 * @version %I%, %G%
 *
 */
public class Coords {

	private int x;
    private int y;

    @Override
    public boolean equals(Object o) {
        Coords c = (Coords) o;
        return c.x == x && c.y == y;
    }

    /**
     * Creates a new Coords point with x and y attributes.
     * @param x
     * @param y
     */
    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Creates a new Coords point at 0, 0;
     */
    public Coords(){
    	this(0, 0);
    }

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

}
