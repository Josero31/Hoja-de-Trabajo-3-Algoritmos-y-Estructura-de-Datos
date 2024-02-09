package AlgortimosSorteo.src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

class Numeros_Aleatorios {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numeros = new int[3000];

        // Genera 3000 números aleatorios en el rango de 0 a 4000
        for (int i = 0; i < 3000; i++) {
            numeros[i] = random.nextInt(4001);  // Se genera un número entre 0 (inclusive) y 4001 (exclusivo)
        }

        // Escribe los números en el archivo
        String nombreArchivo = "AlgortimosSorteo/src/numeros.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int numero : numeros) {
                writer.write(Integer.toString(numero));
                writer.newLine();
            }

            // Asegúrate de que todos los datos se han escrito antes de cerrar
            writer.flush();
            System.out.println("Los números se han escrito correctamente en " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Hubo un error al escribir en el archivo");
        }
    }
}
