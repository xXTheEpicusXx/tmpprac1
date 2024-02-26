public class Balance {
    public int getMoney() {
        return money;
    }

    private int money;

    public Balance(int money) {
        this.money = money;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public void popMoney(int money) {
        this.money -= money;
    }
}
