package CodeStates.Section1.JavaOOPStudy.ThreadStudy.src;

class ThreadOne extends Thread {
    @Override
    public void run() {
        for(int i=0; i<5; i++)
            System.out.println(getName());
    }
}
class ThreadTwo implements Runnable {

    @Override
    public void run() {
        for(int i=0; i<5; i++){
            System.out.println(Thread.currentThread().getName());
        }

    }
}
class ThreadThree implements Runnable {

    @Override
    public void run() {
        for(int i=0; i<5; i++){
            System.out.println(Thread.currentThread().getName());
        }

    }
}

public class ThreadStudy {
    public static void main(String[] args) {
        ThreadOne t1 = new ThreadOne();
        Thread t2 = new Thread(new ThreadTwo());
        Thread t3 = new Thread(new ThreadThree());

        t1.start();
        t2.start();
        t3.start();

    }
}
