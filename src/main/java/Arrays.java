package main.java;


//TODO: Used only if the size of the array is equal to the values
public class Arrays {

    static int minimumSwaps(int[] arr) {
        int count = 0;
        for(int i=0;i<arr.length;++i){
            while(i + 1 !=arr[i]){
                int swapIndex = arr[i]-1;
                int valAtIndex = arr[i];
                int valAtSwapIndex = arr[swapIndex];
                arr[i]=valAtSwapIndex;
                arr[swapIndex]=valAtIndex;
                ++count;
            }
        }
        return count;
    }

    public static void main(String args[])
    {

        int arr[] = {2,1,5,3,4};

        System.out.println("Sorted array ::::: " +  minimumSwaps(arr));

    }
}
