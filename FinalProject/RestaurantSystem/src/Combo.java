import java.util.ArrayList;

// Combo 類別表示套餐，實作 MenuItem 介面
public class Combo implements MenuItem {
    private String name; // 套餐名稱
    private ArrayList<MenuItem> items; // 套餐項目列表
    private double discount; // 折扣率

    // 建構子
    public Combo(String name, double discount) {
        this.name = name;
        this.items = new ArrayList<>();
        this.discount = discount;
    }

    // 添加項目到套餐
    public void addItem(MenuItem item) {
        items.add(item);
    }

    @Override
    public String getName() {
        return name; // 回傳套餐名稱
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice(); // 計算套餐總價
        }
        return total * (1 - discount); // 套用折扣後的價格
    }

    @Override
    public String getCategory() {
        return "Combo"; // 回傳類別為套餐
    }

    @Override
    public boolean isVegetarian() {
        for (MenuItem item : items) {
            if (!item.isVegetarian()) {
                return false; // 若有非素食項目則回傳 false
            }
        }
        return true;
    }

    // 顯示套餐細節
    public void showComboDetails() {
        System.out.println("Combo: " + name);
        for (MenuItem item : items) {
            System.out.println("- " + item.getName() + ": $" + item.getPrice());
        }
        System.out.println("Total price after discount: $" + getPrice());
    }
}
