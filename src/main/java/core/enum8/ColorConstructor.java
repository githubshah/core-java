package core.enum8;

enum ColorConstructor {
    red("RED"),
    green("GREEN"),
    blue("BLUE");

    private final String value;

    ColorConstructor(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
