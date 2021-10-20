package P9;

public class Run_length_encoding {
    public static void printRLE(String string)
    {
        int n = string.length();
        for (int i = 0; i < n; i++) {
            int freq=1;

            while (i< n-1 && string.charAt(i)==string.charAt(i + 1)) {
                freq++;
                i++;
            }
            System.out.print(string.charAt(i));
            System.out.print(freq);
        }
    }

    public static void main(String[] args)
    {
        String string = "ggghhhddddiiiissss";
        printRLE(string);
    }
}
