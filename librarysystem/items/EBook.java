package librarysystem.items;

public class EBook extends LibraryItem {
    public EBook(String title, String author, String itemId) {
        super(title, author, itemId);
    }

    @Override
    public String toString() {
        return super.toString() + " (eBook)";
    }
}

