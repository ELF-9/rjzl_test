package com.neng.controller;
import com.neng.pojo.Books;
import com.neng.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class bookController {
    //controller层调用dao层
    @Autowired
    @Qualifier("bookServicelmpl")
    private bookService bookservice;
//    ****************************************************************************查看所有书籍
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookservice.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }
//    *****************************************************************************增加书籍
    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }
        @RequestMapping("/addBook")
        public String addPaper(Books books) {
            bookservice.addBook(books);
            return "redirect:/book/allBook";
        }
//    *****************************************************************************修改书籍
@RequestMapping("/toUpdateBook")
public String toUpdateBook(Model model, int id) {
    Books books = bookservice.queryBookById(id);
    model.addAttribute("book",books );
    return "updateBook";
}
    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        bookservice.updateBook(book);
//        Books books = bookservice.queryBookById();
        model.addAttribute("books", book);
        return "redirect:/book/allBook";
    }
//    *****************************************************************************删除书籍

    @RequestMapping("/del/{bookId}")//fulret风格
    public String deleteBook(@PathVariable("bookId") int id) {
        bookservice.deleteBookById(id);
        return "redirect:/book/allBook";
    }
//    *****************************************************************************查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model) {
        Books books = bookservice.queryBookByName(queryBookName);
        System.out.println(books);
        List<Books> list = new ArrayList<>();
        list.add(books);
        if(books == null) {
            list = bookservice.queryAllBook();
            model.addAttribute("error","未查到");
        }
        model.addAttribute("list", list);
        return "allBook";
    }
}
