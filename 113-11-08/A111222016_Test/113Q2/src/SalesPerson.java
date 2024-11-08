public class SalesPerson {
    private String id;
    private String name;
    private double grossSales;
    private double commissionRate;

    public SalesPerson(String id, String name) {
        //需修改
        // 檢查 ID 和名稱是否為空或 null
        if (id == null || id.isEmpty() || name == null || name.isEmpty()) {
            throw new IllegalArgumentException("ID 和名稱不可為空");
        }
        this.id = id; // 初始化業務員 ID
        this.name = name; // 初始化業務員名稱
        this.grossSales = 0.0; // 初始銷售金額設為 0
        this.commissionRate = 0.0; // 初始獎金比例設為 0
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
        return String.format("業務員編號：%s%n業務員姓名：%s%n銷售金額：%.1f%n獎金比例：%.1f%n薪資：%.1f%n",
                this.id, this.name, this.grossSales, this.commissionRate, salary() );
    }
}
