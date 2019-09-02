package com.zcm.lut.test;

/**
 * @author ZCM
 * @package com.zcm.lut.test
 * @class testQuickOrder
 * @date 2019/08/04
 **/
public class testQuickOrder {

    private static void quickOrder (int[] arr, int low, int high){
        int i,j,temp,t;
        i = low;
        j = high;
        if(i>j){
            return;
        }
        temp = arr[low];
        while(i<j){

            while(i<j && arr[j]>=temp){
                j--;
            }
            while(i<j && arr[i]<=temp){
                i++;
            }
            if(i<j){
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[low]= arr[i];
        arr[i] = temp;

        quickOrder(arr,low, i-1);
        quickOrder(arr,j+1, high);

    }

    public static void main(String[] args){
        int[] test = {5,7,4,2,9,15,17,10,8};
        quickOrder(test,0, test.length-1);
        for (int t: test) {
            System.out.println(t);
        }
    }
}
