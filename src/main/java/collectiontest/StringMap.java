package collectiontest;

import java.util.Objects;

public class StringMap {
    String string;

    public StringMap(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "StringMap{" +
            "string='" + string + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringMap stringMap = (StringMap) o;
        return Objects.equals(string, stringMap.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string);
    }
}
