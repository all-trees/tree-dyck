package nl.dvberkel.dyck;

public class State {
    private final String word;
    private final int index;

    public State(String word, int index) {
        this.word = word;
        this.index = index;
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
        return word.equals(state.word);

    }

    @Override
    public int hashCode() {
        int result = word.hashCode();
        result = 31 * result + index;
        return result;
    }

    @Override
    public String toString() {
        return String.format("State{word='%s', index=%d}", word, index);
    }
}
