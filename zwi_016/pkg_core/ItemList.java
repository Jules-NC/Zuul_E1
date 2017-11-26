package pkg_core;

import java.util.ArrayList;
public class ItemList
{
    private ArrayList<Item> items;

    public ItemList(){
        items = new ArrayList<Item>(0);
    }

    public Item getItem(String s){
        Item res = null;
        for(Item i : items){
            if(i.getName().equals(s))
                res = i;
        }
        return res;
    }

    public void addItem(Item i){
        items.add(i);
    }

    public void removeItem(String s){
        Item r = null;
        for(Item i : items){
            if(i.getName().equals(s)){
                r = i;
            }
        }
        if(r != null)
            items.remove(r);
    }
    
    public String desc(){
        String res = "";
        for(Item i : items){
            res += "        |"+i.getLongDescription()+"\n";
        }
        if(res.equals(""))
            return "+++pas d'objets+++";
        return res;
    }
    
    public boolean hasItem(String s){
        boolean res = false;
        for(Item i : items){
            if(i.getName().equals(s)){
                res = true;
            }
        }
        return res;
    }
    
} // ItemList