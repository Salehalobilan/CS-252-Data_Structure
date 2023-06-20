public class Book extends Item {

    private String title, author;

    public Book(String id, String title, String author,int quantity,double price) {
        super(id, price, quantity);
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("Book -> %s ,Title= %s ,Author= %s %n",super.toString(),title,author);
    }

}
