package P5_P6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

	/**
	 * Implementation of various sorting algorithms 
	 * that includes a framework for testing with various input array sizes and over
	 * multiple runs
	 * 
	 */

public class Sorts {

private static Random r = new Random(System.currentTimeMillis());
public static void main(String args[]) {

System.out.println("running main");
//use an integer variable to decide which sorting algorithm to use below
int type = 0; 

			
///adjust input size to vary size of arrays
for (int inputSize = 1; inputSize < 2; inputSize++) {
//vary total Runs to give you many empirical tests
	System.out.print("inputSize " + inputSize);
	
	int totalRuns = 10;
	System.out.println("total runs " + totalRuns); 
    

	long totalruntime = 0;

	for (int run = 0; run < totalRuns; run++) {

	Integer[] nums = new Integer[inputSize];
	int[] nums2 = new int[inputSize];

    for (int i = 0; i < nums.length; i++) {
	 nums[i] = r.nextInt(5 * inputSize);
	  }
    
  
    long time = System.nanoTime();

					sort4(nums);


					totalruntime += System.nanoTime() - time;

				}
				//printout runtime.
				System.out.println("totaal run time " + totalruntime);
			}

		}
		
		//********print helper class*****
		// Prints the input array 
	    private static void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i]+" "); 
	        	System.out.println(); 
	    } 
	 



		// ***************************** Insertion P5_P6.Sorts *****************************


		//insert your MergeSort implementation here
		private static final int CUTOFF = 10;


		private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
			for (int k = lo; k <= hi; k++)
				aux[k] = a[k];
			int i = lo, j = mid+1;
			for (int k = lo; k <= hi; k++) {
				if (i > mid)
					a[k] = aux[j++];
				else if (j > hi)
					a[k] = aux[i++];
				else if (less(aux[j], aux[i]))
					a[k] = aux[j++];
				else
					a[k] = aux[i++];
			}
		}
		private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
			if (hi <= lo)
				return;
			int mid = lo + (hi - lo) / 2;
			sort(a, aux, lo, mid);
			sort(a, aux, mid+1, hi);
			merge(a, aux, lo, mid, hi);
		}
		public static void sort(Comparable[] a) {
			Comparable[] aux = new Comparable[a.length];
			sort(a, aux, 0, a.length - 1);
		}

		//Insertion with merge sort

		private static void sort2(Comparable[] a, Comparable[] aux, int lo, int hi) {
			if (hi <= lo + CUTOFF) {
				insertionSort2(a, lo, hi);
				return;
			}

			int mid = lo + (hi - lo) / 2;
			sort2(aux, a, lo, mid);
			sort2(aux, a, mid + 1, hi);
			merge(a, aux, lo, mid, hi);
		}



		public static void sort2(Comparable[] a) {
			Comparable[] aux = new Comparable[a.length];
			sort2(a, aux, 0, a.length - 1);
		}



		private static boolean less(Comparable v, Comparable w) {
			return v.compareTo(w) <= 0;
		}

		private static void exch(Object[] a, int i, int j) {
			Object swap = a[i];
			a[i] = a[j];
			a[j] = swap;
		}




		//insert your QuickSort implementation here

		private static int partition(Comparable[] a, int lo, int hi)
		{
			int i = lo, j = hi+1;
			while (true)
			{
				while (less(a[++i], a[lo]))
					if (i == hi) break;

				while (less(a[lo], a[--j]))
					if (j == lo)
						break;
					if (i >= j)
						break;
					exch(a, i, j);
			}
			exch(a, lo, j);
			return j;
		}

		public static void sort3(Comparable[] a)
		{
			StdRandom.shuffle(a);
			sort3(a, 0, a.length - 1);
		}

		private static void sort3(Comparable[] a, int lo, int hi)
		{
			if (hi <= lo) return;
			int j = partition(a, lo, hi);
			sort3(a, lo, j-1);
			sort3(a, j+1, hi);
		}

		//Insertion sort with quickSort

		public static void sort4(Comparable[] a)
		{
			StdRandom.shuffle(a);
			sort4(a, 0, a.length - 1);
		}


		private static void sort4(Comparable[] a, int lo, int hi)
		{
			int CUTOFF = a.length/2;
			if (hi <= lo + CUTOFF) {
				insertionSort2(a, lo, hi);
				return;
			}
			int j = partition(a, lo, hi);
			sort4(a, lo, j-1);
			sort4(a, j+1, hi);
		}






		private static void insertionSort2(Comparable[] a, int lo, int hi) {
			for (int i = lo; i <= hi; i++)
				for (int j = i; j > lo && less(a[j], a[j-1]); j--)
					exch(a, j, j-1);
		}

		public static void insertionSort(int[] arr) {
					System.out.println("Insertion Sort");
				  for (int i = 1; i < arr.length; i++) {
					  int valueToSort = arr[i];
					  int j = i;

					  while (j > 0 && arr[j-1] > valueToSort) {
						  arr[j] = arr[j-1];
						  j--;
					  }
					  arr[j] = valueToSort;
				  }

			    printArray(arr);

				}

		

		// ***************************** Selection Sort ****************************

		public static void selectionSort(int[] nums) {
			int minindex;
			for (int i = 0; i < nums.length - 1; i++) {
				minindex = i;
				for (int j = i; j < nums.length; j++) {
					if (nums[j] < nums[minindex]) {
						minindex = j;
					}
				}
				if (minindex != i) {
					int tmp = nums[i];
					nums[i] = nums[minindex];
					nums[minindex] = tmp;
				}
			}
		}

		// ***************************** Silly P5_P6.Sorts *****************************
		//*** the silliest sorts of them all
		public static void bogoSort(int[] nums) {
			while (!isSorted(nums)) {
				shuffle(nums);
			}
		}
		
       //******shuffle helpfer for bogoSort
		// Knuth Shuffle
		private static void shuffle(int[] nums) { 
			int n, tmp;
			for (int i = nums.length - 1; i > 0; i--) {
				n = r.nextInt(i + 1);
				tmp = nums[i];
				nums[i] = nums[n];
				nums[n] = tmp;
			}
		}
		
		//**helper function to check if your array is sorted or not
		public static boolean isSorted(int[] nums) {
			for (int i = 0; i < nums.length - 1; i++) {
				if (nums[i] > nums[i + 1]) {
					return false;
				}
			}
			return true;
		}
	

	}
