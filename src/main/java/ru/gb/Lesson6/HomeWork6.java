package ru.gb.Lesson6;

public class HomeWork6 {

    public int[] afterFourArray(int[] arr) {
        int mark = arr.length;
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

    public boolean checkOneFour(int[] arr){
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
