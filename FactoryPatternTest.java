public class FactoryPatternTest {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape circle = factory.getShape("Circle");
        circle.draw();
        Shape square = factory.getShape("Square");
        square.draw();
        Shape rectangle = factory.getShape("Rectangle");
        rectangle.draw();
    }   
}

interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing circle");   
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing square");   
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing rectangle");   
    }
}

class ShapeFactory {
    public Shape getShape(String type) {
        if(type.equalsIgnoreCase("Circle")) {
            return new Circle();
        } else if(type.equalsIgnoreCase("Square")) {
            return new Square();
        } else {
            return new Rectangle();
        }
    }
}
