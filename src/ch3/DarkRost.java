package ch3;

public class DarkRost extends Beverage{
    public DarkRost() {
        description = "다크 로스트 커피";
    }
    @Override
    public double cost() {
        return .99;
    }
}
