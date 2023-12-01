import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Joyce Gill
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // reverseOrderedStringTest

  @Test
  public void emptyTest() {
    String[] original = { };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // emptyTest 

  @Test
  public void oneStringTest() {
    String[] original = { "alpha" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // oneStringTest

  @Test
  public void duplicateTest() {
    String[] original = { "alpha", "bravo", "bravo", "foxtrot", "alpha" };
    String[] expected = { "alpha", "alpha", "bravo", "bravo", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // duplicateTest


  @Test
  public void mixedTest() {
    String[] original = { "alpha", "", "bravo", "", "alpha" };
    String[] expected = { "", "", "alpha", "alpha", "bravo" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // mixedTest

  @Test
  public void intTest() {
    Integer[] original = {3, 1, 5, 2, 4};
    Integer[] expected = {1, 2, 3, 4, 5};
    sorter.sort(original, (x, y) -> (x == y ? 0 : x < y ? -1 : 1));
    assertArrayEquals(original, expected);
  } // intTest

  @Test
  public void arrayTest() {
    Integer[] original = new Integer[100];
    for (int i = 0; i < original.length; i++)
    {
      original[i] = original.length - i - 1;
    }
    Integer[] expected = new Integer[100];
    for (int i = 0; i < 100; i++)
    {
      expected[i] = i;
    }

    sorter.sort(original, (x, y) -> (x == y ? 0 : x < y ? -1 : 1));
    assertArrayEquals(original, expected);
  } // arrayTest
  
} // class SortTester
