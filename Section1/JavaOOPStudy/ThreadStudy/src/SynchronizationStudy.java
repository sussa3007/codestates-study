package CodeStates.Section1.JavaOOPStudy.ThreadStudy.src;

public class SynchronizationStudy {
    public static void main(String args[]) {
        Runnable r = new Withdraw_1();
        new Thread(r).start(); // 출금을 하는 쓰레드 2개를 실행한다.
        new Thread(r).start();
    }
}

class Account2 {
//    static final int BALANCE = 1000;
    public static int balance = 2000;

    public int getBalance() {
        return balance;
    }

    public synchronized void withdraw(int money){
        // 1초동안 money값을 받아 balance에서 빼고 출력한다.
        if(balance >= money) { // balance가 money보다 크거나 같을때 실행한다.
            try { Thread.sleep(1000);} catch(InterruptedException e) {}
            balance -= money;
        }
    }
}



class Withdraw_1 implements Runnable {
    Account2 a = new Account2();
    public void run() {
        while(a.getBalance() > 0) {
            int money = (int)(Math.random() * 3 + 1) * 100; // 100~300까지를 정의해준다.
            a.withdraw(money); // 메소드 호출
            System.out.println("After Withdraw balance : "+a.getBalance());// balance 출력
        }
    }
}

