package P5_P6;

public class EnhancedQuickSort {
    public static void enhancedQuicksort(int[] A, int low, int high)
    {
        while (low < high)
        {
            if (high - low < 10)
            {
                insertionSort(A, low, high);
                break;
            }
            else {
                int pivot = partition(A, low, high);

                if (pivot - low < high - pivot)
                {
                    enhancedQuicksort(A, low, pivot - 1);
                    low = pivot + 1;
                }
                else {
                    enhancedQuicksort(A, pivot + 1, high);
                    high = pivot - 1;
                }
            }
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

    public static void insertionSort(int[] arr, int low, int n)
    {

        for (int i = low + 1; i <= n; i++)
        {
            int value = arr[i];
            int j = i;

            while (j > low && arr[j - 1] > value)
            {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = value;
        }
    }


    public static void main (String args[]){
        int[] arr = {1,5,3,77,3,222,1111,2,3};
        int n;
        n = arr.length;
        enhancedQuicksort(arr,0,n-1);
        for(int i: arr)
            System.out.println(i+" ");
    }
}