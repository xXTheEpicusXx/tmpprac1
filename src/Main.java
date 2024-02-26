import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        User user = new PoliceMan();
        User user1 = new SecurityGuard();
        user.setName("Alex");
        user1.setName("Fred");
        user.setBalance(new Balance(12));
        user1.setBalance(new Balance(7));
        user.award();
        user1.award();
        user.penalty();
        user1.penalty();
        System.out.println(user.getBalance().getMoney() + " " + user1.getBalance().getMoney());
    }
}
