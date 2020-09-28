package com.tibbo.datatable.concurrency;

public class Increment {

    private final Object lock = new Object();

    private Integer increment = 0;


    public int getIncrement() {
        return increment;
    }


    public void customWait()
    {
        synchronized (lock)
        {
            try {
                System.out.println("try wait");
                lock.wait();
                System.out.println("finished wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void notifyCustom()
    {
        synchronized (lock)
        {
            System.out.println("notify");
            lock.notify();
        }
    }



    public void increment() {
        synchronized (lock) {
            for (int i = 0; i < 5; i++) {
                this.increment++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " " + getIncrement());
            }
        }
    }

    public void decrement() {
        synchronized(lock) {
            for (int i = 0; i < 5; i++) {
                this.increment--;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " " + getIncrement());
            }
        }
    }
}
