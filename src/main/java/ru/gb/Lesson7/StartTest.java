package ru.gb.Lesson7;

import java.lang.reflect.Method;
import java.util.*;

public class StartTest {

    public static void main(String[] args) {

        try {
            start(AnnoTests.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void start(Class<?> testClass) throws Exception {

        List<Method> testList = new ArrayList<>();
        boolean isBeforeSuite = false;
        boolean isAfterSuite = false;

        for (Method m: testClass.getDeclaredMethods()) {

            if (m.getAnnotation(BeforeSuite.class) != null) {
                if (!isBeforeSuite) isBeforeSuite = true;
                else throw new RuntimeException("More than one BeforeSuite annotation!");
            }

            if (m.getAnnotation(AfterSuite.class) != null) {
                if (!isAfterSuite) isAfterSuite = true;
                else throw new RuntimeException("More that one AfterSuite annotaion!");
            }
            if (m.getAnnotation(Test.class) != null) {
                testList.add(m);
            }
        }

        Collections.sort(testList, (o1, o2) -> {
            if (o1.getAnnotation(Test.class).priority() == o2.getAnnotation(Test.class).priority())
            return 0;
            return o1.getAnnotation(Test.class).priority() < o2.getAnnotation(Test.class).priority() ? -1 : 1;
        });
        System.out.println("*************");
        for (Method method: testList) {
            method.invoke(testClass.getDeclaredConstructor().newInstance());
        }
    }
}
