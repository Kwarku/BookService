package pl.narodzinyprogramisty.service;

import pl.narodzinyprogramisty.domain.Book;
import pl.narodzinyprogramisty.exceptions.NegativeValueException;

public interface BookService {
    void addBook(Book book);

    void editQuantity(int id, int newValue) throws NegativeValueException;

    void editBookPrice(int id, double newValue) throws NegativeValueException;
}
