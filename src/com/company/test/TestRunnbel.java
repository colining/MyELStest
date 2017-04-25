package com.company.test;

/**
 * Created by asus on 2017/4/21.
 */
public class TestRunnbel {
    private TestRunnbel(int i ) {

    }
    private static TestRunnbel testRunnbel = null;
    public static  void  main(String []arg) throws InterruptedException {
        TestRunnbel testRunnbel =null;
        TestRunnbel testRunnbel1 = new TestRunnbel(10);
        testRunnbel1.test();
        System.out.println("adadasd");
        testRunnbel = testRunnbel1;
        while (true) {
            System.out.println("a="+testRunnbel.a);
            System.out.println("b=" +testRunnbel1.a);
            Thread.sleep(100);
        }
    }
    int a = 5;

    public static  TestRunnbel getTestRunnbel() {
        if (testRunnbel == null) {
            testRunnbel = new TestRunnbel(10);
        }
        return testRunnbel;
    }
    public  void  test ()
    {
        new Thread(new run()).start();
    }

    public  void d() {
        a--;
    }

    private  class run implements Runnable
    {

        @Override
        public void run() {
            while (true) {
                d();
                //System.out.println(a);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
