package Numbers.median_of_two_sorted_arrays;

import sorting_algorithms.mergeSort.mergeSortAlgorithm;

public class MedianOfSortedArrays {

    public double findMedianSortedArrays(int[] firstArray, int[] secondArray) {

        int[] mergedArray = new int[firstArray.length + secondArray.length];

        System.arraycopy(firstArray, 0, mergedArray, 0, firstArray.length);
        System.arraycopy(secondArray, 0, mergedArray, firstArray.length, secondArray.length);

        mergeSortAlgorithm.mergeSort(mergedArray, mergedArray.length);

        double median;

        if (mergedArray.length % 2 > 0) // indicates that we have odd count of elements in array
            median = mergedArray[mergedArray.length/2];
        else
            median = (mergedArray[mergedArray.length/2] + mergedArray[mergedArray.length/2 - 1]) / 2;

        System.out.println(median);

        return median;
    }


}
