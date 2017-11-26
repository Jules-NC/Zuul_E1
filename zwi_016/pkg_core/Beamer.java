package pkg_core;

public class Beamer extends Item
{
    private Room chargedRoom;
    private boolean charged = false;
    public Beamer(){
        super("beamer",30,"Un portal gun de salles");
    }
    
    public Room getChargedRoom(){
        return this.chargedRoom;
    }
    
    @Override public String charge(){
        if(this.charged == true)
            return("+++problème+++beamer déja chargé+++");
        chargedRoom = player.getRoom();
        this.charged = true;
        return("beamer chargé");
    }

    @Override public String use(){
        if(chargedRoom == null)
            return "+++impossible+++beamer non chargé+++";
        player.setRoom(chargedRoom);
        this.chargedRoom = null;
        player.cutStack();
        return("beamer utilisé");
    }
}