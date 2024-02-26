public class PoliceMan extends User{

    @Override
    public void award() {
        getBalance().addMoney(10);
    }

    @Override
    public void penalty() {
        System.out.println("You're arrested");
    }
}
