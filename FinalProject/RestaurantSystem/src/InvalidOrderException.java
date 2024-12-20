// 自訂例外類別，表示無效訂單
public class InvalidOrderException extends Exception {
    public InvalidOrderException(String message) {
        super(message); // 呼叫父類別建構子
    }
}

