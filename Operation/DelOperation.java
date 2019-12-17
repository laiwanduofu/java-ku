package package_test.Operation;

import package_test.book.Book;
import package_test.book.BookList;

import java.util.Scanner;

public class DelOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书：");
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入要删除的图书编号：");
        String num=scanner.next();
        int i=0;
        for(;i<bookList.getSize();i++){
            Book book=bookList.getBooks(i);
           if(book.getNum().equals(num)){
               break;
           }
        }
        if(i>=bookList.getSize()){
            System.out.println("不好意思，没有找到要删除的书");
        }
        bookList.setBooks(i,bookList.getBooks(bookList.getSize()-1));
        bookList.setSize(bookList.getSize()-1);
        System.out.println("删除成功");
    }
}
