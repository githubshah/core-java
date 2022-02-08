package learning.core.aaJava8.stream8.innerJoin;

public class Book {
    String bookName;
    String authorId;

    public Book(String bookName, String authorId) {
        this.bookName = bookName;
        this.authorId = authorId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}
