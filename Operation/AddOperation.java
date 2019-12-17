package package_test.Operation;

import package_test.book.Book;
import package_test.book.BookList;

import java.util.Scanner;


public class AddOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入要增加的书名：");
        String name=scanner.next();
        System.out.println("请输入作者名：");
        String author=scanner.next();
        System.out.println("请输入类型：");
        String type=scanner.next();
        System.out.println("请输入价格：");
        int price=scanner.nextInt();
        System.out.println("请输入编号：");
        String num=scanner.next();
        Book book=new Book(name,author,type,price,num,false);
        bookList.setBooks(bookList.getSize(),book);
        bookList.setSize(bookList.getSize()+1);
    }
}
