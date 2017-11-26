package pkg_core;

import pkg_engine.GameEngine;
import java.util.HashMap;
import java.util.Stack;
import pkg_commands.*;

public class Player
{
    private Room aCurrentRoom;
    int aPoids = 0;
    private ItemList items;
    private static int maxPoids = 50;
    private Stack<Room> chemin;
    private int fatigue = 0;
    private GameEngine gEngine;

    private boolean loose = false;
    private boolean win = false;

    /**
     * Construit un nouveau joueur.
     */
    public Player(){
        chemin = new Stack<Room>();
        items = new ItemList();
    }

    public Player(GameEngine g){
        chemin = new Stack<Room>();
        items = new ItemList();
        gEngine  = g;
    }

    public GameEngine getGameEngine(){
        return this.gEngine;
    }

    /**
     * ajoute de la fatigue
     */
    public void addFatigue(){
        this.fatigue++;
    }

    /**
     * @return la fatigue du player
     */
    public int getFatigue(){
        return this.fatigue;
    }

    public void addInv(int a){
        this.maxPoids += a;
    }

    /**
     * Permet d'ajouter un item a l'inventaire du joueuer.
     * 
     * @param une String du nom que portera l'item dans l'inventaire du joueur.
     * @param un Item qui sera associe a ce nom. @see Item.
     */
    public ItemList getItemList(){
        return this.items;
    }

    /**
     * @return un message disant comment on a utilsié le objet
     */
    public String use(String objName){
        if(this.getItemList().hasItem(objName) == false)
            return("+++traitement en cours+++problème survenu+++non trouvé+++reprise du début+++");
        return this.getItemList().getItem(objName).use();
    }

    /**
     * charge
     */
    public String charge(String objName){
        if(this.getItemList().hasItem(objName) == false)
            return("+++cherche+++erreur+++item non trouvé+++");
        return this.getItemList().getItem(objName).charge();
    }

    /**
     * @return l'inventaire du player keur
     */
    public String getInventaire(){
        String res = "|Inventaire:\n"+items;
        return res;
    }

    /**
     * met la win à 1
     */
    public void setWin(){
        this.win = true;
    }

    /**
     * @return true si victoire et non sinon
     */
    public boolean hasWin(){
        return this.win;
    }

    /**
     *  @param la room associee au joueur.
     */
    public void setRoom(Room room){
        this.addFatigue();
        this.aCurrentRoom = room;
        this.chemin.push(this.aCurrentRoom);
        //System.out.println(fatigue);
        if(fatigue > 15){
            Command a = new EndCommand();
            a.execute(this);
            this.loose = true;

        }

    }

    /**
     * @return return l'état de loose
     */
    public boolean hasLoose(){
        return loose;
    }

    /**
     * 
     * @return une String de message du genre("je suis repu mama mia").
     */
    public String eat(){
        if(items.hasItem("cookie")){
            this.maxPoids += 50;
            return "+++mange+++";
        }
        return "+++pas de cookie :(+++";
    }

    /**
     * @return la salle ou se trouve le joueur.
     */
    public Room getRoom(){
        return aCurrentRoom;
    }

    /**
     * revient a la salle precedente si elle existe.
     */
    public String back(){
        if(this.chemin.empty() == true || this.chemin.size() <= 1){
            return ("+++tentative+++retour en arrière+++retour impossible+++");
        }

        chemin.pop();
        this.aCurrentRoom = this.chemin.peek();
        return this.aCurrentRoom.getLongDescription();
    }

    /**
     * vide la stack
     */
    public void cutStack(){
        while(chemin.isEmpty() == false){
            chemin.pop();
        }
    }

    public String take(String s){
        Item i = this.aCurrentRoom.getItemList().getItem(s);
        this.aCurrentRoom.getItemList().removeItem(s);
        if(i != null && i.getWeight()+this.aPoids < this.maxPoids){
            this.items.addItem(i);
            this.aPoids += i.getWeight();
            i.setPlayer(this);
            return "+++pris+++";
        }
        return "+++erreur++pas pris+++";
    }

    public String drop(String s){
        Item i = this.items.getItem(s);
        this.items.removeItem(s);
        if(i != null){
            this.aCurrentRoom.getItemList().addItem(i);
            this.aPoids += -i.getWeight();
            return "+++posé+++";
        }
        return"+++non+++erreur+++";
    }

    public String pdsCourr(){
        return ""+this.aPoids+"/"+this.maxPoids+" kg";
    }
}
