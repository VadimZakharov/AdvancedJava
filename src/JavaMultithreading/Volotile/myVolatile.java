package JavaMultithreading.Volotile;

import java.util.Scanner;
// volatile гарантирует кагерентность кэшей, переменная не кэширутеся в кэше. (необходимо для одинаковой версии переменной)
public class myVolatile {
    public static void main(String[] args) {    // Читающий поток
        MyThread myThread = new MyThread();
        myThread.start();

        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        myThread.shutdown();


    }
}

class MyThread extends Thread{                 // Пишущий поток
    private volatile boolean running = true;

    public void run(){
        while (running){
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void shutdown(){
        this.running = false;
    }
}