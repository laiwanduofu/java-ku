package package_test.Operation;

import package_test.book.Book;
import package_test.book.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅书籍");
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入要查找的编号：");
        String num=scanner.next();
        for(int i=0;i<bookList.getSize();i++){
            Book book=bookList.getBooks(i);
             if(!book.getNum().equals(num)){
                 continue;
             }
             if(book.isBorrow()){
                 System.out.println("这本书已经被借走了");
                 break;
             }
             book.setBorrow(true);
        }

    }
}
