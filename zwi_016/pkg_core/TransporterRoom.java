package pkg_core;

public class TransporterRoom extends Room{
    private static Room alea = null;

    /**
     * crée une transpoeter room
     */
    public TransporterRoom(){
        super("Une transporter Room","Images/hallway.png",true);
    }
    
    /**
     * set une room alea
     */
    public static void setAleaRoom(Room r){
        alea = r;
    }

    /**
     * @return uen room aleatoire parmis les exits mises dans RoomRandomizer
     * @see RoomRandomizer
     */
    @Override public Room getExit(String direction){
        if(alea == null)
            return RoomRandomizer.findRandomRoom();
        return alea;
    }
}