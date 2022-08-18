package learning.core.G_enum8;

enum ColorConstructor {
    red("RED"),
    green("GREEN"),
    blue("BLUE");

    private String value;  // prevent value to override by FINAL keyword

    ColorConstructor(String value) {
        this.value = value;
    } // constructor should be private

    public String getValue() {
        return value;
    }

    public void setValue(String override) {
        this.value = override;
    }
}

public class Main_ColorConstructor {
    public static void main(String[] args) {
        System.out.println(ColorConstructor.red.getValue());
        ColorConstructor.red.setValue("PINK");
        System.out.println(ColorConstructor.red.getValue()); // override the value and set to PINK
    }
}
