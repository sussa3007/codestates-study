package CodeStates.Section1.JavaOOPStudy.src;

class Product {
    double price;
    double dcrate;
    double dcprice;
    double cal (double price, double dcrate) {
        this.price = price;
        this.dcrate = dcrate;
        return this.dcprice = price-(price * dcrate);
    }
 }
class Tv extends Product {
    Tv () {
        super.price = 100;
        super.dcrate = 0.1;
        super.dcprice = price-(price*dcrate);
    }
    public String toString() {
        return "TV "+dcprice+"만원";
    }
}
class SmartTv extends Product {
    SmartTv () {
        super.price = 200;
        super.dcrate = 0.2;
        super.dcprice = price-(price*dcrate);
    }
    public String toString() {
        return "SmartTV "+dcprice+"만원";
    }
}
class Desktop extends Product {
    Desktop () {
        super.price = 150;
        super.dcrate = 0.2;
        super.dcprice = price-(price*dcrate);
    }
    public String toString() {
        return "DeskTop "+dcprice+"만원";
    }

}
class Notebook extends Product {
    Notebook () {
        super.price = 200;
        super.dcrate = 0.1;
        super.dcprice = price-(price*dcrate);
    }
    public String toString() {
        return "NoteBook "+dcprice+"만원";
    }
}
class Buyer {
    double money = 1000;
    double totalrate;
    void buy (Product a) {
        if(money < a.dcprice) {
            System.out.println("잔액부족");
        }else {
            money = money - a.dcprice;
            totalrate = a.dcrate;
            System.out.println(a+" 구매 완료!!");
            System.out.println("총 할인율은 "+totalrate*100 +" %입니다.");
            System.out.println("잔액 "+money +" 만원이 남았습니다.");
        }
    }
}



public class MartApp {
    public static void main(String[] args) {
        Product p[] = {new Tv(), new SmartTv(), new Desktop(),new Notebook()};
        // 위의 코드 한줄과 같다
//        p[0] = new Tv();
//        p[1] = new SmartTv();
//        p[2] = new Desktop();
//        p[3] = new Notebook();
        for (int i = 0; i < p.length; i++) {
            System.out.println("arrayProduct["+i+"] = " + p[i]);
        }

        Buyer b1 = new Buyer();
        b1.buy(p[0]);
    }
}
