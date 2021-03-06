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

    /**
     * Return the next {@code State} after {@code state} as determined by the an algorithm found in
     * <a href="http://arxiv.org/abs/1002.2625">Generating and Ranking of Dyck Words</a>.
     *
     * The returned state is meant to be fed into this method again to for a continuous stream of {@code State}s.
     *
     * @param state the {@code State} that is used as a starting ground for the algorithm.
     * @return the {@code State} following {@code state}.
     * @see <a href="http://arxiv.org/abs/1002.2625">Generating and Ranking of Dyck Words</a>
     */
    public State next(State state) {
        int currentLength = state.word.length();
        do {
            if (state.index < state.word.length()) {
                int j = state.index;
                while (j < (state.word.length() - 1) && !state.word.substring(j, j + 2).equals(target)) {
                    j++;
                }
                if (j < (state.word.length() - 1)) {
                    String word = state.word;
                    String nextWord = word.substring(0, j) + replacement + word.substring(j+2);
                    return state.update(j + 2).push(nextWord, j - 1);
                }
            }
            state = state.pop();
        } while(state != null);
        return initialStateOfLength(currentLength + 2);
    }

    public State initialStateOfLength(int n) {
        return new State(initialWordOfLength(n), 0);
    }

    private String initialWordOfLength(int n) {
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < n; index++) {
            builder.append(symbols.get(index % 2));
        }
        return builder.toString();
    }

}
