public class App {
    public static void main(String[] args) throws Exception {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        if (s1 == s2) {System.out.println("s1 and s2 are the same object");}
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
