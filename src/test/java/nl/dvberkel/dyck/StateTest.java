package nl.dvberkel.dyck;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class StateTest {
    public static final String ANY_WORD = "test";
    private static final String DIFFERENT_WORD = "other test";
    public static final int ANY_INDEX = 0;

    @Test
    public void shouldBeCreatedWithAWordAndIndex(){
        State state = new State(ANY_WORD, ANY_INDEX);

        assertThat(state, is(not(nullValue())));
    }

    @Test
    public void shouldBeCreatedByUpdate(){
        int expectedIndex = 3;
        State original = new State(ANY_WORD, ANY_INDEX);

        State state = original.update(expectedIndex);

        assertThat(state, is(new State(ANY_WORD, expectedIndex)));
    }

    @Test
    public void shouldBeCreatedByPush(){
        State original = new State(ANY_WORD, ANY_INDEX);

        State state = original.push(DIFFERENT_WORD, ANY_INDEX);

        assertThat(state, is(new State(new State(ANY_WORD, ANY_INDEX), DIFFERENT_WORD, ANY_INDEX)));
    }

    @Test
    public void shouldBeCreatedByPop(){
        State original = new State(ANY_WORD, ANY_INDEX);
        State pushed = original.push(DIFFERENT_WORD, ANY_INDEX);

        State state = pushed.pop();;

        assertThat(state, is(original));
    }
}
