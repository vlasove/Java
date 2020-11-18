package bobroff6;

public class Hryvnia extends Money{
    @Override
    public String getCurrencyName() {
        return "UAH";
    }

    public Hryvnia(double amount){
        super(amount);
    }
}
