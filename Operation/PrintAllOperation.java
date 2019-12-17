package package_test.Operation;

import package_test.book.Book;
import package_test.book.BookList;

public class PrintAllOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("打印所有图书信息：");
       for(int i=0;i<bookList.getSize();i++){
           Book book=bookList.getBooks(i);
           System.out.println(book);
       }
        System.out.println("共计"+bookList.getSize()+"本书");
    }
}
