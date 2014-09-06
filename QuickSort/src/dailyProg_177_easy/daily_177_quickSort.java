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
		
		array = pivot(array, 0, array.length);
		System.out.println(Arrays.toString(array));
		
		
		scanner.close();
		}
		catch (FileNotFoundException e) {
			System.out.println(e);
		}
		
	}
	
	public static double[] pivot(double[] array, int left, int right) {
		if (array.length <= 1) {
			return array;
		}
		int pivot = (left + right) / 2;
		double pivotHold = array[pivot];
		
		array = swap(pivotHold, array, pivot);
		pivotHold = array[pivot];
		
		double[] rightArray;
		double[] leftArray = new double[array.length / 2];
		if (array.length % 2 == 0) {
			rightArray = new double[(array.length / 2) -1];
		}
		else {
			rightArray = new double[(array.length /2)];
		}
		
		for (int i = 0; i < array.length; i++) {
			if (i == pivot) {
			}
			else if (i < leftArray.length) {
				leftArray[i] = array[i];
			}
			else {
				rightArray[i - (leftArray.length + 1)] = array[i];
			}
		}
		
		
		leftArray = pivot(leftArray, 0, leftArray.length);
		rightArray = pivot(rightArray, 0, rightArray.length);
		for (int i = 0; i < array.length - 1; i++) {
			System.out.println("Construct Loop");
			if (i == pivot) {
				array[i] = pivotHold;
				System.out.println(array[i] + " pivothold insert" + i);
			}
			else if (i < leftArray.length) {
				array[i] = leftArray[i];
				System.out.println(array[i] + " left array insert" + i);			
			}
			
			else {
				array[i] = rightArray[i - leftArray.length - 1];
				System.out.println(array[i] + " right array insert" + i);
			}
		}
		
		System.out.println(Arrays.toString(array) + " loop fin");
		return array;
	}
	
	public static double[] swap(double pivot, double[] array, int count) { 
		double temp = 0;
		int j = array.length - 1;
		System.out.println(Arrays.toString(array) + " pre swap " + pivot + " " + count + " " + j );
		for (int i = 0; i < array.length - count; i++) {
			if (array[i] >= pivot) {
				while (array[j] > pivot) {
					j--;
				}
				
				if (array[i] > array[j]) {
					System.out.println("hi");
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					j--;
				}
			}
			
		}
		
		
		
		System.out.println(Arrays.toString(array) + " swap");
		return array;
	}

}
