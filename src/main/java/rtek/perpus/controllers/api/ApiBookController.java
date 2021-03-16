package rtek.perpus.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rtek.perpus.models.Book;
import rtek.perpus.services.IBookService;
import rtek.perpus.ui.api.ApiResult;

@RestController
@RequestMapping("/api/")
public class ApiBookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("/books")
    @Procedure("application/json")
    public ApiResult<Book> index(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "entry", defaultValue = "10") int entry
    ) {
        ApiResult<Book> books = new ApiResult<>();
        Page<Book> dbBooks = bookService.getAvailableBooks(PageRequest.of(page - 1, entry));

        books.setData(dbBooks.getContent());
        books.getMetadata().setCurrentPage(page);
        books.getMetadata().setTotalPages(dbBooks.getTotalPages());
        books.getMetadata().setTotalData(dbBooks.getTotalElements());

        return books;
    }
}
