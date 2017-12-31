package Collections;

import java.util.Scanner;

/**
 * Created by AiYeSus on 12/11/2017.
 */

public class CyclicRotation {
    public static int[] rotateArray(int[] arr, int nRotate) {
        int sz = arr.length;
        int hold, temp=arr[sz-1];
        for(int j=sz-1; j>0; j--) {
            arr[j] = arr[j-1];
        }
        arr[0] = temp;
        return arr;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i=0;
        int sz ;
        int[] arr1;
        sz = scan.nextInt();
        arr1 = new int[sz];
        for(int j=0; j < sz; j++) {
            arr1[j] = scan.nextInt();
        }

        arr1 = rotateArray(arr1, 2);
        System.out.println("new array ");
        for(int n=0; n<arr1.length; n++) {
            System.out.print(arr1[n]+" ");
        }
    }
}
