/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lab6P1_AlisonGuillen {
    
    public static int[] genRandArray(int size, int limitinfe, int limitsup) {
        // Genera un arreglo de enteros aleatorios dentro del rango especificado
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(limitsup - limitinfe + 1) + limitinfe;
        }
        return array;
    }
    
    public static boolean isPrime(int num) {
        // Verifica si un número es primo
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static int countPrimeFactors(int num) {
        // Cuenta la cantidad de factores primos de un número
        int cont = 0;
        for (int i = 2; i <= num; i++) {
            if (isPrime(i) && num % i == 0) {
                cont++;
            }
        }
        return cont;
    }
    
    public static int[] getTotalPrimeCount(int[] array) {
        // Calcula la cantidad de factores primos para cada elemento del arreglo
        int[] counts = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            counts[i] = countPrimeFactors(array[i]);
        }
        return counts;
    }
    
    public static int[] extraerFrecuencias(String palabra) {
        // Representa la frecuencia de aparición de cada letra en la palabra
        int[] frecuencias = new int[33];
        
        // Recorre cada caracter de la palabra
        for (char c : palabra.toCharArray()) {
            // Verifica si el caracter es una letra minúscula
            if (c >= 'a' && c <= 'z') {
                // Incrementa la frecuencia de la letra correspondiente en el arreglo
                frecuencias[c - 'a']++;
            } else if (c == 'ñ') {
                // Incrementa la frecuencia de la 'ñ'
                frecuencias[26]++;
            } else if (c == 'ü') {
                // Incrementa la frecuencia de la 'ü'
                frecuencias[32]++;
            }
        }
        
        return frecuencias;
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int respuesta = 1;

        while (respuesta != 3) {
            System.out.println("\nMenu: ");
            System.out.println("1. Cuantos primos tienes?");
            System.out.println("2. Frecuencia de letras");
            System.out.println("3. Salir");
            int opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el tamaño del arreglo a generar: ");
                    int size = leer.nextInt();
                    System.out.println("Ingrese el límite inferior: ");
                    int limitinfe = leer.nextInt();
                    System.out.println("Ingrese el límite superior: ");
                    int limitsup = leer.nextInt();
                    if (limitsup > limitinfe) {
                        int[] array = genRandArray(size, limitinfe, limitsup);
                        System.out.println("Arreglo generado: " + Arrays.toString(array));
                        int[] primeCounts = getTotalPrimeCount(array);
                        System.out.println("No. divisores primos: " + Arrays.toString(primeCounts));
                    } else {
                        System.out.println("El límite superior debe ser mayor que el límite inferior.");
                    }
                    break; 
                case 2:
                    System.out.println("Ingrese una palabra:");
                    String palabra = leer.next().toLowerCase();
                    int[] frecuencias = extraerFrecuencias(palabra);
                    System.out.println("Frecuencias para la palabra: " + Arrays.toString(frecuencias));
                    break;
                case 3:
                    respuesta = 3;
                    break;
                default:
                    System.out.println("Opcion invalid");
                    break;
            }
        }
    }
}


