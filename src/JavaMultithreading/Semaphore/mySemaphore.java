package JavaMultithreading.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

// используется когда есть какой-то ресурс и много потоков используют этот ресурс
// и мы используем в том случае когда хотим ограничить доступ к этому ресурсу
public class mySemaphore {
    public static void main(String[] args) throws InterruptedException {
//        Semaphore semaphore = new Semaphore(3);// указывает количство потоков которые могут работать
//
//        try {
//            semaphore.acquire(); // начинаем действие с ресурсом
//            semaphore.acquire();
//            semaphore.acquire();
//
//            System.out.println("All permits have been acquired");
//
//            semaphore.acquire();
//
//            System.out.println("Can't reach here");
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        semaphore.release(); // метод вызывается когда в потоке мы заканчиваем использовать ресурс
//        System.out.println(semaphore.availablePermits()); // показывает колличество разрешений
        ExecutorService executorService = Executors.newFixedThreadPool(200);
        Connection connection = Connection.getConnection();
        for (int i = 0; i < 200; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
           executorService.shutdown();
           executorService.awaitTermination(1, TimeUnit.DAYS);

    }

}
// Паттерн синглтон
class Connection {
    private static Connection connection = new Connection();
    private int connectionsCount;
    private Semaphore semaphore = new Semaphore(10);
    private Connection(){


    }

    public static Connection getConnection(){
        return connection;
    }

    public void work() throws InterruptedException {
        semaphore.acquire();
        try {
            doWork();
        } finally {
            semaphore.release();
        }

    }

    public void doWork() throws InterruptedException {
        synchronized (this){
            connectionsCount++;
            System.out.println(connectionsCount);
        }
        Thread.sleep(5000);

        synchronized (this) {
            connectionsCount--;
        }
    }


}
