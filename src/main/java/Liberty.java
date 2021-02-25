import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

abstract class ColorCode{
    int loadFactor;
    String key;

    ColorCode(String key) {
        this.key = key;
        loadFactor = setLoadFactor();
    }

    abstract int setLoadFactor();

    final public int index() {
        return Math.floorMod(key.hashCode() + 2 * key.hashCode(), loadFactor);
    }
}

class MyColorCode extends ColorCode{

    MyColorCode(String key) {
        super(key);
    }

    @Override
    int setLoadFactor() {
        return 5;
    }
}


public class Liberty {

    public static void main(String[] args) {

        new ColorCode("sahid") {
            @Override
            int setLoadFactor() {
                return 5;
            }
        };



        Set<String> hashSet = new HashSet();



        final int[] ctr = {1};
        IntStream.range(1, 1000).boxed().forEach(x -> {
            int index = new MyColorCode(ctr[0] + "_Apple").index();
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
            int index = new MyColorCode(ctr[0] + "_Banana").index();
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
