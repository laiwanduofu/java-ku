package package_test.User;

import package_test.Operation.*;

import java.util.Scanner;

public class NormalUser extends user {
    public NormalUser(String name) {
        super(name);
        operations=new IOperation[]{
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation(),
                new PrintAllOperation(),
                new ExitOperation()
        };
    }

    @Override
    public int menu() {
        System.out.println("=====================");
        System.out.println("hello"+name);
        System.out.println("=======0,查找书籍=====");
        System.out.println("=======1,借阅书籍=====");
        System.out.println("=======2,归还书籍=====");
        System.out.println("=======3,打印所有信息= ");
        System.out.println("=======4,退出=========");
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入你的选择：");
        int choice=scanner.nextInt();
        return choice;
    }
}
