package P4;

import java.util.Random;

public class Sorts_starter_code {


    public static void selection(int[] arr) {
        int temp;
        int min_index;

        for (int i = 0; i < arr.length - 1; i++) {
            min_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min_index] > arr[j])
                    min_index = j;
            }

            temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;


        }
    }

    public static void insertionSort(int[] array) {
        for (int j = 1; j < array.length; j++) {
            int current = array[j];
            int i = j-1;
            while ((i > -1) && (array[i] > current)) {
                array[i+1] = array[i];
                i--;
            }
            array[i+1] = current;
        }
    }

    private static final Random generator = new Random();

    public static void bogoSort(int[] array)  {
        while (!isSorted(array)) {
            for (int i = 0; i < array.length; i++){
                int randomPosition = generator.nextInt(array.length);
                int temp = array[i];
                array[i] = array[randomPosition];
                array[randomPosition] = temp;
            }
        }
    }
    private static boolean isSorted(int[] array)  {
        for (int i = 1; i < array.length; i++){
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main (String args[]){

        int[] ar1= new int[10];
        for(int i = 0; i <  ar1.length; i++) {
            ar1[i] = (int)(Math.random() * 1000000);

        }

        int[] ar2= new int[12];
        for(int i = 0; i <  ar2.length; i++) {
            ar2[i] = (int)(Math.random() * 1000000);

        }

        int[] ar3= new int[10000];
        for(int i = 0; i <  ar3.length; i++) {
            ar3[i] = (int)(Math.random() * 1000000);

        }



        Stopwatch timer = new Stopwatch();
        bogoSort(ar2);
        StdOut.println("elapsed time = " + timer.elapsedTime());






    }
}
