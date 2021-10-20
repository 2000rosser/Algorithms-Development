package P5_P6;

public class QuickSort {
    public static void quickSort(int[] arr, int start, int end){

        if(start<end){
            int piv =partition(arr, start, end);

            quickSort(arr, start, piv-1);
            quickSort(arr,piv+1,end);
        }
    }

    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int pi = start;

        for(int i = start; i<=end-1;i++){
            if(arr[i]<=pivot){
                int temp;
                temp=arr[i];
                arr[i]=arr[pi];
                arr[pi]=temp;
                pi++;
            }
        }
        int temp;
        temp=arr[end];
        arr[end]=arr[pi];
        arr[pi]=temp;

        return pi;
    }


    public static void main (String args[]){
        int[] arr = {32,12,5,2,12,4,1};
        int n = arr.length;
        quickSort(arr,0,n-1);
        for(int i: arr)
            System.out.println(i+" ");
    }
}
