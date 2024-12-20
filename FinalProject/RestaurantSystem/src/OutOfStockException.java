// 自訂例外類別，表示缺貨情況
public class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message); // 呼叫父類別建構子
    }
}
