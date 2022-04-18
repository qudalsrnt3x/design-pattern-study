package ch3;

public class Espresso extends Beverage{

    public Espresso() {
        description = "에스프레소"; // Beverage 클래스에서 상속받은 변수
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
