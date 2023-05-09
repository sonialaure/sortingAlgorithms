package algorithms;
import java.util.Random;


public class BubbleSort {
	// perform the bubble sort
	  static void bubbleSort(int array[]) {
	    int size = array.length;
	    
	    // loop to access each array element
	    for (int i = 0; i < size - 1; i++)
	    
	      // loop to compare array elements
	      for (int j = 0; j < size - i - 1; j++)

	        // compare two adjacent elements
	        // change > to < to sort in descending order
	        if (array[j] > array[j + 1]) {

	          // swapping occurs if elements
	          // are not in the intended order
	          int temp = array[j];
	          array[j] = array[j + 1];
	          array[j + 1] = temp;
	        }
	  }

	  public static void main(String args[]) {
	      
		  int[] sizes = {10, 100, 1000, 10000, 100000};
		  for (int i = 0; i < sizes.length; i++) {
			  int[] data = generateData(sizes[i]);
		      long startTime = System.nanoTime();
		      bubbleSort(data);
		      long endTime = System.nanoTime();
		      long duration = (endTime - startTime); 
		      System.out.println("Duration of the bubblesort algorithm with data of size "+ sizes[i] + ": " + duration + " nanoseconds.");
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
