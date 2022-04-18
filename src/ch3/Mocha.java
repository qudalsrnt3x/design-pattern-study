package ch3;

public class Mocha extends CondimentDecorator{

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + .20;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 모카";
        // 먼저 장식하고 있는 객체에 작업을 위임한 다음, 그 결과에 '모카'를 더한 값을 리턴한다.
    }
}
