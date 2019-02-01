package codewars.Merged_String_Checker;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringMergerTest {
  
  @Test
  public void normalHappyFlow() {
    assertTrue("codewars can be created from code and wars", StringMerger.isMerge("codewars", "code", "wars"));
    assertTrue("codewars can be created from cdwr and oeas", StringMerger.isMerge("codewars", "cdwr", "oeas"));
    assertTrue("codewars can be created from cdwr and oeas", StringMerger.isMerge("codewars", "codewars", ""));
    assertFalse("codewars can be created from cdwr and oeas", StringMerger.isMerge("", "", ""));
    assertFalse("codewars can be created from cdwr and oeas", StringMerger.isMerge("codewars", "", ""));
    assertFalse("Codewars are not codwars", StringMerger.isMerge("codewars", "cod", "wars"));
  }
}
