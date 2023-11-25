package bublesort;

import java.lang.reflect.Array;

public class Buble {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        
        System.out.println("Array:");
        for(int i = 0; i < arr.length; i++) {
        	System.out.print(" " + arr[i]);
        }
    }
    
    public static void main(String[] args) {
		
    	int array[] = {1, 5, 3, 0, 9};
    	bubbleSort(array);
	}
}