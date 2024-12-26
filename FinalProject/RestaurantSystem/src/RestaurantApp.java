public class RestaurantApp {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        // 加入菜單項目
        restaurant.addToMenu(new MainDish("牛排", 25.99, false, 2));
        restaurant.addToMenu(new Dessert("起司蛋糕", 6.99, true, 1));
        restaurant.addToMenu(new Beverage("可樂", 2.99, false, 3));

        // 建立顧客
        Customer alice = new Customer("愛麗絲", true);
        Customer bob = new Customer("鮑伯", false);

        try {
            // 愛麗絲點餐
            restaurant.placeOrder(alice, "牛排");
            restaurant.placeOrder(alice, "可樂");

            // 鮑伯點餐
            restaurant.placeOrder(bob, "起司蛋糕");
            restaurant.placeOrder(bob, "牛排");
        } catch (OutOfStockException | InvalidOrderException e) {
            System.out.println(e.getMessage());
        }

        // 處理訂單並顯示結果
        restaurant.processOrders();

        // 顯示菜單
        restaurant.displayMenu();
    }
}
