public class SalesPerson {
    private String id;
    private String name;
    private double grossSales;
    private double commissionRate;

    public SalesPerson(String id, String name) {
        this(id, name, 0, 0.01);
        // 呼叫下一個建構子，初始化 grossSales 和 commissionRate 為 0
    }

    public SalesPerson(String id, String name, double grossSales, double commissionRate) {
        this.id = id;
        this.name = name;
        setGrossSales(grossSales);         // 使用 setter 檢查並設置 grossSales
        setCommissionRate(commissionRate); // 使用 setter 檢查並設置 commissionRate
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setGrossSales(double grossSales) {
        // 檢查銷售金額必須為正數
        if (grossSales < 0) {
            throw new IllegalArgumentException("銷售金額必須為正數");
        }
        this.grossSales = grossSales;
    }

    public void setCommissionRate(double commissionRate) {
        // 檢查獎金比例必須在 0 到 1 之間
        if (commissionRate < 0 || commissionRate > 1) {
            throw new IllegalArgumentException("獎金比例必須在 0 到 1 之間");
        }
        this.commissionRate = commissionRate;
    }

    public double salary() {
        return this.grossSales * this.commissionRate;
        // 薪資為銷售額乘上分紅比
    }

    public String toString() {
        return String.format("業務員編號：%s%n業務員姓名：%s%n銷售金額：%.1f%n獎金比例：%.2f%n薪資：%.1f%n",
                this.id, this.name, this.grossSales, this.commissionRate, salary());
    }
}

