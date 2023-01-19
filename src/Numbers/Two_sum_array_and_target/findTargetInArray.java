package Numbers.Two_sum_array_and_target;

public class findTargetInArray {

//    Write a function that takes an array of numbers (integers for the tests) and a target number.
//    It should find two different items in the array that, when added together, give the target value.
//    The indices of these items should then be returned in a tuple / list (depending on your language)
//    like so: (index1, index2).
//    two_sum([1, 2, 3], 4) == {0, 2}

    public static int[] twoSum(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {

            int temp = target - numbers[i];

            for (int j = i+1; j < numbers.length; j++) {
                if(numbers[j] == temp)
                    return new int[]{i, j};
            }

        }

        return null; // Do your magic!

    }

}
