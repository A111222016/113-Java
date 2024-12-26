// 修改 Food 類別
public abstract class Food implements MenuItem {
    private String name;
    private double price;
    private boolean vegetarian;
    private int stock;

    public Food(String name, double price, boolean vegetarian, int stock) {
        this.name = name;
        this.price = price;
        this.vegetarian = vegetarian;
        this.stock = stock;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public boolean isOutOfStock() {
        return stock <= 0;
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public void reduceStock() throws OutOfStockException {
        if (stock <= 0) {
            throw new OutOfStockException(name + " 缺貨中。");
        }
        stock--;
    }

    public abstract void prepare();
}