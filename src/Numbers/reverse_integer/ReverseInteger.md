## Description

Reverse given int number 

***Example***
```js
Input: x = 123
Output: 321

Input: x = -123
Output: -321

Input: x = 120
Output: 21
```

--- 

## My solution
* First **(If we want to return derived value)**
```js
public static int reverseIntegerVariableFirstFor(int num){

    if (num < 10)
        return num;

    int reverse = 0;

    for ( ; num != 0; num = num / 10) {
        int lastDigit = num % 10;
        reverse = reverse * 10 + lastDigit;
    }

    return reverse;
}


// the same with while loop
public static int reverseIntegerVariableFirstWhile(int num){

    int reverse = 0;
    
    while(num > 0){  
        int lastDigit = n % 10;
        reverse = reverse * 10 + rem;
        num = num / 10;
    }
    
    return reverse;
}    
```

* Second **(If we need slap bang to print derived value)**
```js
public static void reverseIntegerVariableSecond(int num){

    if (num < 10) {
        System.out.println(num);
        return;
    } else {
        System.out.println(num % 10);
        reverseIntegerVariableSecond(num / 10);
    }
}
```