package pl.narodzinyprogramisty.domain;

public class Book {
    private static int id = 1000;
    private String title;
    private String author;
    private double price;
    private int quantity;


    public Book(String title, String author, double price, int quantity) {
        id++;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        Book.id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
