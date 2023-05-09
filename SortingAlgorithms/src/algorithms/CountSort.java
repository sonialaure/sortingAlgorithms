package algorithms;
import java.util.Random;

public class CountSort {
	void countSort(int array[], int size) {
	    int[] output = new int[size + 1];

	    // Find the largest element of the array
	    int max = array[0];
	    for (int i = 1; i < size; i++) {
	      if (array[i] > max)
	        max = array[i];
	    }
	    int[] count = new int[max + 1];

	    // Initialize count array with all zeros.
	    for (int i = 0; i < max; ++i) {
	      count[i] = 0;
	    }

	    // Store the count of each element
	    for (int i = 0; i < size; i++) {
	      count[array[i]]++;
	    }

	    // Store the cummulative count of each array
	    for (int i = 1; i <= max; i++) {
	      count[i] += count[i - 1];
	    }

	    // Find the index of each element of the original array in count array, and
	    // place the elements in output array
	    for (int i = size - 1; i >= 0; i--) {
	      output[count[array[i]] - 1] = array[i];
	      count[array[i]]--;
	    }

	    // Copy the sorted elements into original array
	    for (int i = 0; i < size; i++) {
	      array[i] = output[i];
	    }
	  }

	  // Driver code
	  public static void main(String args[]) {
	    
	    int[] sizes = {10, 100, 1000, 10000, 100000};
		  for (int i = 0; i < sizes.length; i++) {
			  int[] data = generateData(sizes[i]);
		      long startTime = System.nanoTime();
		      int size = data.length;
		      CountSort cs = new CountSort();
			  cs.countSort(data, size);
		      long endTime = System.nanoTime();
		      long duration = (endTime - startTime); 
		      System.out.println("Duration of the countsort algorithm with data of size "+ sizes[i] + ": " + duration + " nanoseconds.");
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
