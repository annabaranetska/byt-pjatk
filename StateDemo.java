import java.io.IOException;
import java.util.Scanner;

abstract class State {
    public void pull(Chain wrapper) {
        wrapper.setState(new Off());
        System.out.println("turning off");
    }
}

class Chain {
    private State current;

    public Chain() {
        current = new Off();
    }

    public void setState(State state) {
        current = state;
    }

    public void pull() {
        current.pull(this);
    }
}

class Off extends State {
    public void pull(Chain wrapper) {
        wrapper.setState(new Low());
        System.out.println( "low state");
    }
}

class Low extends State {
    public void pull(Chain wrapper) {
        wrapper.setState(new Medium());
        System.out.println("medium state");
    }
}

class Medium extends State {
    public void pull(Chain wrapper) {
        wrapper.setState(new High());
        System.out.println("high state");
    }
}

class High extends State { }


public class StateDemo {
    public static void main(String[] args) {
        Scanner is = new Scanner(System.in);
        Chain chain = new Chain();


            System.out.println("Press ANY KEY to change the state");
            System.out.println("Press Q to exit");
            while(!(is.nextLine().equals("q"))){
                chain.pull();
            }
    }
}