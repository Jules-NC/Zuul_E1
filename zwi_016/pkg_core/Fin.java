package pkg_core;

public class Fin implements Comp{
    public void interract(Player i, Pnj j){
        i.getGameEngine().getGui().println("BRAVO: TU A GAGNEEEEEEEEE");
        i.getGameEngine().endGame();
        j.setComp(new Passif());
    }
}