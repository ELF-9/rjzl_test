import com.neng.pojo.Books;
import com.neng.service.bookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class my_test {
    @Test
    public void test(){
        ApplicationContext context =new ClassPathXmlApplicationContext("appContext.xml");
        bookService bookServicelmpl = context.getBean("bookServicelmpl",bookService.class);
        Books book =new Books();
        book.setBookID(7);
        book.setBookName("c++");
        book.setBookCounts(5);
        book.setDetail("放弃吧孩子");
        bookServicelmpl.addBook(book);
        for (Books books : bookServicelmpl.queryAllBook()) {
            System.out.println(books);
        }

    }
}
