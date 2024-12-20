// Dessert 類別繼承 Food，表示甜點
public class Dessert extends Food {
    public Dessert(String name, double price, boolean vegetarian) {
        super(name, price, vegetarian); // 呼叫父類別建構子
    }

    @Override
    public void prepare() {
        System.out.println("Preparing dessert: " + getName()); // 準備甜點
    }
}


