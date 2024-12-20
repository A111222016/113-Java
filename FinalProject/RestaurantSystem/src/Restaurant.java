import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.HashMap;

public class Restaurant {
    private ArrayList<MenuItem> menu; // 菜單
    private LinkedList<MenuItem> orders; // 訂單隊列
    private HashSet<String> outOfStockItems; // 缺貨項目集合
    private HashMap<String, Customer> customers; // 顧客名單

    public Restaurant() {
        menu = new ArrayList<>();
        orders = new LinkedList<>();
        outOfStockItems = new HashSet<>();
        customers = new HashMap<>();
    }

    // 修改這裡：接收 MenuItem 類型的物件
    public void addToMenu(MenuItem item) {
        menu.add(item); // 添加項目到菜單
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getName(), customer); // 添加顧客
    }

    public Customer getCustomer(String name) {
        return customers.getOrDefault(name, null); // 獲取顧客
    }

    public void placeOrder(String foodName) throws OutOfStockException, InvalidOrderException {
        for (MenuItem item : menu) {
            if (item.getName().equalsIgnoreCase(foodName)) {
                if (outOfStockItems.contains(foodName)) {
                    throw new OutOfStockException(foodName + " 缺貨中。");
                }
                orders.add(item);
                System.out.println("已下單: " + foodName);
                return;
            }
        }
        throw new InvalidOrderException("菜單中找不到項目: " + foodName);
    }

    public void markOutOfStock(String foodName) {
        outOfStockItems.add(foodName); // 標記項目為缺貨
        System.out.println(foodName + " 已標記為缺貨。");
    }

    public void processOrders() {
        while (!orders.isEmpty()) {
            MenuItem order = orders.poll(); // 處理訂單
            System.out.println("正在處理訂單: " + order.getName());
        }
    }
}


