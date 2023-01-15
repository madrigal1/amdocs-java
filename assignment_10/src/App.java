public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}

class Singleton {
    private static Singleton _instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {

        if (_instance == null) {
            _instance = new Singleton();
        }
        return _instance;
    }
}
