package P1;

import P2.StdOut;
import P2.Stopwatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Russian_Algorithm {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("data/russian.txt");

        russian(file);



    }
    public static void russian(File file) throws FileNotFoundException {
        Stopwatch timer = new Stopwatch();
        Scanner myObj = new Scanner(file);

        int a = myObj.nextInt();

        int b= myObj.nextInt();

        System.out.println(a+" * "+b);



        myObj.close();


        int res=0;

        while (b>0){
            if ((b % 2) != 0) {

                res += a;
            }
            a*=2;
            b/=2;



        }
        System.out.println(res);

        StdOut.println("elapsed time = " + timer.elapsedTime());
    }
}
