import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * TransporterRoom.
 * 
 * @author Guillaume Legrain 
 * @version 2013.12.18
 */
public class TransporterRoom extends Room
{
    private GameModel aGameModel;
    private Random aRandom; // Use RoomRandomizer
    
    /**
     * Create a TransporterRoom
     * @param pDescription
     * @param pImageName
     * @param pGameModel
     */
    public TransporterRoom(final String pDescription, final String pImageName,
                            final GameModel pGameModel)
    {
        super(pDescription, pImageName);
        this.aGameModel = pGameModel;
        this.aRandom = new Random();
    }

    /**
     * Return a random room, independent of the direction
     * parameter.
     * 
     * @param  pDirection Ignored.
     * @return Room A random room. 
     */
    @Override
    public Room getExit(final String pDirection)
    {
        return this.findRandomRoom();
    }
    
    /**
     * Choose a random room.
     * @return Room A random room
     */
    private Room findRandomRoom()
    {
        // get all the rooms created in GameModel
        HashMap<String, Room> vRooms = this.aGameModel.getRooms();
        List<Room> vRoomList = new ArrayList<Room>(vRooms.values()); // NOTE: Or create an arrayList of the keyset
        
        //TODO: restrict vRoomList only to TransporterRoom
        
        // return a random room from the List
        return (Room) vRoomList.get(this.aRandom.nextInt(vRooms.size()));
    }
}
