package com.neng.service;

import com.neng.dao.bookMapper;
import com.neng.pojo.Books;
import org.springframework.stereotype.Service;

import java.util.List;

public class bookServicelmpl  implements bookService{

    //调用dao层的操作，设置一个set接口，方便Spring管理,组合dao层
    private bookMapper bookmapper;
    public void setBookmapper(bookMapper bookmapper) {
        this.bookmapper = bookmapper;
    }
    @Override
    public int addBook(Books books) {
        return bookmapper.addBook(books);
    }

    @Override
    public int deleteBookById(int id) {
        return bookmapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookmapper.updateBook(books);
    }
    @Override
    public Books queryBookById(int id) {
        return bookmapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookmapper.queryAllBook();
    }

    @Override
    public Books queryBookByName(String bookName) {
        return bookmapper.queryBookByName(bookName);
    }


}
