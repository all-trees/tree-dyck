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
    private String word;

    public GeneratorTest(String word, String expectedWord) {
        this.word = word;
        this.expectedWord = expectedWord;
    }

    @Test
    public void shouldGenerateAllDyckWords(){
        Generator generator = new Generator();

        String nextWord = generator.next(word);

        assertThat(nextWord, is(expectedWord));
    }

    @Parameterized.Parameters(name = "next(\"{0}\") is \"{1}\"")
    public static Collection<Object[]> data(){
        Collection<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[]{ "", "12" });
        data.add(new Object[]{ "12", "1212" });
        return data;
    }
}
