package pkg_core;

public class Passif implements Comp{
    public void interract(Player i, Pnj j){
        i.getGameEngine().getGui().println("+++Pas de réaction+++");
    }
}
