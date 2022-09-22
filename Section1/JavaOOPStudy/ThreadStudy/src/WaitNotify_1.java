package CodeStates.Section1.JavaOOPStudy.ThreadStudy.src;

public class WaitNotify_1 {
    public static void main(String[] args) throws InterruptedException {
        WorkPool work = new WorkPool();
        Thread a = new Thread(new WorkThread01(work));
        Thread b = new Thread(new WorkThread02(work));
        a.start();
        b.start();
        Thread.sleep(10000);
        System.out.println("End of Work");
        System.exit(0);


    }
}
class WorkPool {
    public synchronized void work_A() {
        System.out.println("Thread01 Working....");
        try { Thread.sleep(400); } catch (Exception e) {}
        notify();
        try { wait(); } catch (InterruptedException e){}
    }
    public synchronized void work_B() {
        System.out.println("Thread02 Working....");
        try { Thread.sleep(400); } catch (Exception e) {}
        notify();
        try { wait(); } catch (InterruptedException e){}
    }

}
class WorkThread01 implements Runnable{
    private WorkPool work;
    WorkThread01(WorkPool work) {
        this.work = work;
    }
    public void run(){
        for(int i=0; i<10;i++){
            work.work_A();
        }

    }
}
class WorkThread02 implements Runnable{
    private WorkPool work;
    WorkThread02(WorkPool work) {
        this.work = work;
    }
    public void run(){
        for(int i=0; i<10;i++){
            work.work_B();

        }
    }
}

