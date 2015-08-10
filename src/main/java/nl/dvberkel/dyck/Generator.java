package nl.dvberkel.dyck;

import java.util.Arrays;
import java.util.List;

public class Generator {
    private final List<String> symbols;
    private final String target;
    private final String replacement;

    public Generator(){
        this("1", "2");
    }

    public Generator(String left, String right) {
        this.symbols = Arrays.asList(left, right);
        this.target = symbols.get(1) + symbols.get(0);
        this.replacement = symbols.get(0) + symbols.get(1);
    }

    public State next(State state) {
        if (state.index() < state.word().length()) {
            int j = state.index();
            while (j < (state.word().length() - 1) && !state.word().substring(j, j + 2).equals(target)) {
                j++;
            }
            if (j < (state.word().length() - 1)) {
                throw new IllegalStateException("This does not happen yet");
            }
        }
        return new State(initialWordOfLength(state.word().length() + 2), 0);
    }

    private String initialWordOfLength(int n) {
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < n; index++) {
            builder.append(symbols.get(index % 2));
        }
        return builder.toString();
    }

}
