package Easy;

public class Fibonacci_Number {
    public int fib(int n) {
        if(n == 0 || n == 1) return n;
        int a = 0;
        int b = 1;
        int sum = -1;
        for(int i = 2 ; i <= n; ++i){
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        Fibonacci_Number fibonacci_number = new Fibonacci_Number();
        System.out.println(fibonacci_number.fib(4));
    }
}
