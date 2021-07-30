package main.java;

import java.awt.dnd.DropTarget;

public class RotateArray {

    public static  void rotateArrayToLeft(int arr[], int k){
        for(int i = 0 ; i<arr.length;i++){
            if(i+k<arr.length){
                int temp = arr[i];
                arr[i]=arr[i+k];
                arr[i+k]=temp;
            }
            else {
                if(i+1<arr.length && k%2==0  ) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
                else{
                    k--;
                    if(i+k<arr.length && k%2==0  ) {
                        int temp = arr[i];
                        arr[i] = arr[i + k];
                        arr[i + k] = temp;
                    }
                }

            }
        }
        for(int i = 0; i<arr.length;i++)
        System.out.println("Arry After rotation : " + arr[i]);
    }

    public static void main(String[] args) {
        int[] a = { 1,2,3,4,5,6,7,8,9,10,11};
        rotateArrayToLeft(a,5);
    }
}
