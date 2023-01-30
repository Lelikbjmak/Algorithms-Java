package Strings.rangeextraction;

public class RangeExtraction {

    public static String rangeExtraction(int[] arr) {

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < arr.length - 1; ) {

            int tempIndex = i;

            builder.append(arr[i]);
            while (i != arr.length - 1 && arr[i + 1] - arr[i] == 1)
                i++;

            if (i - tempIndex > 1) {  // indicates that we have a 3 serial number in a raw
                builder.append("-");
                builder.append(arr[i]);
            } else
                if(i - tempIndex > 0) // == 1
                    i--;

            i++;
            builder.append(',');
        }

        return builder.deleteCharAt(builder.length() - 1).toString();
    }

}
