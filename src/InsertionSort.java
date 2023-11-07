import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Joyce Gill
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /* Sort an array using the insertion sort algorithm */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if (values != null) {
      for (int i = 1; i < values.length; i++) {
        // If values[i] is smaller than values[i-1]
        if ( (order.compare(values[i], values[i-1])) <= 0) {
          for (int j = 0; j <= i; j++) {
            // Add to correct position
            if ((order.compare(values[i], values[j])) < 0) {
              swap(values, i, j);
            } // if
          } // for
        } // if
      } // for
    } // if
  } // sort(T[], Comparator<? super T>)

  /* Swaps num1 and num2 */
  public static <T> void swap(T[] vals, int num1, int num2) {
    T temp = vals[num1];
    vals[num1] = vals[num2];
    vals[num2] = temp;
  } // swap(T[], int, int)
} // class InsertionSort
