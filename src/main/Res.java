package main;

/**
 * Created by Emmanuel H on 01/02/17.
 */
public class Res {
    private Etat etat;
    private String valeur;
    private char direction;

    public Res(Etat etat,String valeur, char direction){
        this.etat = etat;
        this.valeur = valeur;
        this.direction = direction;
    }

    public String getValeur() {
        return valeur;
    }

    @Override
    public String toString() {
        return etat.getNom() + " " + valeur + " " + direction;
    }
}
