package package_test.Operation;

import package_test.book.BookList;

public class ExitOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("再见！");
        System.exit(0);
    }
}
