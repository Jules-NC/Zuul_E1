package pkg_engine;

import java.io.*;
import java.util.Scanner;;
import java.util.ArrayList;
import pkg_commands.Parser;
/*import pkg_core.Player;
import pkg_core.Room;
import pkg_core.TransporterRoom;
import pkg_core.RoomRandomizer;*/
import pkg_core.*;
import pkg_commands.Command;

public class GameEngine
{
    private Parser parser;
    private UserInterface gui;
    //private Stack<Room> chemin;
    private Player player;

    /**
     * Constructeur de GameEngine(). qui cree un objet GameEngine.
     */
    public GameEngine()
    {
        parser = new Parser();
        player = new Player(this);
        createRooms();
    }

    /**
     * @param uI l'UserInterface qui sera liee a l'objet courant.
     */
    public void setGUI(UserInterface pUserInterface)
    {
        this.gui = pUserInterface;
        printWelcome();
    }

    /**
     * @return l'userInterface
     */
    public UserInterface getGui(){
        return this.gui;
    }

    /**
     * Affiche le message d'into du jeu.
     */
    private void printWelcome()
    {
        gui.print("\n");
        gui.println("+++bienvenue+++");
        gui.print("+++introduction+++la tortue est une femelle+++\n");
        gui.println(player.getRoom().getLongDescription());
        gui.showImage(player.getRoom().getImageName());
    }

    /**
     * Cree toutes les rooms, les lies ensemble et initialise les objets contenues dans celles ci.
     */
    private void createRooms()
    {
        Room outside, theatre, pub, lab, office, random, fin;

        // create the rooms
        outside = new Room("Sur une plaine divagante ou l'esprit se perd", "Images/outside.jpg");
        random = new TransporterRoom();
        theatre = new Room("Devant le chateau le plus imposant que vous ayez jamais vus !", "Images/castle.jpg");
        pub = new Room("in the campus pub", "Images/courtyard.jpg",true);
        lab = new Room("in a computing lab", "Images/stairs.jpg");
        office = new Room("the computing admin office", "Images/dungeon.jpg");
        fin = new Room("FIN", "Images/win.jpg");

        
        Item pistolet =  new Item("pistolet",62,"le criquet");
        Item epee = new Item("epee", 21,"Hiéroglyphe");
        Item beamer = new Beamer();
        Item cookie = new Item("cookie",1,"ca donne fin, tu va mourrir");
        Item cookie2 = new Cookie();
        
        RoomRandomizer.addAllowedRoom(outside, theatre, lab,random, office, pub);
        //System.out.println(RoomRandomizer.findRandomRoom());
        // initialise room exits
        outside.setExit("east", theatre);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        outside.setExit("north",random);
        outside.getItemList().addItem(pistolet);
        outside.getItemList().addItem(epee);
        outside.getItemList().addItem(beamer);
        outside.getItemList().addItem(cookie);
        outside.getItemList().addItem(cookie2);

        Pnj p1= new Pnj(outside);
        outside.addPnj(p1);

        theatre.setExit("west", outside);
        pub.setExit("east", outside);
        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        player.setRoom(outside);  // start game outside
        //chemin.push(player.getRoom());
    }

    /**
     * @param commandLine une String @see String correspondant a la commande voulue.
     * 
     * Verifie que la String passee en parametre corresponde a un premier mot 
     * de commande valide et execute une commande en fonction de cette commande
     */
    public void interpretCommand(String pInput) 
    {
        gui.println(pInput);
        Command cmd = parser.getCommand(pInput);
        if(cmd == null)
            gui.println("+++erreur+++ne comprend pas ce que vous voulez dire+++manque du fromage+++");
        else{
            cmd.execute(player);

            if(player.getRoom().getImageName() != null)
                gui.showImage(player.getRoom().getImageName());

            if(player.hasLoose())
                gui.showImage("Images/loose.jpg");

            if(player.hasWin())
                gui.showImage("Images/loose.jpg");

        }
    }

    /**
     * Affiche un message de bienvenue de partance quand le jeu est quitte.
     */
    public void endGame()
    {
        gui.println("+++aurevoir+++");
        //gui.showImage("Images/loose.jpg");
        gui.enable(false);
    }
}
