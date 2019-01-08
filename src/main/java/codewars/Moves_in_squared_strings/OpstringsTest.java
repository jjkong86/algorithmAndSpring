package codewars.Moves_in_squared_strings;

import static org.junit.Assert.*;
import org.junit.Test;

public class OpstringsTest {

    private static void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }
    @Test
    public void test() {
        System.out.println("Fixed Tests vertMirror");
        String s = "hSgdHQ\nHnDMao\nClNNxX\niRvxxH\nbqTVvA\nwvSyRu";
        String r = "QHdgSh\noaMDnH\nXxNNlC\nHxxvRi\nAvVTqb\nuRySvw";
        testing(Opstrings.vertMirror(s), r);
        s = "IzOTWE\nkkbeCM\nWuzZxM\nvDddJw\njiJyHF\nPVHfSx";
        r = "EWTOzI\nMCebkk\nMxZzuW\nwJddDv\nFHyJij\nxSfHVP";
        testing(Opstrings.vertMirror(s), r);
        
        System.out.println("Fixed Tests horMirror");
        s = "lVHt\nJVhv\nCSbg\nyeCt";
        r = "yeCt\nCSbg\nJVhv\nlVHt";        
        testing(Opstrings.horMirror(s), r);
        s = "njMK\ndbrZ\nLPKo\ncEYz";
        r = "cEYz\nLPKo\ndbrZ\nnjMK";
        testing(Opstrings.horMirror(s), r);
    }
}

