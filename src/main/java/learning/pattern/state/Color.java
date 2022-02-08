package learning.pattern.state;

import java.util.Arrays;
import java.util.List;

enum Alphabet {
    A {
        @Override
        public List<String> getColorSet() {
            return Arrays.asList("a1@gmail.com", "a2@gmail.com", "a3@gmail.com");
          /*  return Arrays.asList(
                "https://lh3.googleusercontent.com/-XdUIqdMkCWA/AAAAAAAAAAI/AAAAAAAAAAA/V8BNOaftJmYkbl0SK3Zpj7t9lcQ22-JxgCLcDEAEiGQoBQRD___________8BGLeA9fr______wE/s100/photo.jpg",
                "https://lh3.googleusercontent.com/-XdUIqdMkCWA/AAAAAAAAAAI/AAAAAAAAAAA/V8BNOaftJmYdxrqGqF9k3MIpSOKw_iKEACLcDEAEiGQoBQRD___________8BGJuvhfj______wE/s100/photo.jpg",
                "https://lh3.googleusercontent.com/-XdUIqdMkCWA/AAAAAAAAAAI/AAAAAAAAAAA/V8BNOaftJmYx9dfoH92hC52WcK_bAuMaACLcDEAEiGQoBQRD___________8BGKK_7Pv______wE/s100/photo.jpg",
                "https://lh3.googleusercontent.com/-XdUIqdMkCWA/AAAAAAAAAAI/AAAAAAAAAAA/V8BNOaftJmYVRHptyndeglczMoKW3xZogCLcDEAEiGQoBQRD___________8BGIDYvf_______wE/s100/photo.jpg",
                "https://lh3.googleusercontent.com/-XdUIqdMkCWA/AAAAAAAAAAI/AAAAAAAAAAA/V8BNOaftJmYETx7Nf0iPKEvW6D0DGjwYwCLcDEAEiGQoBQRD___________8BGLi-ovv______wE/s100/photo.jpg");*/
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

    private volatile int state = 0;

    final private Alphabet alphabet;

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


