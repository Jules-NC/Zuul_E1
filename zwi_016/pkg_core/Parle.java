package pkg_core;

public class Parle implements Comp{
    public void interract(Player i, Pnj j){
        i.getGameEngine().getGui().println("JE PARLE BIEN BIEN BIEN BIEN ET OUI ET JE NE DIRAI PLUS RIEN");
        j.setComp(new Passif());
    }
}