import java.util.Arrays;

class Main {
  static void bubbleSortAlgorithm(int array[]) {
    int size = array.length;

    for (int i = 0; i < size - 1; i++)
    
      for (int j = 0; j < size - i - 1; j++)
      
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
          
        }
  }
  
  
  public static void main(String args[]) {
    int[] data = { 6, 5, 8, 1, 2 ,7 ,9 ,10};
    
    bubbleSortAlgorithm(data);
    
    System.out.println("El Array Resultante es :");
    System.out.println(Arrays.toString(data));
  }
}
