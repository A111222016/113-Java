import java.util.Scanner;

public class SalesDepartment {
    public static void main(String args[]) {
        // 建立業務員資料並放入陣列
        SalesPerson[] salesTeam = new SalesPerson[3];
        SalesPerson sales1 = new SalesPerson("SE111", "周柏睿");
        SalesPerson sales2 = new SalesPerson("SE222", "黃敬宇");
        SalesPerson sales3 = new SalesPerson("SE333", "吳嘉文");
        salesTeam[0] = sales1;
        salesTeam[1] = sales2;
        salesTeam[2] = sales3;
        operation(salesTeam); // 啟動操作選單
    }

    public static void operation(SalesPerson[] salesTeam) {
        SalesPerson targetSales;
        Scanner input = new Scanner(System.in);
        menu(); // 顯示選單

        while (input.hasNext()) {
            int choice = input.nextInt();
            try {
                switch (choice) {
                    case 1: // 設定獎金比例
                        targetSales = selectedSales(salesTeam); // 選擇業務員
                        if (targetSales != null) {
                            System.out.print("請輸入新的獎金比例： ");
                            double rate = input.nextDouble();
                            targetSales.setCommissionRate(rate); // 設定獎金比例
                            System.out.println("獎金比例已更新！");
                        }
                        break;
                    case 2: // 新增訂單
                        targetSales = selectedSales(salesTeam); // 選擇業務員
                        if (targetSales != null) {
                            System.out.print("請輸入產品名稱： ");
                            String itemName = input.next();
                            System.out.print("請輸入產品單價： ");
                            double itemPrice = input.nextDouble();
                            System.out.print("請輸入產品數量： ");
                            int amount = input.nextInt();
                            targetSales.setOrderArray(itemName, itemPrice, amount); // 新增訂單
                            //只顯示新增的訂單
                            System.out.println("新增訂單：");
                            System.out.println("產品名稱:"+itemName + "單價:" + itemPrice + " 數量:" + amount);
                        }
                        break;
                    case 3: // 查詢薪資
                        targetSales = selectedSales(salesTeam); // 選擇業務員
                        if (targetSales != null) {
                            System.out.printf("業務員薪資為：%.1f%n", targetSales.salary()); // 顯示薪資
                        }
                        break;
                    case 4: // 查詢訂單
                        targetSales = selectedSales(salesTeam); // 選擇業務員
                        if (targetSales != null) {
                            System.out.println("訂單內容如下：");
                            System.out.println(targetSales.getOrders()); // 顯示訂單
                        }
                        break;
                    default:
                        System.out.println("輸入錯誤，請重新選擇。");
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.print(ex.getMessage());
                menu();
                continue;
            }
            menu(); // 顯示選單
        }

        // 顯示所有業務員資訊
        for (SalesPerson s : salesTeam) {
            System.out.print(s.toString());
        }
    }

    public static SalesPerson selectedSales(SalesPerson[] salesTeam) {
        Scanner input = new Scanner(System.in);
        System.out.print("請輸入編號： ");
        String salesID = input.next();

        // 從 salesTeam 陣列中搜尋匹配的業務員
        for (SalesPerson sales : salesTeam) {
            if (sales.getId().equals(salesID)) {
                return sales; // 回傳匹配的業務員
            }
        }

        // 若無符合編號的業務員，顯示錯誤訊息並回傳 null
        System.out.println("編號輸入錯誤");
        return null;
    }

    // 顯示操作選單
    public static void menu() {
        System.out.println("\n\nROC股份有限公司：");
        System.out.print("1.設定獎金比例\n2.新增訂單\n3.薪資查詢\n4.訂單查詢\n請輸入： ");
    }
}

