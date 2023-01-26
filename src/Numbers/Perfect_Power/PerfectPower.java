package Numbers.Perfect_Power;

public class PerfectPower {
    public static int[] isPerfectPower(int n) {

//        n = x^y -> log(n) = y * log(x) -> y = log(n)/log(x)
//        int[] numbers = {1,2,3,4,5,6,7,8,9};

        double logN = Math.log(n);

        for (int i = 2; i * i <= n; i++) {

            double val = logN / Math.log(i);

                if(val - Math.round(val) < 0.000001)   // 1.449 -> 1 -> 1.449 - 1 < 0.5 ALWAYS -> use 0.5
                    if (Math.pow(i, Math.round(val)) == n)
                        return new int[]{i, Math.toIntExact(Math.round(val))};
        }


        //2nd varient
//        for (int i = 2; ; i++) {
//            int root = (int) Math.round(Math.pow(n, 1.0 / i));
//            if (root < 2) return null;
//            if (Math.pow(root, i) == n) return new int[]{root, i};
//        }

        return null;

    }
}
