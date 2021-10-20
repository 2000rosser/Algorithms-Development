import P1.Russian_Algorithm;
import P2.*;
import P7.KMPsearch;
import P8.Trie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        p1();
        p2();
        p3();
        p4();
        p5();
        p6();
        p7();
        p8();
        p9();
    }

    private static void p1() throws FileNotFoundException {
        System.out.println("\n\nPractical One Example\n");
        System.out.println("Addition with Russian Peasant Algorithm\n");

        File file = new File("data/russian.txt");

        Russian_Algorithm.russian(file);
        System.out.println("--------------------------------------");

    }

    private static void p2(){

        System.out.println("\n\nPractical Two Example\n");
        System.out.println("Testing for 2000 ints\n");
        File file = new File("data/2Kints.txt");
        In in = new In(file);
        int[] args = in.readAllInts();

        Stopwatch timer = new Stopwatch();
        System.out.println("ThreeSumA test:");
        System.out.println("Count: "+ThreeSumA.count(args));
        StdOut.println("elapsed time = " + timer.elapsedTime()+"\n");

        Stopwatch timer2 = new Stopwatch();
        System.out.println("ThreeSumB test:");
        System.out.println("Count: "+ThreeSumB.count(args));
        StdOut.println("elapsed time = " + timer2.elapsedTime()+"\n");
        System.out.println("--------------------------------------");
    }

    private static void p3(){
        System.out.println("\n\nPractical Three Example\n");
        System.out.println("Testing for n = 35\n");
        int n = 35;

        System.out.println("Fibonacci Iterative:");
        P3.Stopwatch timer = new P3.Stopwatch();
        System.out.println(P3.fibonacci.fibonacciIterative(n));
        P3.StdOut.println("elapsed time = " + timer.elapsedTime());

        System.out.println("\nFibonacci Recursive:");
        P3.Stopwatch timer2 = new P3.Stopwatch();
        System.out.println(P3.Recursion_Fibonacci.fibonacciRecursion(n));
        P3.StdOut.println("elapsed time = " + timer2.elapsedTime());

        System.out.println("\nRecursive Towers of Hanoi algorithm:\n");
        int n2 = 4;
        P3.Stopwatch timer3 = new P3.Stopwatch();
        P3.RecursionHanoi.towersOfHanoi(n2, 'A', 'C', 'B');
        P3.StdOut.println("elapsed time = " + timer3.elapsedTime());
        System.out.println("--------------------------------------");
    }

    private static void p4(){
        System.out.println("\n\nPractical Four Example\n");
        int[] ar1= new int[1000];
        int[] ar2= new int[1000];
        int[] ar3= new int[10];
        for(int i = 0; i <  ar1.length; i++) {
            int temp;
            temp= (int)(Math.random() * 100);
            ar1[i]=temp;
            ar2[i]=temp;

        }
        for(int i = 0; i <  ar3.length; i++) {
            ar3[i] = (int)(Math.random() * 100);
        }

        System.out.println("Selection Sort: ");
        System.out.println("100 ints");
        P3.Stopwatch timer1 = new P3.Stopwatch();
        P4.Sorts_starter_code.selection(ar1);
        double t1=timer1.elapsedTime();
//        System.out.println(Arrays.toString(ar1));
        P3.StdOut.println("elapsed time = " + t1+"\n");

        System.out.println("Insertion Sort: ");
        System.out.println("100 ints");
        P3.Stopwatch timer2 = new P3.Stopwatch();
        P4.Sorts_starter_code.insertionSort(ar2);
        double t2=timer2.elapsedTime();
//        System.out.println(Arrays.toString(ar2));
        P3.StdOut.println("elapsed time = " + t2+"\n");

        System.out.println("Bogo Sort: ");
        System.out.println("10 ints");
        P3.Stopwatch timer3 = new P3.Stopwatch();
        P4.Sorts_starter_code.bogoSort(ar3);
        double t3=timer3.elapsedTime();
//        System.out.println(Arrays.toString(ar3));
        P3.StdOut.println("elapsed time = " + t3);
        System.out.println("--------------------------------------");
    }

    private static void p5(){
        System.out.println("\n\nPractical Five Example\n");

        Integer[] nums = new Integer[100000];
        Integer[] nums2 = new Integer[100000];
        int[] nums3= new int[100000];
        for(int i = 0; i <  nums.length; i++) {
            int temp;
            temp= (int)(Math.random() * 100);
            nums[i]=temp;
            nums2[i]=temp;
            nums3[i]=temp;
        }


        System.out.println("Merge Sort: ");
        System.out.println("100000 ints");
        P3.Stopwatch timer1 = new P3.Stopwatch();
        P5_P6.Sorts.sort(nums);
        double t1=timer1.elapsedTime();
//        System.out.println(Arrays.toString(nums));
        P3.StdOut.println("elapsed time = " + t1+"\n");

        System.out.println("Merge Sort Enhanced: ");
        System.out.println("100000 ints");
        P3.Stopwatch timer2 = new P3.Stopwatch();
        P5_P6.Sorts.sort(nums2);
        double t2=timer2.elapsedTime();
//        System.out.println(Arrays.toString(nums2));
        P3.StdOut.println("elapsed time = " + t2+"\n");

        System.out.println("Insertion Sort: ");
        System.out.println("100000 ints");
        P3.Stopwatch timer3 = new P3.Stopwatch();
        P4.Sorts_starter_code.insertionSort(nums3);
        double t3=timer3.elapsedTime();
//        System.out.println(Arrays.toString(nums3));
        P3.StdOut.println("elapsed time = " + t3+"\n");
        System.out.println("--------------------------------------");
    }

    private static void p6(){
        System.out.println("\n\nPractical Six Example\n");
        Integer[] ar1 = new Integer[100000];
        int[] ar2= new int[100000];
        int[] ar3= new int[100000];
        for(int i = 0; i <  ar1.length; i++) {
            int temp;
            temp= (int)(Math.random() * 100);
            ar1[i]=temp;
            ar2[i]=temp;
            ar3[i]=temp;
        }

        System.out.println("Merge Sort: ");
        System.out.println("100000 ints");
        P3.Stopwatch timer1 = new P3.Stopwatch();
        P5_P6.Sorts.sort(ar1);
        double t1=timer1.elapsedTime();
//        System.out.println(Arrays.toString(ar1));
        P3.StdOut.println("elapsed time = " + t1+"\n");

        System.out.println("Quick Sort: ");
        System.out.println("100000 ints");
        P3.Stopwatch timer2 = new P3.Stopwatch();
        int n = ar2.length;
        P5_P6.QuickSort.quickSort(ar2,0,n-1);
        double t2=timer2.elapsedTime();
//        System.out.println(Arrays.toString(ar2));
        P3.StdOut.println("elapsed time = " + t2+"\n");

        System.out.println("Quick Sort Enhanced: ");
        System.out.println("100000 ints");
        P3.Stopwatch timer3 = new P3.Stopwatch();
        int n2 = ar3.length;
        P5_P6.EnhancedQuickSort.enhancedQuicksort(ar3,0,n2-1);
        double t3=timer3.elapsedTime();
//        System.out.println(Arrays.toString(ar3));
        P3.StdOut.println("elapsed time = " + t3);
        System.out.println("--------------------------------------");
    }

    private static void p7(){
        System.out.println("\n\nPractical Seven Example\n");
        File file = new File("data/searching.txt");
        In in = new In(file);
        String txt = in.readAll();
        String pat="a";
        P1.Stopwatch timer1 = new P1.Stopwatch();
        System.out.println("Brute force");
        P7.Brute_force.searchString(txt, pat);
        System.out.println("elapsed time = "+timer1.elapsedTime()+"\n");

        P1.Stopwatch timer2 = new P1.Stopwatch();
        System.out.println("KMPSearch");
        new KMPsearch().KMPSearch(pat, txt);
        System.out.println("elapsed time = "+timer2.elapsedTime());
        System.out.println("--------------------------------------");
    }

    private static void p8(){
        System.out.println("\n\nPractical Eight Example\n");
        System.out.println("Trie Searching\n");
        String keys[] = {"bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver"};
        System.out.println(Arrays.toString(keys));
        System.out.println("Searching for book");

        String output[] = {"Not present in trie", "Present in trie"};

        Trie.root = new Trie.TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
            Trie.insert(keys[i]);


        if(Trie.search("book") == true) {
            System.out.println("book --- " + output[1]);
        }
        else{
            System.out.println("book --- " + output[0]);
        }
        System.out.println("--------------------------------------");
    }

    private static void p9(){
        System.out.println("\n\nPractical Nine Example\n");
        System.out.println("Run Length Encoding\n");
        String string = "ggghhhddddiiiissss";
        System.out.println("String to compress: "+string);
        P9.Run_length_encoding.printRLE(string);
        System.out.println("\n");
    }


}
