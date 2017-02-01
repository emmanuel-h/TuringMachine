package main;

import java.util.HashMap;

/**
 * Created by Emmanuel H on 01/02/17.
 */
public class Etat {
    private HashMap<String,Res> enfants;
    private String nom;
    private boolean acceptation;

    public Etat(String nom, boolean acceptation){
        this.nom = nom;
        this.acceptation = acceptation;
        enfants = new HashMap<>();
    }

    public void ajouterEnfant(String valeur, Res res){
        enfants.put(valeur,res);
    }

    @Override
    public boolean equals(Object o) {
        return this.nom.equals(((Etat)o).getNom());
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return this.nom + enfants;
    }
}
