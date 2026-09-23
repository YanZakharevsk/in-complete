import java.math.BigDecimal;
import java.math.RoundingMode;

class Solution {
    public double myPow(double x, int n) {
        return calculatePow(x, (long) n);
    }

    public double calculatePow(double x, long n){
        if(n == 0) return 1;

        if(n < 0) return 1 / calculatePow(x, -n);

        if(n % 2 == 0) return calculatePow(x * x, n/2);
        else return x * calculatePow(x * x, (n - 1)/2);
    }
}