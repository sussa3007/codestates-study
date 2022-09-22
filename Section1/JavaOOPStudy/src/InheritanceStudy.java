package CodeStates.Section1.JavaOOPStudy.src;

class CycleProto  { //Parents Class

    int tire;
    String body;
    String handle;
    CycleProto() {
    }
    CycleProto (int tire, String body, String handle) {
        this.tire = tire;
        this.body = body;
        this.handle = handle;
    }
    void type () {
        System.out.println(tire+"개의 타이어");
        System.out.println(body +"타입의 바디");
        System.out.println(handle+"타입의 핸들");
    }
}
class Cycle extends CycleProto { // Child Class
     String brake;
    Cycle() {
        super();
    }

    Cycle(int tire, String body, String handle) {
        super(tire, body, handle); // 상속받은 클래스는 부모클래스의 생성자를 따라야된다
    }
    Cycle(int tire, String body, String handle, String brake) {
        // 상속받은 클래스도 생성자를 오버로딩 할수있다
        super(tire, body, handle);
        this.brake = brake;

    }
    void upgradebrake (String brake) {
        this.brake = brake;
    }
    void type() {
        // 상속 클래스의 오버라이드는 부모의 메소드 기능을 포함하고 확장되어야한다
        super.type();
        if (this.brake != null) {
            System.out.println(brake+"타입의 브레이크");
        }
    }
}
class Motorcycle {
    String engine;
    Cycle cy = new Cycle();// 클래스 포함으로 참조변수 생성
    Motorcycle(int tire, String body, String handle, String brake, String engine) {
        cy.tire = tire;
        cy.body = body;
        cy.handle = handle;
        cy.brake = brake;
        this.engine = engine;
    }
    void type() {
        cy.type();
        if (this.engine != null) {
            System.out.println(engine + "타입의 엔진");
        }
    }
}

public class InheritanceStudy {
    public static void main(String[] args) {
        Cycle gt = new Cycle(2, "Al", "Al");
        gt.type();
        System.out.println("===============");
        gt.upgradebrake("Disk");
        gt.type();
        System.out.println("===============");
        Cycle gt2 = new Cycle(2, "Carbon", "Carbon", "Oil");
        gt2.type();
        System.out.println("===============");
        gt2.upgradebrake("Oildisk");
        gt2.type();
        System.out.println("===============");

        Motorcycle max = new Motorcycle(4,"Al","Al","Oildisk","V2");
        max.type();





    }
}
