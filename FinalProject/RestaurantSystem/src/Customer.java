// Customer 類別，表示顧客
public class Customer {
    private String name; // 顧客名稱
    private boolean isMember; // 是否為會員
    private double totalSpent; // 總消費金額

    // 建構子
    public Customer(String name, boolean isMember) {
        this.name = name;
        this.isMember = isMember;
        this.totalSpent = 0;
    }

    public String getName() {
        return name; // 回傳顧客名稱
    }

    public boolean isMember() {
        return isMember; // 回傳是否為會員
    }

    public double getTotalSpent() {
        return totalSpent; // 回傳總消費金額
    }

    public void addSpending(double amount) {
        totalSpent += amount; // 增加消費金額
    }

    public double getDiscount() {
        return isMember ? 0.1 : 0; // 會員享有 10% 折扣
    }
}
