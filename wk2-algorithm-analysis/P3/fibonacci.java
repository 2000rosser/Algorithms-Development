package P3;

public class fibonacci {

	
public static int fibonacciIterative(int n){
  if (n<=1)
      return 1 ;

  int fib = 1;
  int prevFib =  1;

  for (int i = 2; i < n; i++) {
   int temp = fib;
   fib = fib + prevFib;
   prevFib = temp;
  }
  return fib;
 }

 public static void main (String args[]) 
    {
        Stopwatch timer = new Stopwatch();
        int n = 45;
        System.out.println(fibonacciIterative(n));
        StdOut.println("elapsed time = " + timer.elapsedTime());

    } 

 
 
}
