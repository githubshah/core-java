package learning.pattern.singleton;

public class SingletonExample {
    public static void main(String[] args) {

        for (int i = 1; i < 500; i++) {
            new Thread(() -> {
                Singleton instance = null;
                Resource instance1 = null;
                try {
                    instance = Singleton.getInstance();
                    instance1 = Resource.getInstance();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                assert instance != null;
                assert instance1 != null;
                System.out.println(instance.hashCode() + " : " + instance1.hashCode());
            }).start();
        }
    }
}
