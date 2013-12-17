
/**
 * Write a description of class Beamer here.
 * 
 * @author Guillaume Legrain 
 * @version 2013.12.17
 */
public class Beamer extends Item
{
    private Room aOriginRoom;
    private PlayerModel aPlayerModel;
    
    public Beamer(final Room pOriginRoom)
    {
        super("beamer", 1); //TODO: change name for multiple beamers
        this.aOriginRoom = pOriginRoom;
        //this.aPlayerModel = pPlayerModel;
    }
    
    public Room getOriginRoom()
    {
        return this.aOriginRoom;
    }
//     public void useBeamer()
//     {
//        //this.aPlayerModel.setCurrentRoom(this.aOriginRoom);
//     }
}
