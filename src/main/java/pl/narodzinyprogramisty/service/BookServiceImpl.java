package pl.narodzinyprogramisty.service;

import pl.narodzinyprogramisty.db.BookDB;
import pl.narodzinyprogramisty.db.BookDBList;
import pl.narodzinyprogramisty.domain.Book;
import pl.narodzinyprogramisty.exceptions.NegativeValueException;

import java.util.Objects;

public class BookServiceImpl implements BookService {


    private BookDB bookDB = new BookDBList();


    @Override
    public void addBook(Book book) {
        Objects.requireNonNull(book);

        bookDB.add(book);
    }

    @Override
    public void editQuantity(int id, int newValue) throws NegativeValueException {
        Book tempBook = bookDB.findBookById(id);

        Objects.requireNonNull(tempBook);

        if (isPositive(newValue)) {
            tempBook.setQuantity(newValue);
        } else{
            throw new NegativeValueException("Quantity negative");
        }
    }

    @Override
    public void editBookPrice(int id, double newValue) throws NegativeValueException {
        Book tempBook = bookDB.findBookById(id);

        Objects.requireNonNull(tempBook);

        if (isPositive(newValue)){
            tempBook.setPrice(newValue);
        }else {
            throw new NegativeValueException("Price negative");
        }
    }

    private  <T extends Number> boolean isPositive(T t) {
        return t.doubleValue() >= 0;
    }

}
