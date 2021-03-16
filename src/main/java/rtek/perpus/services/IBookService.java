package rtek.perpus.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rtek.perpus.models.Book;

import java.util.Optional;

public interface IBookService {
    Page<Book> getAvailableBooks(Pageable page);
    Page<Book> getNotAvailableBooks(Pageable page);
    long getTotalAvailableBooks();
    Optional<Book> findBook(String title, String author);
    Optional<Book> findBook(String title);
    Optional<Book> findBook(long bookId);
    boolean createBook(String isbn, String title, String author, int qty);
}
