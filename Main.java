package package_test;

import package_test.User.Admin;
import package_test.User.NormalUser;
import package_test.User.user;
import package_test.book.BookList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookList bookList=new BookList(); //准备好书籍的信息
        user users=login();
        while (true){
            int choice=users.menu();
            users.doOperation(choice,bookList);
        }
    }

    public static user login(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入你的姓名：");
         String name=scanner.next();
        System.out.println("请输入你的身份：1，普通用户, 2，管理员");
        int role= scanner.nextInt();
        if(role==1){
           return new NormalUser(name);
        }
            return new Admin(name);
    }
}
