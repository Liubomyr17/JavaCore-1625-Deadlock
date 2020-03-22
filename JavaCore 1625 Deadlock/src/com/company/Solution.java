package com.company;

/*

1625 Mutual lock

1. Understand how the program works.
2. Do not change classes T1 and T2 so that their threads are completed, not necessarily successfully.
3. Do not use the sleep method.

Requirements:
1. The main method must start the thread t1.
2. The main method must start the thread t2.
3. Do not change the T1 class.
4. Do not change the T2 class.
5. Do not use the sleep method.
6. The output of the program should consist of 2 lines informing about the completion of the threads. For example: "T1 was interrupted" and "T2 finished".
7. Threads t1 and t2 must be completed (not necessarily successful).


 */



public class Solution {
    static Thread t1 = new T1();
    static Thread t2 = new T2();


    public static void main(String[] args) throws InterruptedException {
        t1.start();
        t1.interrupt();
        t2.start();
    }

    public static class T1 extends Thread {
        @Override
        public void run() {
            try {
                t2.join();
                System.out.println("T1 finished");
            } catch (InterruptedException e) {
                System.out.println("T1 was interrupted");
            }
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            try {
                t1.join();
                System.out.println("T2 finished");
            } catch (InterruptedException e) {
                System.out.println("T2 was interrupted");
            }
        }
    }
}

