import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class text {

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

   
    public static List<Integer> rearrangeArray(List<Integer> arr) {
        List<Integer> primes = new ArrayList<>();
        List<Integer> nonPrimes = new ArrayList<>();

      
        for (int x : arr) {
            if (isPrime(x)) {
                primes.add(x);
            } else {
                nonPrimes.add(x);
            }
        }

        if (primes.isEmpty()) {
           
            Collections.sort(arr, Collections.reverseOrder());
            return arr;
        }

        int largestPrime = Collections.max(primes);
        int smallestPrime = Collections.min(primes);

        
        primes.remove((Integer) smallestPrime);
        nonPrimes.addAll(primes);
        Collections.sort(nonPrimes, Collections.reverseOrder());

        List<Integer> result = new ArrayList<>();
        result.add(largestPrime);
        result.addAll(nonPrimes);
        result.add(smallestPrime);

        return result;
    }

    public static void main(String[] args) {
        List<Integer> example1 = List.of(5, 1, 8, 11, 2);
        List<Integer> example2 = List.of(1, 6, 4, 13, 9, 3);

        System.out.println(rearrangeArray(new ArrayList<>(example1))); 
        System.out.println(rearrangeArray(new ArrayList<>(example2)));  
    }
}
