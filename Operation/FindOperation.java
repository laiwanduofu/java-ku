package package_test.Operation;

import package_test.book.Book;
import package_test.book.BookList;

import java.util.Scanner;

public class FindOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入要找的书名：");
        String name=scanner.next();
        int count=0;
        for (int i=0;i<bookList.getSize();i++){
            Book book=bookList.getBooks(i);
            if(book.getName().equals(name)){
                System.out.println(book);
                count++;
            }
        }
        if(count==0){
            System.out.println("不好意思，没有这本书");
        }else {
            System.out.println("共计"+count+"本书");
        }
    }
}
