import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.Comparator;

class Dish {
    private String name;
    private boolean vegetarian;
    private int calories;
    private Type type;

    enum Type { MEAT, FISH, EGG, OTHER }

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() { return name; }
    public boolean isVegetarian() { return vegetarian; }
    public int getCalories() { return calories; }
    public Type getType() { return type; }
    @Override
    public String toString() { return name; }
}

public class FuncInterfaceDemo {
    public static final int HEALTHY_CALORIES = 300;
    public static final int MAX_CALORIES = 700;

    public static void main(String[] args) {
        List<Dish> menu = getMenu();

        System.out.println("If any non-veg dish available: " + isAnyNonVegDish(menu));

        System.out.println("\nIf any egg dish available: " + isAnyEggDish(menu));

        System.out.println("\nAny healthy dish available: " + isAnyHealthyDishPresent(menu));

        List<String> nonVegDishNames = getNonVegDishNames(menu);
        System.out.println("\nNon-veg dishes are:"); nonVegDishNames.forEach(System.out::println);

        System.out.println("\nVeg dishes are: " + getVegDishNames(menu)); 

        System.out.println("\nNumber of meat dishes available: " + countMeatDishes(menu));

        List<Dish> fishDishes = getFishDishes(menu);
        System.out.println("\nFish dishes are:"); fishDishes.forEach(System.out::println);

        List<Dish> firstTwoMeatDishes = getFirstTwoMeatDishes(menu);
        System.out.println("\nFirst two meat dishes are:"); firstTwoMeatDishes.forEach(System.out::println);

        List<Dish> nonVegDishesSortedByCalories = getNonVegDishesSortedByCalories(menu);
        System.out.println("\nNon veg dishes sorted by calories in ascending order:"); nonVegDishesSortedByCalories.forEach(System.out::println);

        sortDishesByNames(menu);
        System.out.println("\nDishes sorted by names in alphabetical order:"); menu.forEach(System.out::println);

        sortDishesByCaloriesDescending(menu);
        System.out.println("\nDishes sorted by calories in decreasing order:"); menu.forEach(System.out::println);

        List<Dish> dishesSortedByCaloriesAndNames = getDishesSortedByCaloriesAndNames(menu); 
        System.out.println("\nDishes sorted by calories and then alphabetically:"); dishesSortedByCaloriesAndNames.forEach(System.out::println);

        System.out.println("\nHighest calorific value of a dish: " + getHighestCalorie(menu));

        System.out.println("\nDish with lowest calorific value: " + getLowestCalorieDish(menu));

        System.out.println("\nSum of calorific values of all the dishes: " + getSumDishCalories(menu));

        System.out.println("\nShow dishes group by dish type:\n" + groupDishesByType(menu));
    }

    public static List<Dish> getMenu() {
        return new ArrayList<Dish>() {
            {
                add(new Dish("Hilsa", false, 450, Dish.Type.FISH));
                add(new Dish("Mutton", false, 700, Dish.Type.MEAT));
                add(new Dish("Pork", false, 700, Dish.Type.MEAT));
                add(new Dish("Chicken", false, 400, Dish.Type.MEAT));
                add(new Dish("French fries", false, 530, Dish.Type.OTHER));
                add(new Dish("Rice", false, 300, Dish.Type.OTHER));
                add(new Dish("Season fruit", true, 120, Dish.Type.OTHER));
                add(new Dish("Pizza", true, 550, Dish.Type.OTHER));
                add(new Dish("Prawns", false, 350, Dish.Type.FISH));
                add(new Dish("Egg", false, 350, Dish.Type.OTHER));
                add(new Dish("Beef", false, 800, Dish.Type.MEAT));
            }
        };
    }

    public static boolean isAnyNonVegDish(List<Dish> menu) {
        Predicate<Dish> isVegDishPredicate = Dish::isVegetarian;
        Predicate<Dish> isNonVegDishPredicate = isVegDishPredicate.negate();
        return menu.stream().anyMatch(isNonVegDishPredicate);
    }

    public static boolean isAnyEggDish(List<Dish> menu) {
        Predicate<Dish> isVegDishPredicate = Dish::isVegetarian;
        Predicate<Dish> notMeatDishPredicate = d -> d.getType() != Dish.Type.MEAT;
        Predicate<Dish> notFishDishPredicate = d -> d.getType() != Dish.Type.FISH;
        Predicate<Dish> isEggDishPredicate = isVegDishPredicate.negate().and(notMeatDishPredicate).and(notFishDishPredicate);
        return menu.stream().anyMatch(isEggDishPredicate);
    }

