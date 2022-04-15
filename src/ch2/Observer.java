package ch2;

public interface Observer {
    // 기상 정보가 변경되었을 때 옵저버에게 전달되는 상태값
    void update();
}
