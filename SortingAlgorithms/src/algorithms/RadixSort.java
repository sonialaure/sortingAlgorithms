package algorithms;
import java.util.Random;

public class RadixSort {
	// Using counting sort to sort the elements in the basis of significant places
	  void countingSort(int array[], int size, int place) {
	    int[] output = new int[size + 1];
	    int max = array[0];
	    for (int i = 1; i < size; i++) {
	      if (array[i] > max)
	        max = array[i];
	    }
	    int[] count = new int[max + 1];

	    for (int i = 0; i < max; ++i)
	      count[i] = 0;

	    // Calculate count of elements
	    for (int i = 0; i < size; i++)
	      count[(array[i] / place) % 10]++;

	    // Calculate cumulative count
	    for (int i = 1; i < 10; i++)
	      count[i] += count[i - 1];

	    // Place the elements in sorted order
	    for (int i = size - 1; i >= 0; i--) {
	      output[count[(array[i] / place) % 10] - 1] = array[i];
	      count[(array[i] / place) % 10]--;
	    }

	    for (int i = 0; i < size; i++)
	      array[i] = output[i];
	  }

	  // Function to get the largest element from an array
	  int getMax(int array[], int n) {
	    int max = array[0];
	    for (int i = 1; i < n; i++)
	      if (array[i] > max)
	        max = array[i];
	    return max;
	  }

	  // Main function to implement radix sort
	  void radixSort(int array[], int size) {
	    // Get maximum element
	    int max = getMax(array, size);

	    // Apply counting sort to sort elements based on place value.
	    for (int place = 1; max / place > 0; place *= 10)
	      countingSort(array, size, place);
	  }

	  // Driver code
	  public static void main(String args[]) {
		  
		  int[] sizes = {10, 100, 1000, 10000, 100000};
		  for (int i = 0; i < sizes.length; i++) {
			  int[] data = generateData(sizes[i]);
		      long startTime = System.nanoTime();
		      int size = data.length;
		      RadixSort rs = new RadixSort();
			  rs.radixSort(data, size);
		      long endTime = System.nanoTime();
		      long duration = (endTime - startTime); 
		      System.out.println("Duration of the RadixSort algorithm with data of size "+ sizes[i] + ": " + duration + " nanoseconds.");
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
