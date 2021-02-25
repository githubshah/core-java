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
        colorCode.of("key");


        Set<String> hashSet = new HashSet();


        final int[] ctr = {1};
        IntStream.range(1, 1000).boxed().forEach(x -> {
            int index = colorCode.of(ctr[0] + "_Apple");
            //System.out.println("Apple_" + i[0] + " : " + index);
            hashSet.add("index: " + index + " Apple_" + ctr[0]);
            if (ctr[0] == 5) {
                ctr[0] = 1;
            } else {
                ctr[0] += 1;
            }
        });

        ctr[0] = 1;
        IntStream.range(1, 1000).boxed().forEach(x -> {
            int index = colorCode.of(ctr[0] + "_Banana");
            //System.out.println("Apple_" + i[0] + " : " + index);
            hashSet.add("index: " + index + " Banana_" + ctr[0]);
            if (ctr[0] == 5) {
                ctr[0] = 1;
            } else {
                ctr[0] += 1;
            }
        });

        System.out.println(hashSet.size());
        hashSet.stream().sorted().forEach(System.out::println);

    }


}
