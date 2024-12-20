// MainDish 類別繼承 Food，表示主菜
public class MainDish extends Food {
    public MainDish(String name, double price, boolean vegetarian) {
        super(name, price, vegetarian); // 呼叫父類別建構子
    }

    @Override
    public void prepare() {
        System.out.println("Preparing main dish: " + getName()); // 準備主菜
    }
}


