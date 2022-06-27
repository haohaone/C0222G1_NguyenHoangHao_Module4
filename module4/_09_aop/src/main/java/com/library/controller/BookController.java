package com.library.controller;

import com.library.model.Book;
import com.library.model.OrderBook;
import com.library.service.BookService;
import com.library.service.OrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private OrderBookService orderBookService;

    @GetMapping("/")
    public String showBookList(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Book> bookList = bookService.findAllBook(PageRequest.of(page, 3));
        model.addAttribute("bookList", bookList);
        return "library";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "detail";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        bookService.borrow(book);
        int random = (int) ((Math.random()) * ((99999 - 10000) + 1) + 10000);
        LocalDate localDate = LocalDate.now();
        OrderBook orderBook = new OrderBook(String.valueOf(random),
                localDate.toString(),
                book);
        orderBookService.save(orderBook);
        String msg = "Sách '" + book.getName() + "' Với ID là " + book.getId() + " đã được mượn thành công";
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/";
    }

    @PostMapping("/giveback")
    public String giveback(@RequestParam("orderBookId") String id, RedirectAttributes redirectAttributes) {
        OrderBook orderBook = orderBookService.findById(id);
        List<OrderBook> orderBookList = orderBookService.findAll();
        if (orderBookList.isEmpty()){
            String msg = "Đã trả hết sách cho thư viện";
            redirectAttributes.addFlashAttribute("msg", msg);
            return "redirect:/";
        }
        if (orderBook == null){
            String msg = "Không có mã mượn sách";
            redirectAttributes.addFlashAttribute("msg", msg);
            return "redirect:/";
        }
        Book book = orderBook.getBook();
        bookService.giveback(book);
        orderBookService.delete(orderBook);
        String msg = "Sách '" + book.getName() + "' Với ID là " + book.getId() + " đã trả sách thành công";
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/";
    }
}
