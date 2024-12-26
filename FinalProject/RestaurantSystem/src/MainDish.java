// 修改 MainDish 類別
public class MainDish extends Food {
    public MainDish(String name, double price, boolean vegetarian, int stock) {
        super(name, price, vegetarian, stock);
    }

    @Override
    public void prepare() {
        System.out.println("準備主菜：" + getName());
    }
}