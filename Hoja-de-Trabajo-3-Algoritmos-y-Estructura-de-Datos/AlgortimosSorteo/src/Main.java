package AlgortimosSorteo.src;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;



public class Main {
    public static void main(String[] args) {
        String fileName = "AlgortimosSorteo/src/numeros.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            int[] data = stream.mapToInt(Integer::parseInt).toArray();

            int[] dataForInsertionSort = Arrays.copyOf(data, data.length);
            int[] dataForGnomeSort = Arrays.copyOf(data, data.length);
            int[] dataForMergeSort = Arrays.copyOf(data, data.length);
            int[] dataForQuickSort = Arrays.copyOf(data, data.length);
            int[] dataForRadixSort = Arrays.copyOf(data, data.length);


            Insertion_Sort.insertionSort(dataForInsertionSort);
            System.out.println("The array after performing the Insertion Sort is:");
            System.out.println(Arrays.toString(dataForInsertionSort));

            Gnome_Sort.gnomeSort(dataForGnomeSort);
            System.out.println("The array after performing the Gnome Sort is:");
            System.out.println(Arrays.toString(dataForGnomeSort));

            Merge_Sort.mergeSort(dataForMergeSort, 0, dataForMergeSort.length - 1);
            System.out.println("The array after performing the Merge Sort is:");
            System.out.println(Arrays.toString(dataForMergeSort));

            Quick_Sort.quickSort(dataForQuickSort, 0, dataForQuickSort.length - 1);
            System.out.println("The array after performing the Quick Sort is:");
            System.out.println(Arrays.toString(dataForQuickSort));

            Radix_Sort.radixsort(dataForRadixSort, dataForRadixSort.length);
            System.out.println("The array after performing the Radix Sort is:");
            System.out.println(Arrays.toString(dataForRadixSort));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

