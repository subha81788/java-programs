import java.math.BigDecimal;
import java.io.IOException;

public class FloatArith {
 
    public static void main(String[] args) {
      
      //floating point calculation
      double amount1 = 2.15;
      double amount2 = 1.10;
      double res = amount1 - amount2;
      System.out.println("difference between 2.15 and 1.0 using double is: " + res);
    
      //Use BigDecimal for financial calculation
      BigDecimal amount3 = new BigDecimal("2.15");
      BigDecimal amount4 = new BigDecimal("1.10") ;
      System.out.println("difference between 2.15 and 1.0 using BigDecimal is: " + (amount3.subtract(amount4)));      
    }     
}
