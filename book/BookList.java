package package_test.book;

public class BookList {
    private Book[]books=new Book[100];
   private int size=3;

    public BookList() {
       books[0]=new Book("《三国演义》",
               "罗贯中","小说",100,"0001",true);
       books[1]=new Book("《远山淡影》","石黑雄一",
               "小说",70,"0004",false);
       books[3]=new Book("《倒悬的地平线》","马克李维","小说",
               70,"00005",true);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Book getBooks(int index) {
        return books[index];
    }

    public void setBooks(int index,Book book) {
        books[index]=book;
    }

}
