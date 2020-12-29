package learning.core.aaJava8.stream8.innerJoin;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(String a[]) {

        ArrayList<Book> bookArrayList = new ArrayList<>();
        bookArrayList.add(new Book("bookName1", "a1"));
        bookArrayList.add(new Book("bookName2", "a2"));
        bookArrayList.add(new Book("bookName3", "a3"));
        bookArrayList.add(new Book("bookName4", "a4"));


        ArrayList<Author> authorArrayList = new ArrayList<>();
        authorArrayList.add(new Author("a3", "authName3"));
        authorArrayList.add(new Author("a4", "authName4"));
        authorArrayList.add(new Author("a5", "authName5"));
        authorArrayList.add(new Author("a6", "authName6"));


        //join operation
        String collect = bookArrayList.stream()
            .flatMap(
                _item1 -> authorArrayList.stream()
                    .map(_item2 -> (_item1.authorId == _item2.authorId) ?
                        "{" + _item1.getBookName() + ":" + _item2.authorName + "}" : null
                    )
            ).filter(Objects::nonNull)
            .collect(Collectors.joining(","));

        System.out.println(collect);






    }
}
