package algorithms;
import java.util.Random;

public class InsertionSort {
	
	 public void insertionSort(int array[]) {
	    int size = array.length;

	    for (int step = 1; step < size; step++) {
	      int key = array[step];
	      int j = step - 1;

	      // Compare key with each element on the left of it until an element smaller than
	      // it is found.
	      // For descending order, change key<array[j] to key>array[j].
	      while (j >= 0 && key < array[j]) {
	        array[j + 1] = array[j];
	        --j;
	      }

	      // Place key at after the element just smaller than it.
	      array[j + 1] = key;
	    }
	  }

	  // Test
	  public static void main(String args[]) {
		  int[] sizes = {10, 100, 1000, 10000, 100000};
		  for (int i = 0; i < sizes.length; i++) {
			  int[] data = generateData(sizes[i]);
		      long startTime = System.nanoTime();
		      InsertionSort is = new InsertionSort();
		      is.insertionSort(data);
		      long endTime = System.nanoTime();
		      long duration = (endTime - startTime); 
		      System.out.println("Duration of the InsertionSort algorithm with data of size "+ sizes[i] + ": " + duration + " nanoseconds.");
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
