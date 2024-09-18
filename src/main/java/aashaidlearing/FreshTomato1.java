package aashaidlearing;

public class FreshTomato1 implements Pizza1{

    private int price = 10;

    Pizza1 pizza1;

    public FreshTomato1(Pizza1 obj) {
        this.pizza1 = obj;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public int getCost() {
        return pizza1.getCost() + this.price;
    }
}
