package ru.gb.Lesson7;

public class AnnoTests {

    @BeforeSuite
    public void test1() {
        System.out.println("This is before suite test");
    }

    @Test
    public void test2() {
        System.out.println("This is 2nd test, priority 0");
    }

    @Test(priority = 4)
    public void test3() {
        System.out.println("This is 3rd test, priority 4");
    }

    @Test(priority = 1)
    public void test4() {
        System.out.println("This is 4th test, priority 1");
    }

    @Test(priority = 9)
    public void test5() {
        System.out.println("This is 5th test, priority 9");
    }

    @Test(priority = 3)
    public void test6() {
        System.out.println("This is 6th test, priority 3");
    }

    @Test
    public void test7() {
        System.out.println("This is 7th test, priority 0");
    }

    @AfterSuite
    public void test8() {
        System.out.println("This is after suite test");
    }

//    @BeforeSuite
//    public void test9() {
//        System.out.println("This is second before test suite");
//    }
}
