import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el tamaño de las matrices cuadradas (n): ");
        int n = sc.nextInt();

        int[][] matriz1 = new int[n][n];
        int[][] matriz2 = new int[n][n];

        System.out.println("Ingrese los elementos de la matriz1:");
        ingresarElementosMatriz(matriz1, sc);

        System.out.println("Ingrese los elementos de la matriz2:");
        ingresarElementosMatriz(matriz2, sc);

        if (!sonMatricesDelMismoTamaño(matriz1, matriz2)) {
            System.out.println("Error: Las matrices no tienen el mismo tamaño.");
            sc.close();
            return;
        }


        int[][] matrizSuma = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizSuma[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        // Imprimir la matrizSuma
        System.out.println("La suma de las matrices es:");
        imprimirMatriz(matrizSuma);

        sc.close();
    }

    private static void ingresarElementosMatriz(int[][] matriz, Scanner sc) {
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Ingrese el elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }
    }

    private static void imprimirMatriz(int[][] matriz) {
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean sonMatricesDelMismoTamaño(int[][] matriz1, int[][] matriz2) {
        return matriz1.length == matriz2.length && matriz1[0].length == matriz2[0].length;
    }
}