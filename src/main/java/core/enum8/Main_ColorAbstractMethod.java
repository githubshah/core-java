package core.enum8;

// enum can have abstract method
enum ColorAbstractMethod {
    red {
        @Override
        public void draw() {
            System.out.println("c-red");
        }
    },
    green {
        @Override
        public void draw() {
            System.out.println("c-green");
        }
    },
    blue {
        @Override
        public void draw() {
            System.out.println("c-blue");
        }
    };

    public abstract void draw();
}

public class Main_ColorAbstractMethod {
    public static void main(String[] args) {
        ColorAbstractMethod.red.draw();
    }
}
