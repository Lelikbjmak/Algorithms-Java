## Description

[KATA](https://www.codewars.com/kata/5519a584a73e70fa570005f5/train/java)

Create an endless stream of prime numbers - a bit like IntStream.of(2, 3, 5, 7, 11, 13, 17), but infinite. The stream must be able to produce a million primes in a few seconds.

---

## Best Practices
```js
public static IntStream stream() {
    return IntStream.rangeClosed(2, Integer.MAX_VALUE).filter(Primes::isPrime);
}

public static boolean isPrime(int number) {
for (int i = 2; i < (int) Math.sqrt(number) + 1; i++)
if (number % i == 0) return false;

    return true;
}
```
---

## My solution 

***First:***
```js
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
```

***Second (out of time limit but correct):***
```js
public static IntStream stream() {
    return IntStream.iterate(2, n -> n + 1).filter(Primes::prime);
}

private static boolean prime(int n){

    for(int i = 2;i <= Math.sqrt(n); i++)
        if(n % i == 0)
            return false;

    return true;
}
```
