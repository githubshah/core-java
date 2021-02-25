import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

class ColorCode {

    int loadFactor;

    public ColorCode(int loadFactor) {
        this.loadFactor = loadFactor;
    }

    public int of(String key) {
        return Math.floorMod(key.hashCode() + 2 * key.hashCode(), loadFactor);
    }

    static class Builder {
        private final int loadFactor;

        public Builder(int loadFactor) {
            this.loadFactor = loadFactor;
        }

        public ColorCode build() {
            return new ColorCode(loadFactor);
        }
    }
}


public class Liberty {

    public static void main(String[] args) {

        ColorCode colorCode = new ColorCode.Builder(5).build();
        System.out.println("Apple " + colorCode.of("Apple@gmail.com"));
        System.out.println("Apple_1 " + colorCode.of("Apple_1@gmail.com"));
        System.out.println("Apple_1 " + colorCode.of("Apple_1@gmail.com"));
        System.out.println("Apple " + colorCode.of("Apple@gmail.com"));
        System.out.println("Banana " + colorCode.of("Banana@gmail.com"));
        System.out.println("Carrot " + colorCode.of("Carrot@gmail.com"));
        System.out.println("Orange " + colorCode.of("Orange@gmail.com"));


    }


}
