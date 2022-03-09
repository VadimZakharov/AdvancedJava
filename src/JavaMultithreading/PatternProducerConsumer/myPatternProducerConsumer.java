package JavaMultithreading.PatternProducerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class myPatternProducerConsumer {
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    private static void produce() throws InterruptedException {
        Random random = new Random();

        while (true) {
            queue.put(random.nextInt(100)); //метод ожидает пока consumer достанет из очереди
        }
    }

    private static void consumer() throws InterruptedException {
        while (true) {
            Random random = new Random();
            Thread.sleep(100);

            if (random.nextInt(10) == 5) {

                System.out.println(queue.take()); // берёт из очереди
                System.out.println("Queue size " + queue.size());
            }
        }

    }
}