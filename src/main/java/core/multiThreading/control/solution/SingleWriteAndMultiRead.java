package core.multiThreading.control.solution;




public class SingleWriteAndMultiRead {

    static class Resources {
        private int ctr;

        void incrementCtr() {
            ctr = ctr + 1;
            //System.out.println(Thread.currentThread().getName() + ": increased value: " + ctr);
        }

        int getCtr() {
            return ctr;
        }
    }

    static class Writer implements Runnable {

        private Resources ctr;

        public Writer(Resources resources) {
            this.ctr = resources;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                ctr.incrementCtr();
            }
        }
    }

    static class Reader implements Runnable {

        private Resources ctr;

        public Reader(Resources resources) {
            this.ctr = resources;
        }

        @Override
        public void run() {
            System.out.println(">>>>>"+Thread.currentThread().getName() + ": get increased value: " + ctr.getCtr());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Resources resources = new Resources();
        Thread writer = new Thread(new Writer(resources), "writer");
        writer.start();
        writer.join();
        new Thread(new Reader(resources), "reader").start();
    }
}
