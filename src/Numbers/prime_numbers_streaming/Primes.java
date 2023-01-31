package Numbers.prime_numbers_streaming;

import java.util.stream.IntStream;

public class Primes {

    public static IntStream stream() {
        return IntStream.iterate(2, Primes::primeAfter);
    }

    private static boolean prime(int n){

        for(int i = 2;i <= Math.sqrt(n); i++)
            if(n % i == 0)
                return false;

        return true;
    }

    private static int primeAfter(int number) {
        if (prime(number + 1)) return number + 1;
        else
            return primeAfter(number + 1);
    }
}
