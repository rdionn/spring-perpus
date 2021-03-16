package rtek.perpus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rtek.perpus.models.Book;
import rtek.perpus.services.IBookService;
import rtek.perpus.ui.CreateBook;

import javax.validation.Valid;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("/cms/books/")
    public String index(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "entry", defaultValue = "10") int entry,
            @RequestParam(value = "status", defaultValue = "AVAILABLE") String status,
            Model model) {
        Page<Book> books;
        String realStatus = status.isEmpty() ? "AVAILABLE" : status;

        if (realStatus.equals("AVAILABLE")) {
            books = bookService.getAvailableBooks(PageRequest.of(page - 1, entry));
        } else {
            books = bookService.getNotAvailableBooks(PageRequest.of(page - 1, entry));
        }

        model.addAttribute("books", books);

        return "book/index";
    }

    @GetMapping("/cms/book/create/")
    public String createBook(@ModelAttribute("book") CreateBook book) {
        return "book/create";
    }

    @PostMapping("/cms/book/create/")
    public String doCreateBook(@Valid @ModelAttribute("book") CreateBook book, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (bookService.createBook(book.getIsbn(), book.getTitle(), book.getAuthor(), book.getQty())) {
                return "redirect:/books";
            }
        }

        return "book/create";
    }
}
