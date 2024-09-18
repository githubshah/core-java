package aashaidlearing;

class PizzaStore {
    public static void main(String args[]) {
        // create new FarmHouse pizza
        Pizza1 pizza = new FreshTomato1(new Paneer1(new FarmHouse1()));
        //Pizza pizza = new FreshTomato((new FarmHouse()));
        System.out.println("last topping: " + pizza.getClass());
        System.out.println(pizza.getDescription() + " ,Total Cost :" + pizza.getCost());
    }
} 