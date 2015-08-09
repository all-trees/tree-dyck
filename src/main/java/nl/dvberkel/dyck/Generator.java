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

    public String next(String word) {
        return initialWordOfLength(word.length() + 2);
    }

    private String initialWordOfLength(int n) {
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < n; index++) {
            builder.append(symbols.get(index % 2));
        }
        return builder.toString();
    }

}
