package aashaidlearing;

public class FarmHouse1  implements Pizza1{

    private int price = 100;

    public FarmHouse1() {

    }

    @Override
    public String getDescription() {
        return "FarmHouse1";
    }

    @Override
    public int getCost() {
        return this.price;
    }
}
