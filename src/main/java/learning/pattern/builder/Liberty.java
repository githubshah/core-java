package learning.pattern.builder;

class ColorCode {

    int loadFactor;

    public ColorCode(int loadFactor) {
        this.loadFactor = loadFactor;
    }

    public int getLoadFactor(){
        return loadFactor;
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
        System.out.println("Apple " + colorCode.getLoadFactor());
    }

}
