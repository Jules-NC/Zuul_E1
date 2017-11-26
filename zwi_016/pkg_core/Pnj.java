package pkg_core;

import java.util.ArrayList;
import java.util.Random;
public class Pnj{

    private Room cRoom;
    private Comp comportement = new Fin();
    private String nom;
    //private  ArrayList<Room> allowedRooms = new ArrayList<Room>(0);;
    private  int index = 0;;

    public Pnj(Room r/*, Room... all*/){
        this.nom = "Jean";
        this.cRoom = r;
        //setAllowedRooms(all);
    }
    
    /**
     * @deprecated
     * ne sert à rien
     */
    public void goRoom(/*Room... rS)*/){
        /*for(Room r: rS){
            allowedRooms.add(r);
        }*/
        this.cRoom = cRoom.getAleaExit();
        this.cRoom.addPnj(this);
    }
    
    /**
     * @return le nom de du pnj
     */
    public String getName(){
        return this.nom;
    }

    /**
     * @param r le nom de la room
     * set la room demandée, sauf si elle n'existe pas
     */
    public void setRoom(Room r){
        this.cRoom = r;
    }

    /**
     * @return la roo courrante
     */
    public Room getRoom(){
        return this.cRoom;
    }

    /**
     * @param le comportement du pnj
     * set le comp du pnj
     */
    public void setComp(Comp c){
        this.comportement = c;
    }

    /**
     * @param le player i et le pnj j demandés
     * methode principele permettant d'interragir
     */
    public void interract(Player i, Pnj j){
        comportement.interract(i, this);
    }
}