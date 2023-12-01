import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Joyce Gill
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /* Sort an array using the quick sort algorithm */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    /* If array is empty */
    if (values == null) {
      return;
    } // if
    
    /* Otherwise, sort array using quick sort */
    quicksort (values, order, 0, values.length);
  } // sort(T[], Comparator<? super T>

  /* Sort the values in indices [lb..ub) of values using order to compare values. */
  public <T> void quicksort(T[] values, Comparator<? super T> order, int lb, int ub) {
    // Subarrays of one element or fewer are sorted.
    if (lb >= ub - 1) {
      return;
    } else {
      int mid = partition (values, order, lb, ub);
      quicksort (values, order, lb, mid);
      quicksort (values, order, mid + 1, ub);
    } // if/else
  } // quicksort(T[], Comparator, int, int)

  /*  Select a partition */
  private <T> int partition(T[] arr, Comparator<? super T> compare, int lb, int ub) {
    /* Set pivot */
    int pivot = (int)((ub + lb) / 2); 

    /* Swap the pivot with the first element */
    GillJoyceSort.swap(arr, pivot, lb); 

    int small = lb + 1;
    int large = ub-1;
   
    /* Continue until small and large are the same */
    while (small < large){
      /* Update small if small is less than lb */
      if (compare.compare(arr[lb], arr[small]) > 0) { 
        small++; 
      /* Update large is large is greater than or equal to lb */
      } else if(compare.compare(arr[lb], arr[large]) <= 0) {
        large--;
      /* Otherwise, swap */
      }else {
        GillJoyceSort.swap(arr, small, large);
      } // if/else
    } // while
    
    /* When small >= large, swap the pivot with small/large */
    if(compare.compare(arr[lb], arr[large]) >= 0) {
      pivot = large;
    }else {
      pivot = small - 1;
    } // if/else
    GillJoyceSort.swap (arr, lb, pivot); 

    /* Return the location of the pivot */
    return pivot; 
  } // partition(T[], Comparator, int, int)
} // class Quicksort
