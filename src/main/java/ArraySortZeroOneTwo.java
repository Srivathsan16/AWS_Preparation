package main.java;

public class ArraySortZeroOneTwo {

    static void printArr(int arr[])
    {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public static void sort(int a[]){
        int j=0;
        int countOne = 0;
        int countTwo =0;
        for(int i=0;i<a.length;i++) {
            switch (a[i]) {
                case 1:
                    countOne++;
                    break;
                case 2:
                    countTwo++;
                    break;
                case 0:
                    a[i] = a[j];
                    a[j] = 0;
                    j++;
                    break;
            }
        }
            while(countOne!=0){
                a[j]=1;
                j++;
                countOne --;
            }
            while(countTwo!=0){
                a[j]=2;
                j++;
                countTwo--;
            }


    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        sort(arr);
        printArr(arr);
    }
}
