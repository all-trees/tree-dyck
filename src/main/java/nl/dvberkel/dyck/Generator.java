package nl.dvberkel.dyck;

import java.util.Arrays;
import java.util.List;

public class Generator {
    private final List<String> symbols;

    public Generator(){
        this("1", "2");
    }

    public Generator(String left, String right) {
        this.symbols = Arrays.asList(left, right);
    }

    public State next(State state) {
        return new State(initialWordOfLength(state.word.length() + 2), 0);
    }

    private String initialWordOfLength(int n) {
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < n; index++) {
            builder.append(symbols.get(index % 2));
        }
        return builder.toString();
    }

}
