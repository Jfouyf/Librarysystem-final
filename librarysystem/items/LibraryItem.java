package librarysystem.items;

public abstract class LibraryItem {
    private String title;
    private String author;
    private String itemId;

    public LibraryItem(String title, String author, String itemId) {
        this.title = title;
        this.author = author;
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getItemId() {
        return itemId;
    }

    @Override
    public String toString() {
        return "LibraryItem{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", itemId='" + itemId + '\'' +
                '}';
    }
}


