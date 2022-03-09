package JavaMultithreading.PatternProducerConsumer;

import java.util.Scanner;

// два метода определены у любого объекта, нужны для синхронизации потоков
public class myWaitNotify {
    public static void main(String[] args) throws InterruptedException {

        WaitAndNotify waitAndNotify = new WaitAndNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    waitAndNotify.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    waitAndNotify.consume();
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

}
class WaitAndNotify{
    public void produce() throws InterruptedException {
        synchronized (this){
            System.out.println("Producer thread started ");
            wait(); //  отдаём intrinsic lock (другие потоки начинают синхронизироваться через объект)
                    //  в текущем потоке ждём пока будет вызван notify
            System.out.println("Producer thread resume ");
        }

    }
    public void consume() throws InterruptedException{
        Thread.sleep(2000);
        Scanner sc = new Scanner(System.in);

        synchronized (this){
            System.out.println("Waiting for return key pressed");
            sc.nextLine();
            notify(); // пробуждаем поток, но не освобождает монитор
                      // монитор будет освобожден после выполнения блока
        }

    }
}