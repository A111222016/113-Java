// 修改 Beverage 類別
public class Beverage extends Food {
    public Beverage(String name, double price, boolean vegetarian, int stock) {
        super(name, price, vegetarian, stock);
    }

    @Override
    public void prepare() {
        System.out.println("準備飲料：" + getName());
    }
}