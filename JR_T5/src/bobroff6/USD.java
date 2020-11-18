package bobroff6;

public class USD extends Money{
    @Override
    public String getCurrencyName() {
        return "USD";
    }

    public USD(double amount){
        super(amount);
    }
}
