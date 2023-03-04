package domain;

public class Book extends Product{
    private int isbn;

    public Book(int isbn) {
        this.isbn = isbn;
    }

    public Book(String name, String description, double price, int isbn) {
        super(name, description, price);
        this.isbn = isbn;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
}
