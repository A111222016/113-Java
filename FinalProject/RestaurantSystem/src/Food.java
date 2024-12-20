// 定義抽象類別 Food，實作 MenuItem 介面
public abstract class Food implements MenuItem {
    private String name; // 食物名稱
    private double price; // 食物價格
    private boolean vegetarian; // 是否為素食

    // 建構子
    public Food(String name, double price, boolean vegetarian) {
        this.name = name;
        this.price = price;
        this.vegetarian = vegetarian;
    }

    @Override
    public String getName() {
        return name; // 回傳名稱
    }

    @Override
    public double getPrice() {
        return price; // 回傳價格
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian; // 回傳是否為素食
    }

    @Override
    public String getCategory() {
        return "General"; // 預設類別為 General
    }

    // 抽象方法，由子類別實作
    public abstract void prepare();
}


