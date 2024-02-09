package AlgortimosSorteo.src;



public class Merge_Sort {
    // Merge Sort
    public static void mergeSort(int[] array, int left, int right) {
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
}
