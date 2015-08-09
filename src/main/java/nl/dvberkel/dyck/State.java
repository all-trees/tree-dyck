package nl.dvberkel.dyck;

public class State {
    public final String word;
    public final int index;

    public State(String word, int index) {
        this.word = word;
        this.index = index;
    }
}
