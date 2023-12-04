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
    //  If array is empty 
    if (values == null) {
      return;
    } // if

    // Otherwise, sort array using merge sort 
    T[] arr = Arrays.copyOf(values, values.length);
    merge (values, 0, values.length, arr, order);
  } // sort(T[], Comparator<? super T>

  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into
   * the same part of the array.
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   */
  static <T> void merge(T[] vals, int lo, int hi, T[] arr, Comparator<? super T> comparator) {
    int length = hi - lo;

    // Base case 
    if (length <= 1 || vals == null) {
      return;
    } // if

    // Sort each half recursively 
    int mid = lo + length / 2;
    merge(vals, lo, mid, arr, comparator);
    merge(vals, mid, hi, arr, comparator);

    int left = lo;
    int right = mid;
    int idx = lo;
    
    // Merge the two sorted halves
    while (left < mid || right < hi) {
      if (left >= mid) {
        arr[idx++] = vals[right++];
      } else if (right >= hi) {
        arr[idx++] = vals[left++];
      } else if (comparator.compare(vals[left], vals[right]) < 0) {
        arr[idx++] = vals[left++];
      } else {
        arr[idx++] = vals[right++];
      } // if/else
    } // while

    // Copy merged values back to the original array
    System.arraycopy(arr, lo, vals, lo, length);
  } // mergeSort (T[], int, int, T[], Comparator)

} // class MergeSort
