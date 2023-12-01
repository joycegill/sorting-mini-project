import java.util.Comparator;

/**
 * Sort using my own sort called GillJoyceSort
 * O(n^2) time complexity
 * Compares adjacent elements & swaps as necessary by iterating through the array multiple times
 * 
 * @author Joyce Gill
 */

public class GillJoyceSort implements Sorter {
    
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new GillJoyceSort();

    // +--------------+------------------------------------------------
    // | Constructors |
    // +--------------+

    /**
     * Create a sorter.
     */
    GillJoyceSort() {
  } // GillJoyceSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /* Sort an array using the joyce sort algorithm */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    /* If array is empty */
    if (values == null) {
        return;
    } // if
       
    // Otherwise, sort array using joycesort 
    joyce (values, order);
  } // sort(T[], Comparator<? super T>)

  /* Implementation of joyce sort */
  public <T> void joyce(T[] values, Comparator<? super T> order) {
    int length = (int) (values.length);
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < i; j++) {
        // Swap if i is greater than j 
        if ( (order.compare(values[i], values[j])) < 0) {
          swap(values, i, j);
        } // if
      } // for
    } // for
  } // joyce(T[], Comparator, int, int)

  /* Swaps num1 and num2 */
  public static <T> void swap(T[] vals, int num1, int num2) {
    T temp = vals[num1];
    vals[num1] = vals[num2];
    vals[num2] = temp;
  } // swap(T[], int, int)

} // class GillJoyceSort
