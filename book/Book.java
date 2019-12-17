package package_test.book;

public class Book {
    private String name;
    private String author;
    private String type;
    private int    price;
    private String num;
    private boolean isBorrow;

    public Book(String name, String author, String type, int price, String num, boolean isBorrow) {
        this.name = name;
        this.author = author;
        this.type = type;
        this.price = price;
        this.num = num;
        this.isBorrow = isBorrow;
    }

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", num='" + num + '\'' +
                ", isBorrow=" + isBorrow +
                '}';
    }

    public boolean isBorrow() {
        return isBorrow;
    }

    public void setBorrow(boolean borrow) {
        isBorrow = borrow;
    }
}
