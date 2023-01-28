## Description

Implement a function that receives two IPv4 addresses, and returns the number of addresses between them (including the first one, excluding the last one).

All inputs will be valid IPv4 addresses in the form of strings. The last address will always be greater than the first one.


#### Examples
* With input "10.0.0.0", "10.0.0.50"  => return   50
* With input "10.0.0.0", "10.0.1.0"   => return  256
* With input "20.0.0.10", "20.0.1.0"  => return  246

**Kata's link:** [Count  Ip Addresses](https://www.codewars.com/kata/526989a41034285187000de4/train/java)

---

## Solutions

### Best practices
* ***First***
```js
public static long ipsBetween(String start, String end) {
		return convertToLong(end) - convertToLong(start);
	}
  
  private static long convertToLong(String ip) {
    long res = 0;
    for (String s : ip.split("[.]") )
      res = res * 256 + Long.parseLong(s);
    return res;
  }
```

* ***Second***
```js
public static long ipsBetween(String start, String end) {
    long[] o = Arrays.stream(start.split("\\.")).mapToLong(Long::parseLong).toArray();
    long[] t = Arrays.stream(end.split("\\.")).mapToLong(Long::parseLong).toArray();

    long diff = 0;
    for (int i = 0; i < 4; i++) {
        diff += (t[i] - o[i]) << (8 * (3-i));
    }
    return diff;
}
```

### My solution

```js
public class CountIpAddresses {

    private static final long ipConst = 256;

    public static long ipsBetween(String start, String end) {
        // 77.88.21.8 = 77 * 256^3 + 88 * 256^2 + ...
        return convertIpAddressToLongValue(end) - convertIpAddressToLongValue(start);
    }

    private static long convertIpAddressToLongValue(String ip){

        String[] ips = ip.split("\\.");

        long longIpAddress = 0;

        for (int i = 0; i < 4; i++)  // from end to start 77.88.21.8  8 -> 77
            longIpAddress += Long.parseLong(ips[i]) * Math.pow(ipConst, 4 - 1 -i);

        return longIpAddress;
    }

}
```

