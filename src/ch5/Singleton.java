package ch5;

public class Singleton {

    // 고전적인 싱글톤 방법
    private static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
}
