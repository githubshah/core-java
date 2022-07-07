package learning.pattern.builder;

final class ColorCode {
    final private int codeNumber;

    final private int codeName;

    public ColorCode(Builder builder) {
        this.codeNumber = builder.getCodeNumber();
        this.codeName = builder.getCodeName();
    }

    public int getCodeName() {
        return codeName;
    }

    public int getCodeNumber() {
        return codeNumber;
    }

    public static class Builder {
        private int codeNumber;

        public int getCodeNumber() {
            return codeNumber;
        }

        public Builder setCodeNumber(int codeNumber) {
            this.codeNumber = codeNumber;
            return this;
        }

        private int codeName;

        public int getCodeName() {
            return codeName;
        }

        public Builder setCodeName(int codeName) {
            this.codeName = codeName;
            return this;
        }

        public ColorCode build() {
            return new ColorCode(this);
        }
    }
}


public class Liberty {

    public static void main(String[] args) {
        ColorCode colorCode = new ColorCode.Builder().
                setCodeName(1).
                setCodeNumber(2).
                build();
        System.out.println("Apple " + colorCode.getCodeNumber());
    }

}
