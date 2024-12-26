// 修改 Dessert 類別
public class Dessert extends Food {
    public Dessert(String name, double price, boolean vegetarian, int stock) {
        super(name, price, vegetarian, stock);
    }

    @Override
    public void prepare() {
        System.out.println("準備甜點：" + getName());
    }
}