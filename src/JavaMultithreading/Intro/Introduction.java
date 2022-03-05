package JavaMultithreading.Intro;
//создание потоков
public class Introduction {
    public static void main(String[] args) throws InterruptedException {
/*
        MyThread myThread = new MyThread();
        myThread.start();  //создание нового потока
        MyThread myThread1 = new MyThread();
        myThread1.start(); // второй  поток
        System.out.println("Im going sleep");
        Thread.sleep(3000);
        System.out.println("Im awake");
*/
        Thread thread = new Thread (new Runner());
        thread.start();




    }
}

class Runner implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from my Thread" + i);

        }
    }
}

class MyThread extends Thread{
    public void run(){
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from my Thread" + i);

        }
    }
}

