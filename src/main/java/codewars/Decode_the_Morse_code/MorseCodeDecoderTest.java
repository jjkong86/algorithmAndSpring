package codewars.Decode_the_Morse_code;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MorseCodeDecoderTest {
    @Test
    public void testExampleFromDescription() {
      assertThat(MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. ."), is("HEY JUDE"));
    }
}
