package package_test.User;

import package_test.Operation.*;

import java.util.Scanner;

 public class Admin extends user {
     public Admin(String name) {
         super(name);
         operations=new IOperation[]{
                 new AddOperation(),
                 new FindOperation(),
                 new DelOperation(),
                 new PrintAllOperation(),
                 new ExitOperation()
         };
     }
     @Override
     public int menu() {
         System.out.println("=========================");
         System.out.println("hello"+name);
         System.out.println("===========0,增加书籍=====");
         System.out.println("===========1,查找书籍=====");
         System.out.println("===========2,删除书籍=====");
         System.out.println("===========3,打印所有=====");
         System.out.println("===========4,退出=========");
         Scanner scanner=new Scanner(System.in);
         System.out.println("请输入你的选择：");
         int choice=scanner.nextInt();
         return choice;
     }
 }
