package learning.pattern.state;

import java.util.Arrays;
import java.util.List;

enum Alphabet {
    A {
        @Override
        public List<String> getColorSet() {
            return Arrays.asList("a1@gmail.com", "a2@gmail.com", "a3@gmail.com");
        }
    },
    B {
        @Override
        public List<String> getColorSet() {
            return Arrays.asList("b1@gmail.com", "b2@gmail.com", "b3@gmail.com");
        }
    },
    C {
        @Override
        public List<String> getColorSet() {
            return Arrays.asList("c1@gmail.com", "c2@gmail.com", "c3@gmail.com");
        }
    };

    public abstract List<String> getColorSet();
}

public class Color {

    final private Alphabet alphabet;
    private volatile int state = 0;

    public Color(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    public String getNextColor() {
        List<String> colorSet = this.alphabet.getColorSet();
        return colorSet.get(getAndIncrement());
    }

    synchronized private int getAndIncrement() {
        List<String> colorSet = this.alphabet.getColorSet();
        if (state >= colorSet.size()) {
            this.state = 0;
        }
        return this.state++;
    }
}


