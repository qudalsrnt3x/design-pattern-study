package ch1;

public class MiniDuckSimulator {
    public static void main(String[] args) {

        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();

        Duck model = new ModelDuck();
        model.performFly(); // 생성할 때 초기화된 FlyNoWay 인스턴스 호출
        model.setFlyBehavior(new FlyRocketPowered()); // setter 메서드로 동적으로 변경
        model.performFly(); // FlyRocketPowered 인스턴스 호출
    }
}
