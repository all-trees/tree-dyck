package nl.dvberkel.dyck;

public class State {
    private final State parent;
    private final String word;
    private final int index;

    public State(String word, int index) {
        this.parent = null;
        this.word = word;
        this.index = index;
    }

    public State(State parent, String word, int index) {

        this.parent = parent;
        this.word = word;
        this.index = index;
    }

    public State update(int index) {
        return new State(word, index);
    }

    public State push(String word, int index) {
        return new State(this, word, index);
    }

    public State pop() {
        return parent;
    }

    public String word() {
        return word;
    }

    public int index() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        State state = (State) o;

        if (index != state.index) return false;
        if (parent != null ? !parent.equals(state.parent) : state.parent != null) return false;
        return word.equals(state.word);

    }

    @Override
    public int hashCode() {
        int result = parent != null ? parent.hashCode() : 0;
        result = 31 * result + word.hashCode();
        result = 31 * result + index;
        return result;
    }

    @Override
    public String toString() {
        if (parent != null) {
            return String.format("State{word='%s', index=%d, parent=%s}", word, index, parent);
        }
        return String.format("State{word='%s', index=%d}", word, index);
    }
}
