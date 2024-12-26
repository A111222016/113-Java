import java.util.List;

public class Combo implements MenuItem {
    private String name;
    private double price; // 固定價格，或者根據單品計算
    private boolean vegetarian;
    private int stock;
    private List<MenuItem> items; // 套餐內的單品

    public Combo(String name, List<MenuItem> items, int stock) {
        this.name = name;
        this.items = items;
        this.stock = stock;

        // 動態計算套餐價格與是否素食
        this.price = items.stream().mapToDouble(MenuItem::getPrice).sum();
        this.vegetarian = items.stream().allMatch(MenuItem::isVegetarian);
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
        return stock <= 0 || items.stream().anyMatch(MenuItem::isOutOfStock);
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public void reduceStock() throws OutOfStockException {
        if (isOutOfStock()) {
            throw new OutOfStockException(name + " 缺貨中。");
        }
        stock--;
        for (MenuItem item : items) {
            item.reduceStock();
        }
    }
}
