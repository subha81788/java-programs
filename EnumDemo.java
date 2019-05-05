enum TrafficLight {
   RED(30), AMBER(10), GREEN(30);  // Named constants
   
   private final int seconds;      // Private variable
   
   TrafficLight(int seconds) {     // Constructor
      this.seconds = seconds;
   }
   
   int getSeconds() {              // Getter
      return seconds;
   }
}
 
public class EnumDemo {
   public static void main(String[] args) {
      for (TrafficLight light : TrafficLight.values()) {
         System.out.printf("%s: %d seconds\n", light, light.getSeconds());
      }
   }
}
