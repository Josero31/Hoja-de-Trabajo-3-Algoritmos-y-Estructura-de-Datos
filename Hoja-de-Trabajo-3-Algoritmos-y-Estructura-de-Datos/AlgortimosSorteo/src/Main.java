package AlgortimosSorteo.src;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.stream.Stream;

class Main {
  //Bubble Sort
  static void bubbleSortAlgorithm(int[] array) {
    var size = array.length;

    for (int i = 0; i < size - 1; i++)
      for (int j = 0; j < size - i - 1; j++)
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
  }

  // Gnome Sort
  static void gnomeSort(int[] array) {
    int index = 0;
    while (index < array.length) {
      if (index == 0)
        index++;
      if (array[index] >= array[index - 1])
        index++;
      else {
        int temp = array[index];
        array[index] = array[index - 1];
        array[index - 1] = temp;
        index--;
      }
    }
  }

  // Merge Sort
  static void mergeSort(int[] array, int left, int right) {
    if (right <= left) return;
    int mid = (left+right)>>1;
    mergeSort(array, left, mid);
    mergeSort(array, mid+1, right);
    int[] temp = new int[right - left + 1];
    int i = left, j = mid+1, k = 0;
    while (i <= mid && j <= right) {
      temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
    }
    while (i <= mid) {
      temp[k++] = array[i++];
    }
    while (j <= right) {
      temp[k++] = array[j++];
    }
    for (i = left; i <= right; i++) {
      array[i] = temp[i - left];
    }
  }

  // Quick Sort
  static int partition(int[] array, int low, int high) {
    int pivot = array[high];
    int i = (low - 1);
    for (int j = low; j < high; j++) {
      if (array[j] < pivot) {
        i++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }
    int temp = array[i + 1];
    array[i + 1] = array[high];
    array[high] = temp;
    return (i + 1);
  }

  static void quickSort(int[] array, int low, int high) {
    if (low < high) {
      int pi = partition(array, low, high);
      quickSort(array, low, pi - 1);
      quickSort(array, pi + 1, high);
    }
  }


  // Radix Sort
  static void radixsort(int[] array, int n) {
    int m = Arrays.stream(array).max().getAsInt();
    for (int exp = 1; m / exp > 0; exp *= 10)
      countSort(array, n, exp);
  }

  static void countSort(int[] array, int n, int exp) {
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
  public static void main(String[] args) {
    String fileName = "AlgortimosSorteo/src/numeros.txt";
    try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
      int[] data = stream.mapToInt(Integer::parseInt).toArray();
      int[] dataForGnomeSort = Arrays.copyOf(data, data.length);
      int[] dataForMergeSort = Arrays.copyOf(data, data.length);
      int[] dataForQuickSort = Arrays.copyOf(data, data.length);
      int[] dataForRadixSort = Arrays.copyOf(data, data.length);

      bubbleSortAlgorithm(data);
      System.out.println("The array performing the Bubble Sort Algorithm is:");
      System.out.println(Arrays.toString(data));

      gnomeSort(dataForGnomeSort);
      System.out.println("The array after performing the Gnome Sort is:");
      System.out.println(Arrays.toString(dataForGnomeSort));

      mergeSort(dataForMergeSort, 0, dataForMergeSort.length - 1);
      System.out.println("The array after performing the Merge Sort is:");
      System.out.println(Arrays.toString(dataForMergeSort));

      quickSort(dataForQuickSort, 0, dataForQuickSort.length - 1);
      System.out.println("The array after performing the Quick Sort is:");
      System.out.println(Arrays.toString(dataForQuickSort));

      radixsort(dataForRadixSort, dataForRadixSort.length);
      System.out.println("The array after performing the Radix Sort is:");
      System.out.println(Arrays.toString(dataForRadixSort));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}