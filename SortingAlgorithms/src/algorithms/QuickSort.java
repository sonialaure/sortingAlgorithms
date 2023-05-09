package algorithms;
import java.util.Random;

public class QuickSort {
	// method to find the partition position
	  static int partition(int array[], int low, int high) {
	    
	    // choose the rightmost element as pivot
	    int pivot = array[high];
	    
	    // pointer for greater element
	    int i = (low - 1);

	    // traverse through all elements
	    // compare each element with pivot
	    for (int j = low; j < high; j++) {
	      if (array[j] <= pivot) {

	        // if element smaller than pivot is found
	        // swap it with the greatr element pointed by i
	        i++;

	        // swapping element at i with element at j
	        int temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	      }

	    }

	    // swapt the pivot element with the greater element specified by i
	    int temp = array[i + 1];
	    array[i + 1] = array[high];
	    array[high] = temp;

	    // return the position from where partition is done
	    return (i + 1);
	  }

	  static void quickSort(int array[], int low, int high) {
	    if (low < high) {

	      // find pivot element such that
	      // elements smaller than pivot are on the left
	      // elements greater than pivot are on the right
	      int pi = partition(array, low, high);
	      
	      // recursive call on the left of pivot
	      quickSort(array, low, pi - 1);

	      // recursive call on the right of pivot
	      quickSort(array, pi + 1, high);
	    }
	  }

	  public static void main(String args[]) {
		  
	    int[] sizes = {10, 100, 1000, 10000, 100000};
		  for (int i = 0; i < sizes.length; i++) {
			  int[] data = generateData(sizes[i]);
		      long startTime = System.nanoTime();
		      int size = data.length;
		      QuickSort.quickSort(data, 0, size - 1);
		      long endTime = System.nanoTime();
		      long duration = (endTime - startTime); 
		      System.out.println("Duration of the QuickSort algorithm with data of size "+ sizes[i] + ": " + duration + " nanoseconds.");
		  }
	  }
	  
	  public static int[] generateData(int size) {
	        int[] arr = new int[size];
	        Random random = new Random();
	        for (int i = 0; i < size; i++) {
	            arr[i] = random.nextInt(1000);
	        }
	        return arr;
	    }
}
