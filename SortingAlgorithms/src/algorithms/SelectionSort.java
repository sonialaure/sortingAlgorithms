package algorithms;
import java.util.Random;

public class SelectionSort {
	void selectionSort(int array[]) {
	    int size = array.length;

	    for (int step = 0; step < size - 1; step++) {
	      int min_idx = step;

	      for (int i = step + 1; i < size; i++) {

	        // Select the minimum element in each loop.
	        if (array[i] < array[min_idx]) {
	          min_idx = i;
	        }
	      }

	      // put min at the correct position
	      int temp = array[step];
	      array[step] = array[min_idx];
	      array[min_idx] = temp;
	    }
	  }

	
	  public static void main(String args[]) {
		  
		  int[] sizes = {10, 100, 1000, 10000, 100000};
		  for (int i = 0; i < sizes.length; i++) {
			  int[] data = generateData(sizes[i]);
		      long startTime = System.nanoTime();
		      SelectionSort ss = new SelectionSort();
			  ss.selectionSort(data);
		      long endTime = System.nanoTime();
		      long duration = (endTime - startTime); 
		      System.out.println("Duration of the SelectionSort algorithm with data of size "+ sizes[i] + ": " + duration + " nanoseconds.");
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
