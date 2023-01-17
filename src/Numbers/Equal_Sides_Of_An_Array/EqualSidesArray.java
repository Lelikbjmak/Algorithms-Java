package Numbers.Equal_Sides_Of_An_Array;

public class EqualSidesArray {

    public static int findEvenIndex(int[] arr) {
        // your code
        int summa = 0;

        for (int i = 0; i < arr.length; i++) {

            summa+=arr[i];
            int temp = 0;

            for (int j = i ; j < arr.length; j++)
                temp+=arr[j];

            if(summa == temp) {
                return i;
            }

        }

        return -1;

    }

}
