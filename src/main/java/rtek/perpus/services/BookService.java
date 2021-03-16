package rtek.perpus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;
import rtek.perpus.models.Book;
import rtek.perpus.repository.BookRepository;

import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private Validator validator;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<Book> getAvailableBooks(Pageable page) {
        return bookRepository.getAvailableBooks(page);
    }

    @Override
    public Page<Book> getNotAvailableBooks(Pageable page) {
        return bookRepository.getNotAvailableBooks(page);
    }

    @Override
    public Optional<Book> findBook(String title, String author) {
        return bookRepository.getBook(title, author);
    }

    @Override
    public Optional<Book> findBook(String title) {
        return bookRepository.getBook(title);
    }

    @Override
    public Optional<Book> findBook(long bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public boolean createBook(String isbn, String title, String author, int qty) {
        Book b = new Book();
        b.setIsbn(isbn);
        b.setTitle(title);
        b.setAuthor(author);
        b.setQty(qty);

        if (qty <= 0) {
            b.setStatus("NOT_AVAILABLE");
        } else {
            b.setStatus("AVAILABLE");
        }

        try {
            bookRepository.save(b);
            return true;
        } catch (Exception e) {
        }

        return false;
    }

    @Override
    public long getTotalAvailableBooks() {
        return bookRepository.getTotalAvailableBooks();
    }
}
