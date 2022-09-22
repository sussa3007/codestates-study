package CodeStates.Section1.JavaOOPStudy.src;

class Bike {
    private String body;
    private int tire;
    private String brake;
    Bike (String body, String brake, int tire) {
        setBody(body);
        setBrake(brake);
        setTire(tire);
    }
    public void setBody(String body) {
        this.body = body;
    }
    public void setBrake(String brake) {
        this.brake = brake;
    }
    public void setTire(int tire) {
        this.tire = getTire(tire);
    }
    public void info () {
        getInfo(tire);
    }
    private int getTire (int tire){
        if (tire > 0  && tire%2 == 0) {
            return tire;
        } else{
            System.out.println("타이어의 개수는 홀수 또는 음수가 될수 없습니다");
            return 0;
        }
    }
    private void getInfo (int tire) {
        if(tire == 0) {
            System.out.println("Set 오류");

        }else {
            System.out.println("======= Bike 정보 =======");
            System.out.println(this.body + "타입 바디");
            System.out.println(this.brake + "타입 브레이크");
            System.out.println(this.tire + "개의 타이어");
            System.out.println("=========================");
        }
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        Bike gt = new Bike("Alu","Pad",2);
        gt.info();
        gt.setBody("Carbon");
        gt.setBrake("OilPad");
        gt.setTire(4);
        gt.info();
//        gt.brake = "Oil"; // private 제어자로 다른 클래스에서 참조할수 없음
//        gt.getInfo(4); // private 제어자로 다른 클래스에서 참조할수 없음

    }
}
