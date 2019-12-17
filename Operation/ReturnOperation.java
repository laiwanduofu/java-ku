package package_test.Operation;

import package_test.book.Book;
import package_test.book.BookList;

import java.util.Scanner;

public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入要归还的书号：");
        String num=scanner.next();
        for(int i=0;i<bookList.getSize();i++){
            Book book=bookList.getBooks(i);
            if(!book.getNum().equals(num)){
                continue;
            }
            if(!book.isBorrow()){
                System.out.println("这本书已经被归还了");
                break;
            }
            book.setBorrow(false);
        }
    }
}
