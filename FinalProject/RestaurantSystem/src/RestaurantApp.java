// 主程式入口
public class RestaurantApp {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        // 添加菜單項目
        restaurant.addToMenu(new MainDish("牛排", 25.99, false));
        restaurant.addToMenu(new Dessert("起司蛋糕", 6.99, true));
        restaurant.addToMenu(new Beverage("可樂", 2.99, false));

        // 添加顧客
        Customer alice = new Customer("Alice", true);
        restaurant.addCustomer(alice);

        // 嘗試點餐
        try {
            restaurant.placeOrder("牛排");
            restaurant.placeOrder("可樂");
            restaurant.markOutOfStock("起司蛋糕");
            restaurant.placeOrder("起司蛋糕");
        } catch (OutOfStockException | InvalidOrderException e) {
            System.out.println(e.getMessage());
        }

        // 處理訂單
        System.out.println("\n正在處理訂單...");
        restaurant.processOrders();
    }
}