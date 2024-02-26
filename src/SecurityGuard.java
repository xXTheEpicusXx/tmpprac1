public class SecurityGuard extends User{
    @Override
    public void award() {
        System.out.println("Nice work!");
    }

    @Override
    public void penalty() {
        getBalance().popMoney(10);
        if (getBalance().getMoney() < 0) {
            System.out.println("Dismissed");
        }
    }
}
