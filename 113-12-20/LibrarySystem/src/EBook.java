public class EBook extends Book{
    private String DownloadUrl;

    public EBook(String title, String author, String DownloadUrl) {
        super(title, author);
        this.DownloadUrl = DownloadUrl;
    }

    public String getUrl() {
        return DownloadUrl;
    }

    @Override
    public String toString() {
        return super.toString() + ", 網址: " + DownloadUrl;
    }

}
