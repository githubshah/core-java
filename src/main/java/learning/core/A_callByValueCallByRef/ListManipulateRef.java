package learning.core.A_callByValueCallByRef;

import java.util.ArrayList;
import java.util.List;

// java pass by value
// so any change in value will impact all memory model but ref will never impact to others.
public class ListManipulateRef {

    public static void main(String[] args) {
        stringlist();
        stringBufferlist();
    }

    private static void stringlist() {
        String sb = new String("sahid");

        List<String> list = new ArrayList<>();
        list.add(sb);  // pass by value

        sb = sb + "-hussain";  // manipulate value should impact but '+' creates a new ref.
        sb = "-shah"; // manipulate the ref will never impact list element

        System.out.println(list);
    }

    private static void stringBufferlist() {
        StringBuffer sb = new StringBuffer("sahid");

        List<StringBuffer> list = new ArrayList<>();
        list.add(sb);

        sb.append("-hussain"); // manipulate value will impact
        sb = new StringBuffer("-shah"); // manipulate the ref will never impact list element

        System.out.println(list);
    }
}
