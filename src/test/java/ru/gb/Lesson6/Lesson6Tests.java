package ru.gb.Lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Lesson6Tests {
    private HomeWork6 homeWork6;

    @BeforeEach
    public void init() {
        homeWork6 = new HomeWork6();
    }

    public static Stream<Arguments> dataForArrayAfterFour() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[] { 5, 6, 11, 5, 4, 9, 0, 0, 1, 12 }, new int[]{9, 0, 0, 1, 12}));
        out.add(Arguments.arguments(new int[] { 4,4,4 }, new int[]{}));
        out.add(Arguments.arguments(new int[] { 1, 4, 5 ,4 ,2 ,1 ,3 ,0 }, new int[]{2 ,1 ,3 ,0 }));
        out.add(Arguments.arguments(new int[] { 1, 3 ,2 ,4 ,5 ,6 ,7 }, new int[]{5 ,6 ,7}));

        return out.stream();
    }
    @ParameterizedTest
    @MethodSource("dataForArrayAfterFour")
    public void testFour(int[] arrData, int[] arrResult) {
        Assertions.assertArrayEquals(arrResult, homeWork6.afterFourArray(arrData));
    }

    public static Stream<Arguments> dataForException() {
        List<Arguments> errOut = new ArrayList<>();
        errOut.add(Arguments.arguments(new int[]{}));
        errOut.add(Arguments.arguments(new int[]{0,0,0}));
        errOut.add(Arguments.arguments(new int[]{1,55,66,87,43,22,5,12,40}));

        return errOut.stream();
    }

    @ParameterizedTest
    @MethodSource("dataForException")
    public void errorTest (int[] arrData) {
        Assertions.assertThrows(RuntimeException.class,() -> homeWork6.afterFourArray(arrData));
    }

    public static Stream<Arguments> dataForCheckFour(){
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1,4,1,4},true));
        out.add(Arguments.arguments(new int[]{1,4,4,4},true));
        out.add(Arguments.arguments(new int[]{1,1,1,4},true));
        out.add(Arguments.arguments(new int[]{1,1,1,1},false));
        out.add(Arguments.arguments(new int[]{4,4,4,4},false));
        out.add(Arguments.arguments(new int[]{11,4,1,4},false));
        out.add(Arguments.arguments(new int[]{},false));
        out.add(Arguments.arguments(new int[]{2,3,2,3},false));

        return out.stream();
    }
    @ParameterizedTest
    @MethodSource("dataForCheckFour")
    public void checkFourTest(int[] arrData, boolean check){
        Assertions.assertEquals(check, homeWork6.checkOneFour(arrData));
    }
}
