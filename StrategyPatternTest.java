import java.util.Map;
import java.util.HashMap;

interface Bike {
    public int getTopSpeed();
}

class FZS implements Bike {
    @Override
    public int getTopSpeed() {
        return 140;
    }
}


class R15 implements Bike {
    @Override
    public int getTopSpeed() {
        return 150;
    }
}

public class StrategyPatternTest {
    private static Map<String,Bike> bikes;

    static {
        bikes=new HashMap<>();
        bikes.put("fzs",new FZS());
        bikes.put("r15",new R15());
    }

    public static Bike getBike(String model) {
        return bikes.get(model);
    }

    public static void main(String[] args) {

        FZS myFZS=(FZS)getBike("fzs");
        System.out.println("Top speed of FZS = " + myFZS.getTopSpeed());


    }
}
