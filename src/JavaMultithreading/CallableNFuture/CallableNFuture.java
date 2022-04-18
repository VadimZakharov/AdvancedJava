package JavaMultithreading.CallableNFuture;

import java.util.Random;
import java.util.concurrent.*;

public class CallableNFuture {

    private static int i;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1); //Создание пула из одного потока


        // Создание потока
    Future<Integer> future = executorService.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                System.out.println("thread starts...");
                try {
                    Thread.sleep(500);

                } catch (InterruptedException e){
                    System.out.println(e.toString());
                }
                System.out.println("Finished...");
                Random random = new Random();
                    i =  random.nextInt(10);

                executorService.shutdown();
                return i;
            }
            });

    int result = future.get();
        System.out.println(result);
    }
}


//Интрефейс коллбл параметризованный, мы можем возвращать какой-то объект.
// С помощью методов Future мы можем получать значения от потоков