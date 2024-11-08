import java.util.Scanner;

public class SalesDepartment {
    public static void main(String args[]) {
        // 建立三位 SalesPerson 物件並存入 salesTeam 陣列中
        SalesPerson[] salesTeam = new SalesPerson[3];
        SalesPerson sales1 = new SalesPerson("SE111", "林俊傑");
        SalesPerson sales2 = new SalesPerson("SE222", "張佳豪");
        SalesPerson sales3 = new SalesPerson("SE333", "劉威廷");
        salesTeam[0] = sales1;
        salesTeam[1] = sales2;
        salesTeam[2] = sales3;
        operation(salesTeam); // 執行操作選單
    }

    public static void operation(SalesPerson[] salesTeam) {
        Scanner input = new Scanner(System.in);
        menu(); // 顯示操作選單

        while (input.hasNext()) {
            int choice = input.nextInt(); // 接收用戶選項
            try {
                switch (choice) {
                    case 1: // 設定銷售金額
                        SalesPerson selectedSales1 = selectedSales(salesTeam); // 選取業務員
                        if (selectedSales1 != null) {
                            System.out.print("請輸入銷售金額： ");
                            double grossSales = input.nextDouble();
                            selectedSales1.setGrossSales(grossSales); // 設定銷售金額
                        }
                        break;

                    case 2: // 設定獎金比例
                        SalesPerson selectedSales2 = selectedSales(salesTeam); // 選取業務員
                        if (selectedSales2 != null) {
                            System.out.print("請輸入獎金比例 ： ");
                            double commissionRate = input.nextDouble();
                            selectedSales2.setCommissionRate(commissionRate); // 設定獎金比例
                        }
                        break;

                    case 3: // 查詢薪資
                        SalesPerson selectedSales3 = selectedSales(salesTeam); // 選取業務員
                        if (selectedSales3 != null) {
                            System.out.printf("薪資： %.1f%n", selectedSales3.salary()); // 顯示薪資
                        }
                        break;

                    default:
                        System.out.println("無效選項，請重試。"); // 錯誤選項提示
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage()); // 顯示例外訊息
            }
            menu(); // 顯示操作選單
        }

        // 顯示所有業務員的詳細資料
        for (SalesPerson s : salesTeam)
            System.out.print(s.toString());
    }

    public static SalesPerson selectedSales(SalesPerson[] salesTeam) {
        Scanner input = new Scanner(System.in);
        System.out.print("請輸入編號： ");
        String salesID = input.next();

        // 在 salesTeam 陣列中搜尋符合輸入編號的 SalesPerson
        for (SalesPerson s : salesTeam) {
            if (s.getId().equals(salesID)) {
                return s; // 找到匹配的業務員並回傳
            }
        }

        System.out.println("編號輸入錯誤"); // 若找不到，顯示錯誤訊息
        return null; // 回傳 null 表示未找到
    }

    public static void menu() {
        System.out.println("\n\nROC股份有限公司：");
        System.out.print("1.設定銷售金額\n2.設定獎金比例\n3.薪資查詢\n請輸入： ");
    }
}

