abstract class OrderProcessTemplate { 

    // Template method defining some algo must be final
    public final void processOrder(boolean shouldWrapGift) { 
        doSelect(); 
        doPayment(); 
        if(shouldWrapGift) { 
            giftWrap(); 
        } 
        doDelivery(); 
    } 

    // primitive operations implementation depends on subclass
    public abstract void doSelect(); 
    public abstract void doPayment(); 
    public final void giftWrap() { System.out.println("Gift wrap successfull"); } 
    public abstract void doDelivery(); 
} 
  
class OnlineOrder extends OrderProcessTemplate { 
    @Override
    public void doSelect() { 
        System.out.println("Items added to online shopping cart"); 
        System.out.println("Get gift wrap preference"); 
        System.out.println("Get delivery address."); 
    } 
  
    @Override
    public void doPayment() { System.out.println ("Online Payment through Netbanking, Card or Google Pay"); } 
  
    @Override
    public void doDelivery() { System.out.println ("Ship the items through post to delivery address"); } 
} 
  
class StoreOrder extends OrderProcessTemplate { 
  
    @Override
    public void doSelect() { System.out.println("Customer chooses the items from shelf."); } 
  
    @Override
    public void doPayment() { System.out.println("Pays at counter through cash/POS"); } 
  
    @Override
    public void doDelivery() { System.out.println("Item deliverd to in delivery counter."); } 
} 
  
class TemplateMethodPatternDemo { 
    public static void main(String[] args) { 
        OrderProcessTemplate netOrder = new OnlineOrder(); 
        netOrder.processOrder(false); 
        System.out.println(); 
        OrderProcessTemplate storeOrder = new StoreOrder(); 
        storeOrder.processOrder(true); 
    } 
} 
