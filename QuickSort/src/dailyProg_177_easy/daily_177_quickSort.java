package dailyProg_177_easy;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.io.*;
public class daily_177_quickSort {
	
	public static void main(String args[]) {
		try {
		Scanner scanner = new Scanner(new File("input.txt"));
		int count = 0;
		count = scanner.nextInt();
		
		double[] array = new double[count];
		
			for(int i = 0; i < count; i++) {
				array[i] = scanner.nextInt();	
			}
			System.out.println(Arrays.toString(array));
		
		quickSort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
		
		
		scanner.close();
		}
		catch (FileNotFoundException e) {
			System.out.println(e);
		}
		
	}
	
	 private static void quickSort(double[] array, int lowerIndex, int higherIndex) {
         
	        int i = lowerIndex;
	        int j = higherIndex;

	        double pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
	        while (i <= j) {
	            while (array[i] < pivot) {
	                i++;
	            }
	            while (array[j] > pivot) {
	                j--;
	            }
	            if (i <= j) {
	                exchangeNumbers(array, i, j);
	                i++;
	                j--;
	            }
	        }
	        if (lowerIndex < j)
	            quickSort(array, lowerIndex, j);
	        if (i < higherIndex)
	            quickSort(array, i, higherIndex);
	    }
	 
	    private static void exchangeNumbers(double[] array, int i, int j) {
	        double temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	    }

}
