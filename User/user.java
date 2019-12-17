package package_test.User;

import package_test.Operation.IOperation;
import package_test.book.BookList;

abstract public class user {
    protected String name;
     public user(String name) {
         this.name = name;
     }
     abstract public int  menu();
     protected IOperation[]operations;
    public  void doOperation(int choice, BookList bookList){
            operations[choice].work(bookList);
    }
}
