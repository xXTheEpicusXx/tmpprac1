import java.util.ArrayList;

public abstract class User {
    private String name;
    private Integer age;
    private Balance balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public abstract void award();
    public abstract void penalty();
}
