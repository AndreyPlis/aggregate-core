import com.tibbo.datatable.*;
import com.tibbo.datatable.concurrency.*;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class Main {

    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS, /*стандартная очередь*/ new ArrayBlockingQueue<Runnable>(100));

        System.out.println("start " );

        Future f = pool.submit(new Callable<Integer>()
        {
            @Override
            public Integer call() throws Exception {
               /* try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                return 100;
            }
        });

        try {
            System.out.println("result " + f.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < 15; i++)
        pool.execute(() -> {
            /*работа со совей очередью*/
            System.out.println(pool.getCompletedTaskCount() + " active ");
        });


        pool.shutdown();

    }

}
