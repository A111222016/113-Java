// 定義菜單項目的介面
public interface MenuItem {
    String getName(); // 獲取菜單項目名稱
    double getPrice(); // 獲取菜單項目價格
    String getCategory(); // 獲取菜單項目類別
    boolean isVegetarian(); // 判斷菜單項目是否為素食
}
