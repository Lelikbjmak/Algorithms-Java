package Strings.Highest_and_Lowest;

import java.util.Arrays;
import java.util.stream.IntStream;

public class highLow {

//    In this little assignment you are given a string of space separated numbers,
//    and have to return the highest and lowest number.
    public static String highAndLow(String numbers) {

        //1st var (with Streams)
//        int min = Arrays.stream(numbers.split(" ")).flatMapToInt(num -> IntStream.of(Integer.parseInt(num))).min().getAsInt();
//        int max = Arrays.stream(numbers.split(" ")).flatMapToInt(num -> IntStream.of(Integer.parseInt(num))).max().getAsInt();
//        return (max) + " " + (min);

        //2nd var
//        var stats = Arrays.stream(numbers.split(" ")).mapToInt(Integer::parseInt).summaryStatistics();
//        String a = stats.getMax() + " " + stats.getMin();

        //3rd var
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//        for (int i=0; i< array.length; i++){
//            int value = Integer.parseInt(array[i]);
//            if (value < min) min = value;
//            if (value > max) max = value;
//        }

        //4nd var
        int[] numerics = Arrays.stream(numbers.split(" "))
                .flatMapToInt(num -> IntStream.of(Integer.parseInt(num)))
                .toArray();

        int first = 0;
        int last = numerics.length - 1;

        quicksort(numerics, first, last);

        return (numerics[last]) + " " + (numerics[first]);
    }

    public static void quicksort(int[] mas, int first, int last)
    {
        int mid;
        int f = first, l = last;

        mid = mas[(f + l) / 2]; //вычисление опорного элемента

        do
        {
            while (mas[f] < mid) f++;
            while (mas[l] > mid) l--;

            if (f <= l) //перестановка элементов
            {
                int num = mas[f];
                mas[f] = mas[l];
                mas[l] = num;
                f++;
                l--;
            }

        } while (f < l);

        if (first < l) quicksort(mas, first, l);
        if (f < last) quicksort(mas, f, last);
    }
}
