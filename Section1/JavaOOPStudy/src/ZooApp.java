package CodeStates.Section1.JavaOOPStudy.src;

interface Predator {
    String getFood();

    default void printFood() {
        System.out.printf("my food is %s\n", getFood());
    }
    int LEG_COUNT = 4;  // 인터페이스 상수

    static int speed() {
        return LEG_COUNT * 30;
    }
}

interface Barkable {
    void bark();
}

interface BarkablePredator extends Predator, Barkable {
}

class Animal1 {
    String name;

    void setName(String name) {
        this.name = name;
    }
}

class Tiger extends Animal1 implements Predator, Barkable {
    public String getFood() {
        return "apple";
    }

    public void bark() {
        System.out.println("어흥");
    }
}

class Lion extends Animal1 implements BarkablePredator {
    public String getFood() {
        return "banana";
    }

    public void bark() {
        System.out.println("으르렁");
    }
}

class ZooKeeper {
    void feed(Predator predator) {
        System.out.println("feed " + predator.getFood());
    }
}

class Bouncer {
    void barkAnimal1(Barkable animal) {
        animal.bark();
    }
}

public class ZooApp {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        Lion lion = new Lion();

        Bouncer bouncer = new Bouncer();
        bouncer.barkAnimal1(tiger);
        bouncer.barkAnimal1(lion);


    }
}