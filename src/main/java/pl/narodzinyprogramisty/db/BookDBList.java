package pl.narodzinyprogramisty.db;

import pl.narodzinyprogramisty.domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BookDBList  implements BookDB{

    private List<Book> books;


    public BookDBList(){
        books = new ArrayList<>();
    }


    @Override
    public void add(Book book) {
        books.add(book);
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Book findBookById(int id) {
//        return books.stream().filter(book -> book.getId() == id).findFirst().get();

        for (Book book : books) {
            if (book.getId() == id)
                return book;
        }
        return null;
    }


}
