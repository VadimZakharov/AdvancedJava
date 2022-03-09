package JavaMultithreading.ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class myThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService =  Executors.newFixedThreadPool(2); // пул потоков (2х)

        for (int i = 0; i < 5; i++)
            executorService.submit(new Work(i)); // передача заданий

            executorService.shutdown(); // прекращает принимать переданные задания, и призывает их к выполнению

            System.out.println("All task submitted");

            executorService.awaitTermination(1, TimeUnit.DAYS); // поток останавливается через 1 день


    }
}

class Work implements  Runnable{
    private  int id;

    public Work(int id){
        this.id = id;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Work " + id + " was completed");
    }
}