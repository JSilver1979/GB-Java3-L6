package ru.gb.Lesson6;

import java.util.Arrays;


public class HomeWork6 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(afterFourArray(new int[]{3, 5, 7, 2, 4, 6, 8, 9, 0, 0, 1})));
        System.out.println(checkOneFour(new int[]{4, 1, 4}));
    }

    public static int[] afterFourArray(int[] arr) {
        int mark = 0;
        boolean isFour = false;
        for (int i = arr.length-1; i >= 0 ; i--) {
            if (arr[i] == 4) {
                isFour = true;
                break;
            }
            mark = i;
        }

        if (!isFour) {
            throw new RuntimeException();
        }

        int[] newArr = new int[arr.length-mark];
        for (int n = mark; n < arr.length; n++) {
            newArr[n-mark] = arr[n];
        }
        return newArr;
    }

    public static boolean checkOneFour(int[] arr){
        boolean one = false;
        boolean four = false;
        boolean noOther = true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) one = true;
            else if (arr[i] == 4) four = true;
            else noOther = false;
        }
        return one && four && noOther;
    }
}
