import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
public class CheckedException {
    public static void main(String[] args) {
        try {
            File file = new File("nonefile.txt");
            FileReader reader = new FileReader(file);
            System.out.println("處理受檢例外");
        } catch (FileNotFoundException ex) {
            System.out.println("檔案不存在");
        }
    }
}
