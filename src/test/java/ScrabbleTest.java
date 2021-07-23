import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.File;

public class ScrabbleTest {
    @Test
    public void instantiateTest() {
        new Scrabble();
    }

    @Test
    // specify a dictionary to scan
    public void dictionaryScanTest() {
        File dictionary = new File("words_alpha.txt");
        assertTrue(dictionary.canRead());
    }

    @Test
    // specify available tiles to match
    public void specifyTilesTest() {
        String tiles = "words";
    }

    @Test
    public void alphabetizeRunsTest() {
        Scrabble.alphabetize("cat");
    }

    @Test
    public void alphabetizeTest() {
        String expected = "act";
        String actual = Scrabble.alphabetize("cat");
        assertEquals(expected, actual);
    }
}
