package Algorithms.pyramid_slide_down;

public class LongestSlideDown {

    public static int longestSlideDown(int[][] pyramid) {
        
        // each element of matrix has 2 cases of choice the greater element after current
        //         1
        //        2 3
        //       4 5 6
        //      7 8 9 10
        //        ...
        // element 4 has 2 cases :
        // 4 -> 7 or 4 -> 8, 8 > 7 -> bigger path through element 4 - begin from 8 8->4, each of element in a row has such opportunity:
        // 5 -> 8 or 5-> 9, 9 > 8 -> bigger path through 5 - begin from 9 ...
        // Overall for each element we can count the biggest amount we come with, for element 3: 10 -> 6 -> 3 = 19, do the same for each element

        for (int i = pyramid.length - 2; i >= 0; i--) {
            for (int j = 0; j < pyramid[i].length; j++) {
                pyramid[i][j] = pyramid[i][j] + Math.max(pyramid[i+1][j], pyramid[i+1][j+1]);
            }
        }

        return pyramid[0][0];
    }
}
