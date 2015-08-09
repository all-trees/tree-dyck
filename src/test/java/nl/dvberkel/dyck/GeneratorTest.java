package nl.dvberkel.dyck;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class GeneratorTest {
    private String expectedWord;
    private State state;

    public GeneratorTest(State state, String expectedWord) {
        this.state = state;
        this.expectedWord = expectedWord;
    }

    @Test
    public void shouldGenerateAllDyckWords(){
        Generator generator = new Generator();

        State nextState = generator.next(state);

        assertThat(nextState.word, is(expectedWord));
    }

    @Parameterized.Parameters(name = "next(\"{0}\") is \"{1}\"")
    public static Collection<Object[]> data(){
        Collection<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[]{ new State("", 1), "12" });
        data.add(new Object[]{ new State("12", 1), "1212" });
        return data;
    }
}
