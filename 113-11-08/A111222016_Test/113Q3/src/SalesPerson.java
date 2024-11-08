import com.sun.nio.sctp.AbstractNotificationHandler;

import java.util.ArrayList;

public class SalesPerson {
    private String id; // 業務員編號
    private String name; // 業務員姓名
    private double grossSales; // 總銷售金額
    private double commissionRate; // 獎金比例

    private Order[] orderArray = new Order[3]; // 儲存訂單的陣列，初始大小為3
    private int orderCount = 0; // 訂單數量

    // 建構子，預設 commissionRate 為 0.01
    public SalesPerson(String id, String name) {
        this(id, name, 0.01); // 呼叫另一個建構子，指定獎金比例為 0.01
    }

    // 建構子，允許指定 commissionRate
    public SalesPerson(String id, String name, double commissionRate) {
        this.id = id;
        this.name = name;
        this.commissionRate = commissionRate;
    }

    // 取得業務員編號
    public String getId() {
        return id;
    }

    // 取得業務員姓名
    public String getName() {
        return name;
    }

    // 設定獎金比例
    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    // 新增訂單到 orderArray 中
    public void setOrderArray(String itemName, double itemPrice, int amount) {
        // 如果陣列已滿，則將陣列長度擴展為原來的兩倍
        if (orderCount >= orderArray.length) {
            Order[] newOrderArray = new Order[orderArray.length * 2];
            System.arraycopy(orderArray, 0, newOrderArray, 0, orderArray.length);
            orderArray = newOrderArray;
        }
        // 將新訂單加入到陣列中
        orderArray[orderCount++] = new Order(itemName, itemPrice, amount);
    }

    // 計算並取得總銷售金額
    public double getGrossSales() {
        grossSales = 0; // 初始化總銷售金額
        for (int i = 0; i < orderCount; i++) {
            grossSales += orderArray[i].totalSale(); // 加總每筆訂單的銷售金額
        }
        return grossSales;
    }

    // 將所有訂單的資訊整合為字串並返回
    public String getOrders() {
        StringBuilder orders = new StringBuilder(); // 使用 StringBuilder 整合訂單資訊
        for (int i = 0; i < orderCount; i++) {
            orders.append(orderArray[i].toString()); // 將每筆訂單的資訊加入字串
        }
        return orders.toString();
    }

    // 計算並取得業務員的薪資（總銷售金額 * 獎金比例）
    public double salary() {
        return getGrossSales() * commissionRate; // 薪資等於總銷售金額乘以獎金比例
    }

    // 顯示業務員資訊
    public String toString() {
        return String.format("業務員編號：%s%n業務員姓名：%s%n銷售金額：%.1f%n獎金比例：%.2f%n薪資：%.1f%n",
                this.id, this.name, getGrossSales(), this.commissionRate, salary());
    }
}

