import com.tibbo.datatable.*;
import com.tibbo.datatable.concurrency.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Increment increment = new Increment();


        Runnable inc = increment::increment;
        Runnable dec = increment::notifyCustom;
        System.out.println("start static");

        Runnable r = new Runnable() {
            @Override
            public void run() {
                increment.customWait();
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               // increment.notifyCustom();
            }
        };


        Thread t3 = new Thread(r, "static task");
        t3.start();

     /*   Thread t2 = new Thread(inc, "increment");
        t2.start();*/

      /*  */

        Thread t1 = new Thread(r2, "decrement");
        t1.start();



        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish");





    }


}
