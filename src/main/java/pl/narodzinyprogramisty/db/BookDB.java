package pl.narodzinyprogramisty.db;

import pl.narodzinyprogramisty.domain.Book;

import java.util.List;

public interface BookDB {
    void add(Book book);

    List<Book> getBooks();

    Book findBookById(int book);
}
