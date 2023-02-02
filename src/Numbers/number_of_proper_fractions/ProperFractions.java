package Numbers.number_of_proper_fractions;

import java.util.ArrayList;
import java.util.List;

public class ProperFractions {

    public static long properFractions(long n) {

        if (n < 2)
            return 0;

        if (n == 2)
            return 1;

        long count = 0;

        //1
//        for (int i = 1; i < n; i++) {
//            if (gcd(n, i) == 1)
//                count++;
//        }

        //2
        for (long i = 1; i < n; i++) {
            count+= isDivided(n, i);
        }

        return n - count;
    }

    private static long gcd(long num, long division) { // find greatest common divisor of 2 nums
        // 6/15 -> 6!=0 -> 3/6 3!=0 -> 0/3 -> greatest is 3
        if (division == 0)
            return num;

        return gcd(division, num % division);
    }

    private static List<Long> allPrimeDivisors(long number){

        // 4 = 2*2, 6 = 3*2, 8 = 4*2, 9 = 3*3 -> distinct divisors = {2,3,5,7}
        List<Long> div = new ArrayList<>();

        if (number % 2 == 0)
            div.add(2L);

        if (number % 3 == 0)
            div.add(3L);

        if (number % 5 == 0)
            div.add(5L);

        if (number % 7 == 0)
            div.add(7L);

        return div;
    }

    private static long isDivided(long number,long divisor){

        long count = 0;
        List<Long> divs = allPrimeDivisors(divisor);

        if (!divs.isEmpty()) {
            for (long v :
                    divs) {
                if (number % v == 0)
                    count++;
            }

            if(!divs.contains(divisor) && number % divisor == 0)
                count++;

        } else if(number % divisor == 0)
            count++;

        return count;
    }
}
