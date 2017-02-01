package main;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {


    private static LinkedList<String> bande;
    private static int length;
    private static int tete;
    private static Etat[] etats;
    private static int nb_etats;

    private static void lancer_programme() {
        String valeur_actuelle = bande.get(tete);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Données de la bande
        bande = new LinkedList<>();
        System.out.println("Données de la bande");
        String donnees = sc.nextLine();
        length = donnees.length();
        String delim = " ";
        // On découpe la ligne suivant le délimiteur "espace"
        StringTokenizer tok = new StringTokenizer(donnees, delim);
        for (; tok.hasMoreTokens();) {
            bande.addLast(tok.nextToken().toString());
        }

        // Position de la tête de lecture
        System.out.println("Position de la tête de lecture");
        tete = sc.nextInt();

        // Donner le nombre d'états
        System.out.println("Nombre d'états");
        nb_etats = sc.nextInt();
        sc.nextLine();
        etats = new Etat[nb_etats+1];
        Etat etat;
        // On rajoute tous les états de q0 à qn
        for(int i=0 ; i<nb_etats ; i++){
            etat = new Etat("q"+i,false);
            etats[i]=etat;
        }
        // On rajoute un dernier état comportant l'état acceptant
        etats[nb_etats] = new Etat("qoui",true);

        // Donner les transitions
        // "q0 q0 1 1 gmd"

        String source=null;
        String destination=null;
        String valeur_initiale=null;
        String valeur_finale=null;
        char deplacement=0;

        int num_source=-1;
        int num_destination=-1;
        Etat etat_source=null;
        Etat etat_destination=null;
        Res res=null;

        System.out.println("Rajouter des transitions de la forme : q0 q1 a b gmd");
        String s = sc.nextLine();
        while(!"non".equals(s)) {
            tok = new StringTokenizer(s, delim);

            source = tok.nextToken().toString();
            destination = tok.nextToken().toString();
            valeur_initiale = tok.nextToken().toString();
            valeur_finale = tok.nextToken().toString();
            deplacement = tok.nextToken().toString().charAt(0);

            num_source = Integer.parseInt(source.substring(1));
            num_destination = Integer.parseInt(destination.substring(1));
            etat_source = etats[num_source];
            etat_destination = etats[num_destination];
            res = new Res(etat_destination,valeur_finale,deplacement);
            etat_source.ajouterEnfant(valeur_initiale,res);

            System.out.println("Rajouter les transitions. Marquer non pour finir");
            s = sc.nextLine();
        }
        for(int i=0 ; i<nb_etats+1 ; i++){
            System.out.println(etats[i]);
        }
        lancer_programme();
    }
}
