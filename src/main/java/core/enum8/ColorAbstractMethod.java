package core.enum8;

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
