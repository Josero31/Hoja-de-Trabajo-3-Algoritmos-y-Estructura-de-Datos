package AlgortimosSorteo.src;

import java.util.Arrays;

public class Radix_Sort {
    // Radix Sort
     public static void radixsort(int[] array, int n) {
        int m = Arrays.stream(array).max().getAsInt();
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(array, n, exp);
    }

    public static void countSort(int[] array, int n, int exp) {
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);
        for (int i = 0; i < n; i++)
            count[(array[i] / exp) % 10]++;
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }
        for (int i = 0; i < n; i++)
            array[i] = output[i];
    }
}
