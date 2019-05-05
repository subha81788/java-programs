import java.util.List;
import java.util.ArrayList;
import java.util.function.UnaryOperator;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FuncInterfaceTest {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<Apple>() {
            {
                add(new Apple("red",100));
                add(new Apple("yellow",80));
                add(new Apple(120));
            }
        };

        UnaryOperator<Integer> incrOperator = x -> ++x;
        System.out.println("99 increments to " + incrOperator.apply(99));
        BinaryOperator<String> concatOperator = (x,y) -> x+y;
        System.out.println("Hello + World = " + concatOperator.apply("Hello ","World"));
        IntBinaryOperator addOperator = (x,y) -> x+y;
        System.out.println("10+5 = " + addOperator.applyAsInt(10,5));
        BiPredicate<Integer, Integer> greaterPredicate = (x, y) -> x > y;
        System.out.println("2 > 3 = " + greaterPredicate.test(2, 3));
        Predicate<List<Apple>> isAppleListEmptyPredicate = l -> l.isEmpty();
        System.out.println("If Apple list empty: " + isAppleListEmptyPredicate.test(apples));

        Supplier<Apple> appleSupplier1 = () -> new Apple(130);
        Apple apple1 = appleSupplier1.get();
        System.out.println(apple1);
        Supplier<Apple> appleSupplier2 = Apple::new;
        Apple apple2 = appleSupplier2.get();
        Consumer<Apple> appleConsumer1 = System.out::println;
        appleConsumer1.accept(apple2);
        BiConsumer<Apple,String> appleBiConsumer2 = Apple::setColor;
        appleBiConsumer2.accept(apple2,"green");
        Consumer<String> appleConsumer3 = System.out::println;
        appleConsumer3.accept("Red apple has become green");
        Function<Apple,String> appleToColorFunction = Apple::getColor;
        ToIntFunction<Apple> appleToWeightFunction = Apple::getWeight;
        System.out.println("Apple color: " + appleToColorFunction.apply(apple2) + ", weight: " + appleToWeightFunction.applyAsInt(apple2));

    }
}

class Apple {
    String color;
    int weight;

    Apple(String color, int weight) { this.color = color; this.weight = weight; }

    Apple(int weight) { this("red",weight); }

    Apple() { this("red",150); }

    String getColor() { return color; }

    void setColor(String color) { this.color = color; }

    int getWeight() { return weight; }

    void setWeight(int weight) { this.weight = weight; }

    @Override
    public String toString() {
        return "[color = " + color + ", weight = " + weight + "]";
    }
}
