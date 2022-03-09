package JavaMultithreading.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// потокобезопасный класс, синхронизация уже присутствует
public class myCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(3); // защелка обратного отсчета указывается коллиество итерации назад
                                                    // перед тем как команда выполниться

        ExecutorService eS = Executors.newFixedThreadPool(3); // создание потоков через тредпул
        for (int i = 0; i < 3; i++) {
            eS.submit(new Processor(i,cdl));

        }
        eS.shutdown();
/*
        cdl.await(); // метод ожидает когда лэтч станет 0
        System.out.println("Latch has been opened main thread proceeding");*/

        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            cdl.countDown();


        }
    }
}

class Processor implements Runnable{
    private CountDownLatch countDownLatch;
    private int id;

    public Processor(int id ,CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

/*
        countDownLatch.countDown(); // метод дикрементирует переменную
*/
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread with id " + id + " proceeded");
    }
}