package pkg_commands;

import java.util.Scanner;
import java.io.File;
import pkg_core.Player;

public class TestCommand extends Command
{

    public TestCommand()
    {
    }

    public void execute (Player player){
        if(secondWord == null)
            player.getGameEngine().getGui().println("+++tester+++test en cours+++test en cours+++test echec+++rien dans les archives+++avez vous de l'eau?+++");
        //Command testCommand;
        //String nomDuFichier = "tests.txt";
        Scanner in = null;
        File fichier = new File(secondWord);

        try{
            in = new Scanner(fichier);
        }
        catch(Exception e){player.getGameEngine().getGui().println("+++tester+++test en cours+++probleme+++reprise du début+++");}

        while(in.hasNextLine()){
            player.getGameEngine().interpretCommand(in.nextLine());
        }
        //Command cmd2 = parser.getCommand(cmd1);
        //interpretCommand(cmd1);
        player.getGameEngine().getGui().println("+++efféctué+++succes impossible à obtenir+++voyez vous mêmes+++");
    }
}
