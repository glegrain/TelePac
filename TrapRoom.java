/**
 * TrapRoom.
 * 
 * @author Guillaume Legrain 
 * @version 2013.12.18
 */
public class TrapRoom extends Room
{
    private GameModel aGameModel;
    
    /**
     * Create a TrapRoom
     * @param pDescription
     * @param pImageName
     * @param pGameModel
     */
    public TrapRoom(final String pDescription, final String pImageName,
                            final GameModel pGameModel)
    {
        super(pDescription, pImageName);
        this.aGameModel = pGameModel;
    }

    /**
     * Return the current room: ther is no exit.
     * 
     * @param  pDirection Ignored.
     * @return Room this room. 
     */
    @Override
    public Room getExit(final String pDirection)
    {
        System.out.println("DEBUG: cannot exit a TrapRoom");
        // Empty previous room stack so the player cannot go back
        this.aGameModel.clearHistory();
        return this;
    }
}
