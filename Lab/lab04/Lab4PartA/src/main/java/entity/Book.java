package entity;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private int isbn;
    private String title;
    private String author;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinTable(name="book_pub",
    joinColumns = {@JoinColumn(name="isbn_num")},
    inverseJoinColumns = {@JoinColumn(name="pub_id")})

    private Publisher publisher;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book() {

    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher=" + publisher +
                '}';
    }
}
