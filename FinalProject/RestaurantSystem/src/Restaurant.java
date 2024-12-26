import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;

public class Restaurant {
    private ArrayList<MenuItem> menu;
    private HashMap<Customer, LinkedList<MenuItem>> customerOrders;

    public Restaurant() {
        menu = new ArrayList<>();
        customerOrders = new HashMap<>();
    }

    public void addToMenu(MenuItem item) {
        menu.add(item);
    }

    public void placeOrder(Customer customer, String foodName) throws OutOfStockException, InvalidOrderException {
        customerOrders.putIfAbsent(customer, new LinkedList<>());

        for (MenuItem item : menu) {
            if (item.getName().equalsIgnoreCase(foodName)) {
                item.reduceStock();
                customerOrders.get(customer).add(item);
                System.out.println(customer.getName() + " 已點餐：" + foodName);
                return;
            }
        }
        throw new InvalidOrderException("菜單中找不到此項目：" + foodName);
    }

    public void processOrders() {
        System.out.println("\n顧客訂單明細：");

        for (Customer customer : customerOrders.keySet()) {
            LinkedList<MenuItem> orders = customerOrders.get(customer);
            double total = 0;

            System.out.println("顧客：" + customer.getName());
            for (MenuItem item : orders) {
                System.out.println("  - " + item.getName() + " - 價格：$" + item.getPrice());
                total += item.getPrice();
            }

            double discount = customer.getDiscount();
            double discountedTotal = total * (1 - discount);
            double discountAmount = total - discountedTotal;

            System.out.printf("  總金額：$%.2f，折扣 (%.0f%%)：-$%.2f，折扣後總金額：$%.2f%n",
                    total, discount * 100, discountAmount, discountedTotal);

            customer.addSpending(discountedTotal);
        }
    }

    public void displayMenu() {
        System.out.println("\n菜單：");
        for (MenuItem item : menu) {
            System.out.printf("  - %s - 價格：$%.2f - %s%n",
                    item.getName(), item.getPrice(), item.isOutOfStock() ? "已售罄" : "有貨");
        }
    }
}
