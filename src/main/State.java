package main;

import java.util.HashMap;

/**
 * Created by Emmanuel H on 01/02/17.
 */
public class State {
    private HashMap<String,Res> childs;
    private String name;
    private boolean acceptance;

    public State(String name, boolean acceptance){
        this.name = name;
        this.acceptance = acceptance;
        this.childs = new HashMap<>();
    }

    public void addChild(String valeur, Res res){
        this.childs.put(valeur,res);
    }

    public boolean getChild(String valeur){
        return this.childs.containsKey(valeur);
    }

    public Res getRes(String valeur){
        return this.childs.get(valeur);
    }

    @Override
    public boolean equals(Object o) {
        return this.name.equals(((State)o).getName());
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name + this.childs;
    }

    public boolean isAcceptance() {
        return acceptance;
    }
}
