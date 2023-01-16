package Numbers.Multiples_of_3_or_5;

public class Solution {

    Solution() {

    }

    public int solution(int number) {
        int sum = 0;

        if (number < 0)
            return 0;

        for (int i = 1; i < number; i++) {
            if (i % 15 == 0) {
                sum += i;
            } else {
                if (i % 3 == 0 || i % 5 == 0)
                    sum += i;
            }
        }
        return sum;
    }

    public int solution2(int number){
        int sum=0;

        for (int i=0; i < number; i++){
            if (i%3==0 || i%5==0){sum+=i;}
        }
        return sum;
    }

}

