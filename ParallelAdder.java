import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

class CallableAdder implements Callable<Integer> {
       Integer operand1;
       Integer operand2;
       CallableAdder(Integer operand1,Integer operand2) {
             this.operand1=operand1;
             this.operand2=operand2;             
       }          
       public Integer call() throws Exception {
           System.out.println(Thread.currentThread().getName()+" says : partial Sum for " +
                   operand1 + " and "+ operand2+ " is "  +(operand1+operand2));
           return operand1+operand2;
       }
}

public class ParallelAdder {                     
    public Integer parallelSum() {                       
        long t1 = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List <Future<Integer>> list = new ArrayList<Future<Integer>>();
        int count=1;
        int prev=0;                       
        for(int i=1; i < 100; i++) {
            if(count%2==0) { //grouping
                Future<Integer> future = executor.submit(new CallableAdder(prev,i));
                list.add(future);
                count=1;                                              
                continue;
            }
            prev=i ;
            count++;                                   
        }
        int totsum=0;                        
        for(Future<Integer> fut : list)
        {
            try {
                totsum = totsum + fut.get();
            } catch (InterruptedException e) {                                               
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }                       
        System.out.println("Total Sum is " + totsum);
        long t2 = System.currentTimeMillis();
        System.out.println("Time taken by parallelSum " + (t2-t1));
        executor.shutdown();
        return totsum;                       
    }                     

    public int sequentialSum()
    {                      
        long t1 = System.currentTimeMillis();
        Integer totsum=0;                        
        for(int i=0;i<100;i++)
        {
            totsum=totsum+i;                                               
        }                       
        long t2 = System.currentTimeMillis();                       
        System.out.println("sequentialSum Total Sum is " + totsum);
        System.out.println("Time taken by sequentialSum " + (t2-t1));
        return totsum;
    }           

    public static void main(String[] args) {                       
        ParallelAdder adder = new ParallelAdder();
        int pSum= adder.parallelSum();
        int sSum= adder.sequentialSum();                       
        System.out.println("parallel Sum equals to Sequential Sum ? " );
        System.out.println("Answer is :: " + (pSum==sSum));                                                                                          
    }
}

