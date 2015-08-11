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
    private State expectedState;
    private State state;

    public GeneratorTest(State state, State expectedState) {
        this.state = state;
        this.expectedState = expectedState;
    }

    @Test
    public void shouldGenerateAllDyckWords(){
        Generator generator = new Generator();

        State nextState = generator.next(state);

        assertThat(nextState, is(expectedState));
    }

    @Parameterized.Parameters(name = "next(\"{0}\") is \"{1}\"")
    public static Collection<Object[]> data(){
        Collection<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[]{ new State("", 0), new State("12", 0) });
        data.add(new Object[]{ new State("12", 0), new State("1212", 0) });
        data.add(new Object[]{ new State("1212", 0), new State(new State("1212", 3), "1122", 0) });
        data.add(new Object[]{ new State(new State("1212", 3), "1122", 0), new State("121212", 0) });
        data.add(new Object[]{ new State("121212", 0), new State(new State("121212", 3), "112212", 0) });
        data.add(new Object[]{ new State(new State("121212", 3), "112212", 0), new State(new State(new State("121212", 3), "112212", 5), "112122", 2) });
        data.add(new Object[]{
                new State(new State(new State("121212", 3), "112212", 5), "112122", 2),
                new State(new State(new State(new State("121212", 3), "112212", 5), "112122", 4), "111222", 1)
        });
        data.add(new Object[]{
                new State(new State(new State(new State("121212", 3), "112212", 5), "112122", 4), "111222", 1),
                new State(new State("121212", 5), "121122", 2),
        });
        return data;
    }
}
