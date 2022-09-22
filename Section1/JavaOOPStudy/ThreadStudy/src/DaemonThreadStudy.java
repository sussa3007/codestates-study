package CodeStates.Section1.JavaOOPStudy.ThreadStudy.src;

public class DaemonThreadStudy implements Runnable  {
    static boolean autoSave = false;

    public static void main(String[] args) {
        Thread t = new Thread(new DaemonThreadStudy()); // 쓰레드 생성
        t.setDaemon(true);  //데몬 쓰레드는 쓰레드 생성 전에 호출해야된다.
        t.start();

        for(int i=1; i <= 10; i++) { // 1초에 하나씩 증가하도록 설정
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e) {}
            System.out.println(i);

            if(i==5) autoSave = true;// i 의 값이 5가 될때 true가 되며 데몬 쓰레드가 동작한다.
        }

        System.out.println("종료");
    }

    public void run() {
        while(true) {
            try {
                Thread.sleep(3 * 1000); // 위 i 의 값이 5이후에는 3초마다 동작한다
            } catch(InterruptedException e) {}

            // autoSave의 값이 true 일때 autoSave()메소드를 호출한다.
            if(autoSave) autoSave();
        }
    }

    public void autoSave() {
        System.out.println("자동 저장됨...");
    }
}