package rtek.perpus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import rtek.perpus.repository.BorrowRepository;
import rtek.perpus.repository.MemberRepository;
import rtek.perpus.services.IBookService;

@Controller
public class CmsController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/cms/")
    public String index(Model model) {
        long totalBook = bookService.getTotalAvailableBooks();
        long totalBorrow = borrowRepository.countByStatus("BORROW");
        long totalMember = memberRepository.count();

        model.addAttribute("totalBooks", totalBook);
        model.addAttribute("totalBorrows", totalBorrow);
        model.addAttribute("totalMember", totalMember);

        return "cms/index";
    }

    @GetMapping("/login/")
    public String login() {
        return "cms/login";
    }
}
