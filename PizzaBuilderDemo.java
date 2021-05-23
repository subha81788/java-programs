class Pizza {
 
    private Size size;
    private Topping topping;
    private Crust crust;
    private Cheese cheese;
    private float totalPrice = 0.0f;
 
    public Size getSize() {
        return size;
    }
 
    public void setSize(Size size) {
        this.size = size;
    }
 
    public Topping getTopping() {
        return topping;
    }
 
    public void setTopping(Topping topping) {
        this.topping = topping;
    }
 
    public Crust getCrust() {
        return crust;
    }
 
    public void setCrust(Crust crust) {
        this.crust = crust;
    }
 
    public Cheese getCheese() {
        return cheese;
    }
 
    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }
 
    public float getTotalPrice() {
        return totalPrice;
    }
 
    public void addToPrice(float price) {
        this.totalPrice = totalPrice + price;
    }
}

enum Cheese {
    AMERICAN {
        public float getCost() {
            return 40.0f;
        }
    }, ITALIAN {
        public float getCost() {
            return 60.0f;
        }
    };
 
    public abstract float getCost();
 
}
 
enum Crust {
      THIN  {
        public float getCost(){
            return 70.0f;
        }
    } , STUFFED{
        public float getCost(){
            return 90.0f;
        }
    };
 
    public abstract float getCost();
}
 
enum Size {
    MEDIUM {
        public float getCost() {
            return 100.0f;
        }
    }, LARGE {
        public float getCost() {
            return 160.0f;
        }
    };
 
    public abstract float getCost();
}
 
enum Topping {
    PEPPERONI {
        public float getCost(){
            return 30.0f;
        }
    }, CHICKEN{
        public float getCost(){
            return 35.0f;
        }
    }, MUSHROOM{
        public float getCost(){
            return 20.0f;
        }
    };
 
    public abstract float getCost();
}

class PizzaBuilder {
    private Pizza pizza = new Pizza();
 
    public PizzaBuilder withTopping(Topping topping) {
        pizza.setTopping(topping);
        pizza.addToPrice(topping.getCost());
        return this;
    }
 
    public PizzaBuilder withSize(Size size) {
        pizza.setSize(size);
        pizza.addToPrice(size.getCost());
        return this;
    }
 
    public PizzaBuilder withCrust(Crust crust) {
        pizza.setCrust(crust);
        pizza.addToPrice(crust.getCost());
        return this;
    }
 
    public Pizza build() {
        return pizza;
    }
 
    public double calculatePrice() {
        return pizza.getTotalPrice();
    }
}

public class PizzaBuilderDemo {
 
    public static void main(String[] args) {
        Pizza pizza = new PizzaBuilder()
            .withCrust(Crust.THIN)
            .withTopping(Topping.CHICKEN)
            .withSize(Size.LARGE)
            .build();

        assert pizza.getTopping() == Topping.CHICKEN : "Invalid Pizza toppings found";
        assert pizza.getSize() == Size.LARGE : "Invalid Pizza size found";
        assert pizza.getCrust() == Crust.THIN : "Invalid Pizza crust found";
        assert pizza.getTotalPrice() == 265.0f : "Pizza price is incorrect";
    }
}

