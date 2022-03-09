package JavaMultithreading.Synchronized;

public class mySynchronized {
    private  int counter;

    public static void main(String[] args) throws InterruptedException {
        mySynchronized mySynchronized1 = new mySynchronized();
        mySynchronized1.doWork();

    }

    public synchronized void  increment(){ //один поток в один момент времени получает доступ к телу метода
        counter++;
    }

    public void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increment();
                    System.out.println(counter + "dd");


                }


            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increment();
                    System.out.println(counter + "ww");

                }
            }
        });

        thread1.start();

        System.out.println(counter);
        thread2.start();
        // метод говорит о том что мы хотим подождать, в потоке main мы хотим подождать пока заверишиться поток thread1
        thread1.join();
        // метод говорит о том что мы хотим подождать, в потоке main мы хотим подождать пока заверишиться поток thread1
        thread2.join();
        // далее выполниться следующая команда (соут)

        System.out.println(counter + " daddx");




    }

}
