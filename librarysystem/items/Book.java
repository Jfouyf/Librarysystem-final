package librarysystem.items;

public class Book extends LibraryItem {
    private boolean isAvailable;

    public Book(String title, String author, String itemId, boolean isAvailable) {
        super(title, author, itemId);
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return super.toString() + ", isAvailable=" + isAvailable + '}';
    }
}

