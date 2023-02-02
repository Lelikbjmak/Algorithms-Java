## Description

[Kata](https://www.codewars.com/kata/55b7bb74a0256d4467000070/train/java)

If n is the numerator and d the denominator of a fraction, that fraction is defined a (reduced) proper fraction if and only if GCD(n,d)==1.

For example 5/16 is a proper fraction, while 6/16 is not, as both 6 and 16 are divisible by 2, thus the fraction can be reduced to 3/8.

Now, if you consider a given number d, how many proper fractions can be built using d as a denominator?

For example, let's assume that d is 15: you can build a total of 8 different proper fractions between 0 and 1 with it: 1/15, 2/15, 4/15, 7/15, 8/15, 11/15, 13/15 and 14/15.

You are to build a function that computes how many proper fractions you can build with a given denominator:
```js
proper_fractions(1)==0
proper_fractions(2)==1
proper_fractions(5)==4
proper_fractions(15)==8
proper_fractions(25)==20
```

***Be ready to handle big numbers.***

---

## Best practices

***First:***
```js
public static long properFractions(long n) {

    if (n==1) return 0;
    
    long r=n;
    
    for(long d=2;d*d<=n;d++)
      if(n%d<1){
        while(n%d<1)
          n/=d;
        r-=r/d;
      }
      
    if(n>1) r-=r/n;
    return r;
}
```

***Second:***
```js
public static long properFractions(long n) {
    if (n == 1) return 0;
    long c = n;
    List<Long> pfs = primeFactors(n);
    for (long pf : pfs) c -= c / pf;
    return c;
}

private static List<Long> primeFactors(long numbers) {
    long n = numbers;
    List<Long> factors = new ArrayList<>();
    for (long i = 2; i <= n / i; i++)
        while (n % i == 0) {
            factors.add(i);
            n /= i;
        }
    if (n > 1) factors.add(n);
    return factors.stream().distinct().sorted().collect(Collectors.toList());
}
```

---

## My solutions
***First:***
<small>
***(Doesn't pass big values random tests)***
</small>

```js
public static long properFractions(long n) {

    if (n < 2)
        return 0;

    if (n == 2)
        return 1;

    long count = 0;

    for (long i = 1; i < n; i++) {
        count+= isDivided(n, i);
    }

    return n - count;
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
```

***Second:***
<small>
***(Doesn't pass time test):***
</small>
```js
public static long properFractions(long n) {

    if (n < 2)
        return 0;

    if (n == 2)
        return 1;

    long count = 0;

    for (int i = 1; i < n; i++) {
        if (gcd(n, i) == 1)
            count++;
    }

    return count;
}

private static long gcd(long num, long division) { // find greatest common divisor of 2 nums
    // 6/15 -> 6!=0 -> 3/6 3!=0 -> 0/3 -> greatest is 3
    if (division == 0)
        return num;

    return gcd(division, num % division);
}
    
```


