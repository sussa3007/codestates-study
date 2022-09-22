package CodeStates.Section1.JavaOOPStudy.ThreadStudy.src;

import java.util.ArrayList;
class Customer2 implements Runnable {
    private Table2  table;
    private String food;

    Customer2(Table2 table, String food) {
        this.table = table;
        this.food  = food;
    }

    public void run() {
        while(true) {
            try { Thread.sleep(100);} catch(InterruptedException e) {}
            String name = Thread.currentThread().getName();

            table.remove(food);
            System.out.println(name + " ate a " + food);
        } // while
    }
}

class Cook2 implements Runnable {
    private Table2 table;

    Cook2(Table2 table) { this.table = table; }

    public void run() {
        while(true) {
            int idx = (int)(Math.random()*table.dishNum());
            table.add(table.dishNames[idx]);
            try { Thread.sleep(10);} catch(InterruptedException e) {}
        } // while
    }
}

class Table2 {
    String[] dishNames = { "donut","donut","burger" };
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();

    public synchronized void add(String dish) {
        while(dishes.size() >= MAX_FOOD) {
            String name = Thread.currentThread().getName();
            System.out.println(name+" is waiting.");
            try {
                wait();
                Thread.sleep(500);
            } catch(InterruptedException e) {}
        }
        dishes.add(dish);
        notify();
        System.out.println("Dishes:" + dishes.toString());
    }

    public void remove(String dishName) {
        synchronized(this) {
            String name = Thread.currentThread().getName();

            while(dishes.size()==0) {
                System.out.println(name+" is waiting.");
                try {
                    wait();
                    Thread.sleep(500);
                } catch(InterruptedException e) {}
            }

            while(true) {
                for(int i=0; i<dishes.size();i++) {
                    if(dishName.equals(dishes.get(i))) {
                        dishes.remove(i);
                        notify();
                        return;
                    }
                } // for���� ��

                try {
                    System.out.println(name+" is waiting.");
                    wait();
                    Thread.sleep(500);
                } catch(InterruptedException e) {}
            } // while(true)
        } // synchronized
    }
    public int dishNum() { return dishNames.length; }
}

public class WaitNotifyStudy2 {
    public static void main(String[] args) throws Exception {
        Table2 table = new Table2();

        new Thread(new Cook2(table), "COOK").start();
        new Thread(new Customer2(table, "donut"),  "CUST1").start();
        new Thread(new Customer2(table, "burger"), "CUST2").start();
        Thread.sleep(10000);
        System.exit(0);
    }
}