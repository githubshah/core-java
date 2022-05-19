package learning.pattern.singleton;

public class SingletonExample {
    public static void main(String[] args) {

        for (int i = 1; i < 500; i++) {
            new Thread(() -> {
                Singleton instance = null;
                try {
                    instance = Singleton.getInstance();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                assert instance != null;
                System.out.println(instance.hashCode());
            }).start();
        }
    }
}