    public static boolean isAllVegDish(List<Dish> menu) {
        Predicate<Dish> isVegDishPredicate = Dish::isVegetarian;
        return menu.stream().allMatch(isVegDishPredicate);
    }

    public static List<String> getNonVegDishNames(List<Dish> menu) {
        Predicate<Dish> isNonVegDishPredicate = d -> d.isVegetarian() == false;
        Function<Dish,String> dishToNameFunction = Dish::getName;
        return menu.stream().filter(isNonVegDishPredicate).map(dishToNameFunction).collect(Collectors.toList());
    }

    public static String getVegDishNames(List<Dish> menu) {
        return menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
    }

    public static List<Dish> getFishDishes(List<Dish> menu) {
        Predicate<Dish> isFishDishPredicate = d -> d.getType() == Dish.Type.FISH;
        return menu.stream().filter(isFishDishPredicate).collect(Collectors.toList());
    }

    public static List<Dish> getFirstTwoMeatDishes(List<Dish> menu) {
        return menu.stream().filter(d -> d.getType() == Dish.Type.MEAT).limit(2).collect(Collectors.toList());
    }

    public static int countMeatDishes(List<Dish> menu) {
        return (int) menu.stream().filter(d -> d.getType() == Dish.Type.MEAT).count();
    }

    public static void sortDishesByNames(List<Dish> menu) {
        //menu.sort(Comparator.comparing(Dish::getName));
        Comparator<Dish> nameComparator = (d1, d2) -> d1.getName().compareTo(d2.getName());
        menu.sort(nameComparator); // sort() works on the actual list and returns void
    }

    public static void sortDishesByCaloriesDescending(List<Dish> menu) {
        menu.sort(Comparator.comparing(Dish::getCalories).reversed());
    }

    public static List<Dish> getDishesSortedByCaloriesAndNames(List<Dish> menu) {
        Comparator<Dish> dishesSortedByCaloriesAndNamesComp = Comparator.comparing(Dish::getCalories).thenComparing(Dish::getName);
        return menu.stream().sorted(dishesSortedByCaloriesAndNamesComp).collect(Collectors.toList());
    }

    public static List<Dish> getNonVegDishesSortedByCalories(List<Dish> menu) {
        ToIntFunction<Dish> dishToCaloriesFunction = Dish::getCalories;
        return menu.stream().filter(d -> !d.isVegetarian()).sorted(Comparator.comparingInt(dishToCaloriesFunction)).collect(Collectors.toList());
    }

    public static int getHighestCalorie(List<Dish> menu) {
        OptionalInt highestCalories = menu.stream().mapToInt(Dish::getCalories).distinct().max();
        return highestCalories.orElse(0);
    }

    public static Dish getLowestCalorieDish(List<Dish> menu) {
        //Comparator<Dish> calorieComparator = (d1,d2) -> d1.getCalories() - d2.getCalories();
        //Optional<Dish> lowestCaloriesDish = menu.stream().min(calorieComparator);
        Optional<Dish> lowestCaloriesDish = menu.stream().min(Comparator.comparingInt(Dish::getCalories));
        return lowestCaloriesDish.get();
    }

    public static int getSumDishCalories(List<Dish> menu) {
        return menu.stream().mapToInt(Dish::getCalories).sum();
    }

    public static boolean isAnyHealthyDishPresent(List<Dish> menu) {
        Optional<Dish> healthDish = menu.stream().filter(d -> d.getCalories() < HEALTHY_CALORIES).findAny();
        return healthDish.isPresent();
    }

    public static void printAnyHighCalorieDishName(List<Dish> menu) {
        menu.stream().filter(d -> d.getCalories() > MAX_CALORIES).findAny().ifPresent(System.out::print);
    }

    public static String getFirstEggDish(List<Dish> menu) {
        Optional<String> firstEggDish = menu.stream().filter(d -> d.getType() == Dish.Type.FISH).map(Dish::getName).findFirst();
        return firstEggDish.orElse(null);
    }

    public static Map<Dish.Type, List<Dish>> groupDishesByType(List<Dish> menu) {
        return menu.stream().collect(Collectors.groupingBy(Dish::getType));
    }
}
