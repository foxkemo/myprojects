package com.mypack;
class WorkerThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 开始执行");
        try {
            Thread.sleep(2000);  // 模拟任务
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 执行完毕");
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        Thread t1 = new WorkerThread();
        Thread t2 = new WorkerThread();
        Thread t3 = new WorkerThread();

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();  // 等待 t1 结束
            t2.join();  // 等待 t2 结束
            t3.join();  // 等待 t3 结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("所有子线程执行完毕，主线程继续执行");
    }
}
