public class Book {

    String id;
    String title;
    String author;

    Book(String id, String title, String author ) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

   public void tampilkanInfo() {
    System.out.println("ID      : " + id);
    System.out.println("Judul   : " + title);
    System.out.println("Penulis : " + author);
}
}