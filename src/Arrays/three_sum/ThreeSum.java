package Arrays.three_sum;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] numbers) {

        if(numbers.length == 0)
            return new ArrayList<>();

        Set<List<Integer>> distinctTriplets = new HashSet<>();

        Arrays.sort(numbers);
        // -1 -2 3 4 5 6 ... -> for each two elements in a raw (like -1 & -2 etc) find value (start from tail of array) equal to current sum -3 = 3 -> triplet = [-1,-2,3]

        for (int i = 0; i < numbers.length - 2; i++) {

            int j = i + 1; // elem after current
            int k = numbers.length - 1; // last elem

            while(j < k){
                int sum = numbers[i] + numbers[j] + numbers[k];

                if(sum==0)
                    distinctTriplets.add(List.of(numbers[i], numbers[j++], numbers[k--]));
                else if (sum >0)
                     k--;
                    else
                        j++;
            }

        }

        return new ArrayList<>(distinctTriplets);
    }
}
