package pkg_core;

public class Item
{
    protected String name;
    private int aWeight;
    private String aDescription;
    protected Player player;

    /**
     * @param nom une String correspondant au nom de l'objet.
     * @param poids un int correspondant au poids de l'objet.
     * @param descript une String correspondant à la description de l'objet.
     * 
     * Cree un item en fonction des parametres.
     */
    public Item(String nom, int poids, String descript){
        this.name = nom;
        this.aWeight = poids;
        this.aDescription = descript;
    }

    /**
     * assigne un item à un player
     */
    public void setPlayer(Player p){
        this.player = p;
    }

    /**
     * @return la string d'utilisation d'après
     * en fait ca sert à rien ici
     */
    public String use(){
        return "+++impossible+++objet non utilisable+++";
    }
    
    /**
     * @return une String lambda nulle
     * ne sert à rien
     */
    public String charge(){
        return "+++interdiction+++de charger cet objet+++";
    }
    
    /**
     * @return une String contenant le nom de l'objet courant.
     */
    public String getName(){
        return this.name;
    }

    /**
     * return un int contenant le poids de l'objet courant.
     */
    public int getWeight(){
        return this.aWeight;
    }

    /**
     * @return une String contenant la description de l'objet courant.
     */
    public String getDescription(){
        return this.aDescription;
    }

    /**
     * @return une String contenant le poids, la descriotion et le nom de l'objet.
     */
    public String getLongDescription(){
        return "Nom:"+ this.name+ " |Poids:" + this.aWeight + " |Description:" + getDescription();
    }
}
