import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Joyce Gill
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /* Sort an array using the merge sort algorithm */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    /* If array is empty */
    if (values == null) {
      return;
    } // if
    
    /* Otherwise, sort array using merge sort */
    merge (values, 0, values.length, order);
  } // sort(T[], Comparator<? super T>

  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into
   * the same part of the array.
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   */
  static <T> void merge(T[] vals, int lo, int hi, Comparator<? super T> comparator) {
    int mid = (lo + hi) / 2;
    int length = hi - lo;

    /* Base case */
    if (vals == null || length == 0  || length == 1) {
      return;
    } // if

    /* Sort each half recursively */
    merge (vals, lo, mid, comparator);
    merge (vals, mid, hi, comparator);

    T[] arr = Arrays.copyOfRange(vals, lo, hi);
    int left = 0;
    int right = (int) (arr.length / 2);


    for (int i = 0; i < length; i++) {
      /* If left maximizes */
      if (left >= mid - lo && right < length) {
        vals[lo + i] = arr[right];
        right++;
      /* If right maximizes */
      } else if (left < mid-lo && right >= length) {
        vals[lo + i] = arr[left];
        left++;
      /* If left is less than right  */
      } else if (comparator.compare(arr[left], arr[right]) < 0) {
        vals[lo + i] = arr[left];
        left++;
      /* If left is greater than or equal to right */
      } else {
        vals[lo + i] = arr[right];
        right++;
      } // if/else
    } // for

    return;
  } // merge (T[], int, int, Comparator) 

} // class MergeSort
