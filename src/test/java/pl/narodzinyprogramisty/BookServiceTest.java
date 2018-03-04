package pl.narodzinyprogramisty;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import pl.narodzinyprogramisty.domain.Book;
import pl.narodzinyprogramisty.exceptions.NegativeValueException;
import pl.narodzinyprogramisty.service.BookService;
import pl.narodzinyprogramisty.service.BookServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
    private BookService bookService;
    private Book book;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        bookService = new BookServiceImpl();
        book = new Book("Title", "Author", 10.5, 15);
    }

    @Test
    public void addNullBookTest() {
        thrown.expect(NullPointerException.class);

        bookService.addBook(null);
    }

    @Test
    public void addBookTest() {
        bookService.addBook(new Book());

    }

    @Test
    public void editNullBookQuantityTest() throws NegativeValueException {
        thrown.expect(NullPointerException.class);

        bookService.editQuantity(15,12);
    }

    @Test
    public void editNegativeQuantityTest() throws NegativeValueException {
        bookService.addBook(book);
        thrown.expect(NegativeValueException.class);
        thrown.expectMessage("Quantity negative");

        bookService.editQuantity(book.getId(), -1);
    }

    @Test
    public void editQuantityTest() throws NegativeValueException {
        bookService.addBook(book);
        bookService.editQuantity(book.getId(), 0);

        assertThat(book.getQuantity()).isEqualTo(0);
    }

    @Test
    public void editNullBookPriceTest() throws NegativeValueException {
        thrown.expect(NullPointerException.class);

        bookService.editBookPrice(0, 10);
    }

    @Test
    public void editNegativePriceTest() throws NegativeValueException {
        bookService.addBook(book);

        thrown.expect(NegativeValueException.class);
        thrown.expectMessage("Price negative");

        bookService.editBookPrice(book.getId(), -1);
    }

    @Test
    public void editPriceTest() throws NegativeValueException {
        bookService.addBook(book);

        bookService.editBookPrice(book.getId(), 0);

        assertThat(book.getPrice()).isEqualTo(0);
    }
}
