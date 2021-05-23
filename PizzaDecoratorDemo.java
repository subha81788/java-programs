/*
 * The Decorator design pattern is a structural pattern, which provides a wrapper to the existing class.
 * Decorator patterns allow a user to add new functionality to an existing object without altering its structure.
 * So, there is no change to the original class.
 * Decorator design pattern uses abstract classes or interfaces with the composition to implement the wrapper.
 * Decorator design patterns create decorator classes, which wrap the original class and provide additional
 * functionality by keeping the class methods' signature unchanged.
 * Decorator design patterns are most often used for applying single responsibility principles since we divide the
 * functionality into classes with unique areas of concern.
 * The decorator design pattern is structurally similar to the chain of responsibility pattern.
*/

interface Pizza {
    public String bakePizza();
    public float getPrice();
}

// Base Pizza implementation
class BasePizza implements Pizza {
 
    @Override
    public String bakePizza() {
        return "Basic Pizza";
    }
    @Override
    public float getPrice(){
        return 100;
    }
}

// The decorator class:  It extends Pizza to be interchangable with it
// and also wraps a Pizza instance
abstract class PizzaDecorator implements Pizza {

    protected Pizza decoratedPizza;

    public PizzaDecorator(Pizza decoratedPizza) {
        this.decoratedPizza = decoratedPizza;
    }
}

class ChickenDecorator extends PizzaDecorator {
 
    public ChickenDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }
 
    @Override
    public String bakePizza() {
        return decoratedPizza.bakePizza() + " with Chicken Toppings";
    }
 
    @Override
    public float getPrice() {
        return decoratedPizza.getPrice() + 120;
    }
}

class MushroomDecorator extends PizzaDecorator {
 
    public MushroomDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }
 
    @Override
    public String bakePizza() {
        return decoratedPizza.bakePizza() + " with Mashroom Toppings";
    }
 
    @Override
    public float getPrice() {
        return decoratedPizza.getPrice() + 80;
    }
}

class PaneerDecorator extends PizzaDecorator {

    public PaneerDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }
 
    @Override
    public String bakePizza() {
        return decoratedPizza.bakePizza() + " with Paneer Toppings";
    }
 
    @Override
    public float getPrice() {
        return decoratedPizza.getPrice() + 60;
    }
}

public class PizzaDecoratorDemo {
    public static void main(String[] args) {
        Pizza pizza = new ChickenDecorator(new BasePizza());
        assert pizza.bakePizza().equalsIgnoreCase("Basic Pizza with Chicken Toppings") : "Pizza baked with invalid toppings";
        assert pizza.getPrice() == 220.0 : "Pizza with Chicken toppings price is incorrect";
    }
}
