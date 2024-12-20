// Beverage 類別，實作 MenuItem 介面，表示飲品
public class Beverage implements MenuItem {
    private String name; // 飲品名稱
    private double price; // 飲品價格
    private boolean alcoholic; // 是否含酒精

    // 建構子
    public Beverage(String name, double price, boolean alcoholic) {
        this.name = name;
        this.price = price;
        this.alcoholic = alcoholic;
    }

    @Override
    public String getName() {
        return name; // 回傳飲品名稱
    }

    @Override
    public double getPrice() {
        return price; // 回傳飲品價格
    }

    @Override
    public String getCategory() {
        return alcoholic ? "Alcoholic Beverage" : "Non-Alcoholic Beverage"; // 根據是否含酒精回傳類別
    }

    @Override
    public boolean isVegetarian() {
        return true; // 飲品預設為素食
    }

    // 顯示飲品
    public void serve() {
        System.out.println("Serving beverage: " + name);
    }
}


