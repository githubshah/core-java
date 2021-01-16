package learning.pattern.decorator;// Java program to demonstrate Decorator
// pattern 

// Abstract Pizza class (All classes extend
// from this) 
abstract class Pizza {
    // it is an abstract pizza
    String description = "Unkknown Pizza";

    public String getDescription() {
        return description;
    }

    public abstract int getCost();
}

// The decorator class : It extends Pizza to be
// interchangable with it topings decorator can
// also be implemented as an interface
abstract class ToppingsDecorator extends Pizza {
    public abstract String getDescription();
}

class FarmHouse extends Pizza {
    public FarmHouse() {
        description = " ,FarmHouse(200)";
    }

    public int getCost() {
        System.out.println("calculate FarmHouse pizza " + 200);
        return 200;
    }
}

// Concrete toppings classes
class FreshTomato extends ToppingsDecorator {
    // we need a reference to obj we are decorating
    Pizza pizza;

    public FreshTomato(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getDescription() {
        return " ,Fresh Tomato(40) " + pizza.getDescription();
    }

    public int getCost() {
        int i = 40 + pizza.getCost();
        System.out.println("calculate fresh tomato topping " + i);
        return i;
    }
}

class Barbeque extends ToppingsDecorator {
    Pizza pizza;

    public Barbeque(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getDescription() {
        return pizza.getDescription() + ", Barbeque ";
    }

    public int getCost() {
        return 90 + pizza.getCost();
    }
}

class Paneer extends ToppingsDecorator {
    Pizza pizza;

    public Paneer(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getDescription() {
        return  " ,Paneer(70) " + pizza.getDescription();
    }

    public int getCost() {
        int i = 70 + pizza.getCost();
        System.out.println("calculate panner topping " + i);
        return i;
    }
}

// Other toppings can be coded in a similar way 

// Driver class and method 
class PizzaStore {
    public static void main(String args[]) {
        // create new FarmHouse pizza
        Pizza pizza = new FreshTomato(new Paneer(new FarmHouse()));
        //Pizza pizza = new FreshTomato((new FarmHouse()));
        System.out.println("last topping: " + pizza.getClass());
        System.out.println(pizza.getDescription() + " ,Total Cost :" + pizza.getCost());
    }
} 
