public class TestLambda {
    public static void main(String[] args) {
        Operation op=(a,b)->{
            int c=10;
            c++;
            System.out.println(++c);
            return (a+b+c);
        };
        System.out.println(op.operate(10,15));
    }
}

interface Operation {
    int x=10;
    int operate(int a, int b);
}

