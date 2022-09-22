package CodeStates.Section1.JavaOOPStudy.src;

interface Information1 {
    void info();
}
class Motor1 implements Information1{
    private String body; // 변수
    private int tire;
    private String brake;
    private int muffler;
    private String smartkey;
    Motor1 (String body, String brake, int tire){ // 생성자
        setBody(body);
        setBrake(brake);
        setTire(tire);
    }
    Motor1 (String body, String brake, int tire,int muffler){
        setBody(body);
        setBrake(brake);
        setTire(tire);
        setMuffler(muffler);
    }


    private void getInfo() { //출력값 정의
        System.out.printf(" Bike =  %s 타입 바디, %d 개의 타이어, %s 타입의 브레이크 %n",getBody(),getTire(),getBrake());
    }
    private void setBody(String body) {
        this.body = body;
    } // 변수 정의
    private void setBrake(String brake) {
        this.brake = brake;
    }
    private void setTire(int tire) {
        this.tire = tire;
    }
    private void setMuffler(int muffler) { this.muffler = muffler; }
    public  String getBody() {return body;} // 변수값 반환
    public  String getBrake() {return brake;}
    public  int getTire() {return tire;}
    public  int getMuffler() {return muffler;}
    public  void info() {getInfo();}  //출력
}

class MotorBike1 extends Motor1  {
    MotorBike1 (String body, String brake, int tire,int muffler){ //생성자
        super(body,brake,tire,muffler);
    }
    public void info() {getInfo();} // 정보출력
    private void getInfo(){ //출력값 정의
        System.out.printf(" Bike =  %s 타입 바디, %d 개의 타이어, %s 타입의 브레이크, %d 개의 머플러 %n",getBody(),getTire(),getBrake(),getMuffler());

    }

}
class MotorBike2 extends Motor1 {
    String smartkey;
    MotorBike2 (String body, String brake, int tire,int muffler,String smartkey){ //생성자
        super(body,brake,tire,muffler);
        setSmartkey(smartkey);
    }
    public void info() {getInfo();}//정보출력
    private void getInfo() {  //출력값 정의
        System.out.printf(" Bike =  %s 타입 바디, %d 개의 타이어, %s 타입의 브레이크, %d 개의 머플러, %s 타입의 부트 %n",getBody(),getTire(),getBrake(),getMuffler(),getSmartkey());
    }
    private void setSmartkey(String smartkey) {
        this.smartkey = smartkey;
    }
    public  String getSmartkey() {return smartkey;}

}
class PrintInfo1 { //별도의 출력 클래스 생성
    void print (Information1 motor){motor.info();}
}

public class PolymorphismSimple {
    public static void main(String[] args) {
        Information1 gt = new MotorBike2("a","b",1,2,"c");
        Information1 gt1 = new MotorBike1("a1", "b1", 2,4);
        Information1 gt2 = new Motor1("a2","b2",2);

        PrintInfo1 p = new PrintInfo1();
        p.print(gt);
        p.print(gt1);
        p.print(gt2);
    }
}
