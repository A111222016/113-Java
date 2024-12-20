public class PhysicalBook extends Book{
    private String shelflocation;

    public PhysicalBook(String title, String author, String shelflocation) {
        super(title, author);
        this.shelflocation = shelflocation;
    }

    public String getShelflocation() {
        return shelflocation;
    }

    @Override
    public String toString() {
        return super.toString() + ", 書架位置: " + shelflocation;
    }


}
