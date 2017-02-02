package main;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {


    private static LinkedList<String> tape;
    private static int length;
    private static int head_position;
    private static String head_value;
    private static State[] states;
    private static int nb_states;

    private static boolean launch_program() {
        head_value= tape.get(head_position);
        int etat_actuel = 0;
        if(!states[etat_actuel].getChild(head_value)){
            return false;
        }
        Res res = states[etat_actuel].getRes(head_value);
        if(!res.getValue().equals(head_value)){
            tape.set(head_position,res.getValue());
        }
        if(res.getMovement() == 'g'){

        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Tape's data
        tape = new LinkedList<>();
        System.out.println("Tape's data");
        String data = sc.nextLine();
        length = data.length();
        String delim = " ";
        // Cut the ligne relative to space char
        StringTokenizer tok = new StringTokenizer(data, delim);
        for (; tok.hasMoreTokens();) {
            tape.addLast(tok.nextToken().toString());
        }

        // Position of the head
        head_position = 0;

        // Number of states
        System.out.println("Number of states");
        nb_states = sc.nextInt();
        sc.nextLine();
        states = new State[nb_states+1];
        State state;
        // Add all states from q0 to qn
        for(int i=0 ; i<nb_states ; i++){
            state = new State("q"+i,false);
            states[i]=state;
        }
        // Add a last state qyes which is the acceptance state
        states[nb_states] = new State("qyes",true);

        // Give transitions

        String source=null;
        String destination=null;
        String initial_value=null;
        String final_value=null;
        char movement=0;

        int num_source=-1;
        int num_destination=-1;
        State state_source=null;
        State state_destination=null;
        Res res=null;

        System.out.println("Add transitions following the pattern : q0 q1 a b lsr");
        String s = sc.nextLine();
        while(!"no".equals(s)) {
            tok = new StringTokenizer(s, delim);

            source = tok.nextToken().toString();
            destination = tok.nextToken().toString();
            initial_value = tok.nextToken().toString();
            final_value = tok.nextToken().toString();
            movement = tok.nextToken().toString().charAt(0);

            num_source = Integer.parseInt(source.substring(1));
            num_destination = Integer.parseInt(destination.substring(1));
            state_source = states[num_source];
            state_destination = states[num_destination];
            res = new Res(state_destination,final_value,movement);
            state_source.addChild(initial_value,res);

            System.out.println("Add transitions. Type no to end");
            s = sc.nextLine();
        }
        for(int i=0 ; i<nb_states+1 ; i++){
            System.out.println(states[i]);
        }
        launch_program();
    }
}
