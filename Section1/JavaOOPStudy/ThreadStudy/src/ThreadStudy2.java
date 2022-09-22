package CodeStates.Section1.JavaOOPStudy.ThreadStudy.src;

public class ThreadStudy2 {
    static long startTime = 0;
    public static void main(String args[]) {
        ThreadEx_1 th1 = new ThreadEx_1();
        ThreadEx_2 th2 = new ThreadEx_2();
        Thread dt1 = new Thread(new Daemon_1());
        dt1.setDaemon(true);// setDaemon 은 시작 전에 호출해야된다.
        dt1.start();  // 데몬 쓰레드 동작 시작

        th1.start();
        th2.start();
        startTime = System.currentTimeMillis();

        try {
            th1.join(); // th1 끝날때 까지 기다린다.
            System.out.println("////");
        } catch(InterruptedException e) {}
        try {
            th2.join(); // th2 끝날때 까지 기다린다.
            System.out.println("@@@@");
        } catch(InterruptedException e) {}

        System.out.println("Time :" + (System.currentTimeMillis() - ThreadStudy2.startTime));
    } // main
}
class ThreadEx_1 extends Thread {
    public void run() {
        for(int i=0; i < 20; i++) {
            try{
                Thread.sleep(300);
            } catch(InterruptedException e) {}
            System.out.print("*");
            if(i==5) Daemon_1.autoSave =true;
        }
    }
}

class ThreadEx_2 extends Thread {
    public void run() {
        for(int i=0; i < 30; i++) {
            try{
                Thread.sleep(300);
            } catch(InterruptedException e) {}
            System.out.print("=");
            if(i==5) Daemon_1.autoSave =true;
        }
    } // run()
}
class Daemon_1 implements Runnable {
    public static boolean autoSave = false;

    public void run() {
        while (true){
            try {
                Thread.sleep(3*1000);
            }catch (InterruptedException e){}

            if(autoSave) save();
        }
    }
    public void save() {
        System.out.println("자동 저장됨.");
    }
}