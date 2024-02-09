package AlgortimosSorteo.src;



public class Gnome_Sort {
    // Gnome Sort
    public static void gnomeSort(int[] array) {
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
}
