package codewars.Directions_Reduction;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runners.JUnit4;

public class DirReductionTest {
  @Test
  public void testSimpleDirReduc() {        
    assertArrayEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
          new String[]{"WEST"},
          DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
    assertArrayEquals("\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\"",
          new String[]{},
          DirReduction.dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"}));
    assertArrayEquals("\"NORTH\",\"WEST\",\"SOUTH\",\"EAST\"",
          new String[]{"\"NORTH\",\"WEST\",\"SOUTH\",\"EAST\""},
          DirReduction.dirReduc(new String[]{"\"NORTH\",\"WEST\",\"SOUTH\",\"EAST\""}));
  }
}
