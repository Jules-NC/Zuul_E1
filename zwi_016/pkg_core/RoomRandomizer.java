package pkg_core;

import java.util.ArrayList;
import java.util.Random;

public class RoomRandomizer
{
    private static ArrayList<Room> allowedRooms;

    static{
        allowedRooms = new ArrayList<Room>(0);
    }

    /**
     * permet d'ajouter autant de rooms qu'on veut pour la aléa room
     * @param autant de rooms qu'on veur
     */
    public static void addAllowedRoom(Room... rs){
        for(Room r : rs){
            allowedRooms.add(r);
        }
    }

    /**
     * @return une room random parmis celles ajoutées
     * cool
     */
    public static Room findRandomRoom(){
        Random a = new Random();
        int i = -1;
        if(RoomRandomizer.allowedRooms.size()>0)
            i =  a.nextInt(RoomRandomizer.allowedRooms.size()-1);

        if(i != 0)
            i--;
        return allowedRooms.get(i);
        //return RoomRandomizer.allowedRooms.size();
    }
}
