package main;

/**
 * Created by Emmanuel H on 01/02/17.
 */
public class Res {
    private State state;
    private String value;
    private char movement;

    public Res(State state, String value, char movement){
        this.state = state;
        this.value = value;
        this.movement = movement;
    }

    public String getValue() {
        return value;
    }

    public State getState() {
        return state;
    }

    public char getMovement() {
        return movement;
    }

    @Override
    public String toString() {
        return state.getName() + " " + value + " " + movement;
    }
}
