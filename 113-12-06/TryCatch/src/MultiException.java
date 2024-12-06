import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
public class MultiException {
    public static void main(String[] args) {
        int [] numbers = {1, 2, 3};
        try{
            File file = new File("nonefile.txt");
            FileReader reader = new FileReader(file);
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("處理未檢例外"+ e.getMessage());
        } catch (Exception e) {
            System.out.println("處理受檢例外"+ e.getMessage());
        }
    }
}
