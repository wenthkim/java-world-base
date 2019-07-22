package com.wenthkim.bugsource;

/**
 * bug产生的根源:
 * 1.原子性 线程切换导致原子性，加锁解决
 * 2.有序性 编译优化导致有序性，加volatile
 * 3.可见性 缓存导致的可见性，加锁解决
 */
public class ConcurrentProblem {

    private long count = 0;


    public static void main(String[] args) throws InterruptedException {
        System.out.println("hi:"+cal());
    }

    /**
     * 加一万
     */
    private  void add10K() {
        int index = 0;
        while (index++ < 10000) {
            count += 1;

        }
    }


    private static long cal() throws InterruptedException {
        final ConcurrentProblem test = new ConcurrentProblem();
        Thread thread1 = new Thread(() -> test.add10K());

        Thread thread2 = new Thread(() -> test.add10K());
        //同时启动两个线程
        thread1.start();
        thread2.start();
        //等待两个线程结束
        thread1.join();
        thread2.join();

        return test.count;
    }




}
