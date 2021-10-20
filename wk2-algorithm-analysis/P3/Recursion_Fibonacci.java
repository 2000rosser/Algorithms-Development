package P3;

public class Recursion_Fibonacci {
    public static int fibonacciRecursion(int n){
        if(n<=1){
            return n;
        }
        return fibonacciRecursion(n-1)+fibonacciRecursion(n-2);
    }

    public static void main (String args[])
    {
        Stopwatch timer = new Stopwatch();
        int n = 45;
        System.out.println(fibonacciRecursion(n));
        StdOut.println("elapsed time = " + timer.elapsedTime());
    }
}
