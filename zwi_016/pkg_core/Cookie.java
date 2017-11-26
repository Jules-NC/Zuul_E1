package pkg_core;

public class Cookie extends Item
{
    private static boolean used = false;

    public Cookie(){
        super("cookie22",3,"Un cookie qui marche");
    }

    @Override public String use(){
        if(used == false){
            player.addInv(10);
            this.name = "cookie grignoté";
            this.used = true;
            return "miam, tu a mangé !";
        }
        return "NON";
    }
}