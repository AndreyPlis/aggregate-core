import com.tibbo.datatable.*;
import com.tibbo.datatable.concurrency.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ProducerConsumer<Integer> producerConsumer = new ProducerConsumer<>();
        Runnable producer = () -> {
            for ( int i = 0; i < 10; ++i ) {
                try {
                    producerConsumer.produce( i );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable consumer = () -> {
            for ( int i = 0; i < 10; ++i ) {
                try {
                    producerConsumer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread prdcr = new Thread(producer, "produce");
        prdcr.start();

        Thread cnsmr = new Thread(consumer, "consume");
        cnsmr.start();

        try {
            prdcr.join();
            cnsmr.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish");
    }
}
