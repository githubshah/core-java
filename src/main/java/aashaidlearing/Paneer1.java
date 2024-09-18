package aashaidlearing;

public class Paneer1 implements Pizza1{

    private int price = 20;

    Pizza1 pizza1;

    public Paneer1(Pizza1 obj) {
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
