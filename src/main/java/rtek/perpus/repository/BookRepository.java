package rtek.perpus.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rtek.perpus.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);

    @Query(value = "Select b From Book b Where b.qty > 0")
    Page<Book> getAvailableBooks(Pageable pageable);

    @Query(value = "Select b From Book b Where b.qty = 0")
    Page<Book> getNotAvailableBooks(Pageable pageable);

    @Query(value = "Select Count(b) From Book b Where b.qty > 0")
    long getTotalAvailableBooks();

    @Query(value = "Select b From Book b Where b.title = :title And b.author = :author")
    Optional<Book> getBook(@Param("title") String title, @Param("author") String author);

    @Query(value = "Select b From Book b Where b.title = :title")
    Optional<Book> getBook(@Param("title") String title);
}
