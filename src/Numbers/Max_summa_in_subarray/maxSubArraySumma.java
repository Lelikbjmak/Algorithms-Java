package Numbers.Max_summa_in_subarray;

import java.util.Arrays;

public class maxSubArraySumma {

//    The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence
//    in an array or list of integers:
//    Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
// should be 6: {4, -1, 2, 1}

    public static int sequence(int[] arr) { //Kadane’s Algorithm (Largest Sum Contiguous Subarray)

        if(arr.length == 0)
            return 0;

        if(Arrays.stream(arr).max().getAsInt() < 0)  // massive contains only negative values
            return 0;


        int max_so_far = Integer.MIN_VALUE,
                max_ending_here = 0;

        for (int j : arr) {

            max_ending_here = max_ending_here + j;  // summa before elem j in massiv(include j)

            if (max_so_far < max_ending_here)    // if summa before that elem was less -> this elem contributes positive summa
                max_so_far = max_ending_here;  // extend this interval

            if (max_ending_here < 0)      // if the whole summa < 0 -> reject this interval start with next
                max_ending_here = 0;

        }
        return max_so_far;
    }


}
