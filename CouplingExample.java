package org.subhashis;

import java.util.List;

public class CouplingExample {
    public static void main(String[] args) {
        System.out.println("Example of coupling");
    }
}

class Item {
    private double price;
    private int quantity;
    public double price() { return price * quantity; }
}

class ShoppingCart {
    private List<Item> items;
    public double getCartPrice() {
        return items.stream().mapToDouble(Item::price).sum();
    }
}
class Order {
    private ShoppingCart cart;
    private double salesTax;

    // Loosely coupled method with very less dependencies
    public double orderTotalPrice() {
        return cart.getCartPrice() + cart.getCartPrice() * salesTax;
    }
}

class HighlyCoupledOrder {
    private ShoppingCart cart;
    private double salesTax;
    public HighlyCoupledOrder(ShoppingCart cart, double salesTax) {
        this.cart = cart;
        this.salesTax = salesTax;
    }
    // This method know the internal details of ShoppingCartEntry and
    // ShoppingCart classes. If there is any change in any of those
    // classes, this method also needs to change.
    public double orderTotalPrice() {
        double cartTotalPrice = 0;
        for (int i = 0; i < cart.items.size(); i++) {
            cartTotalPrice += cart.items.get(i).price
                    * cart.items.get(i).quantity;
        }
        cartTotalPrice += cartTotalPrice * salesTax;
        return cartTotalPrice;
    }

    class Item {
        public double price;
        public int quantity;
    }

    class ShoppingCart {
        public List<Item> items;
    }
}
