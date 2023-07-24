import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        // Tamaño del tablero (matriz cuadrada)
        int N = 5;

        // Crear el tablero y llenarlo con agua en todas las celdas
        Tablero tablero = new Tablero(N);

        // Colocar los barcos en el tablero
        colocarBarcos(tablero);

        // Mostrar el tablero con los barcos ocultos
        System.out.println("¡Hundir la Flota - Juego Iniciado!");
        tablero.mostrarTableroOculto();

        // Iniciar el juego y hacer que el usuario adivine la posición de los barcos
        int intentosMaximos = N * N; // Número máximo de intentos posibles
        int intentosRealizados = 0; // Contador de intentos realizados por el usuario

        while (!tablero.todosLosBarcosHundidos() && intentosRealizados < intentosMaximos) {
            // Solicitar al usuario que ingrese las coordenadas de la celda a atacar
            int[] coordenadas = pedirCoordenadas(N);
            int fila = coordenadas[0];
            int columna = coordenadas[1];

            // Verificar si el usuario acertó en la posición de un barco
            if (tablero.esCoordenadaValida(fila, columna)) {
                if (tablero.getTablero()[fila][columna] == 'B') {
                    System.out.println("¡Barco tocado!");
                    tablero.getTablero()[fila][columna] = 'X'; // Marcar la celda como "barco tocado"
                } else {
                    System.out.println("¡Agua tocada!");
                    tablero.getTablero()[fila][columna] = '*'; // Marcar la celda como "agua tocada"
                }
            } else {
                System.out.println("Error: coordenadas inválidas. Intente nuevamente.");
            }

            intentosRealizados++;
            tablero.mostrarTablero();
        }

        // Mostrar el resultado del juego
        if (tablero.todosLosBarcosHundidos()) {
            System.out.println("¡Felicidades! Has hundido todos los barcos.");
        } else {
            System.out.println("¡Lo siento! Has agotado tus intentos. Los barcos siguen a flote.");
        }
    }

    // Método para colocar los barcos en el tablero
    private static void colocarBarcos(Tablero tablero) {
        Scanner scanner = new Scanner(System.in);

        int barcos = tablero.tablero.length; // Cantidad de barcos, uno por fila

        for (int barco = 1; barco <= barcos; barco++) {
            System.out.println("Colocar el barco " + barco + " de tamaño " + barco);
            boolean barcoColocado = false;

            while (!barcoColocado) {
                System.out.print("Ingrese la fila de inicio del barco: ");
                int filaInicio = scanner.nextInt();
                System.out.print("Ingrese la columna de inicio del barco: ");
                int columnaInicio = scanner.nextInt();
                System.out.print("Ingrese la fila de fin del barco: ");
                int filaFin = scanner.nextInt();
                System.out.print("Ingrese la columna de fin del barco: ");
                int columnaFin = scanner.nextInt();

                // Verificar si las coordenadas están dentro del tablero y si el barco se superpone
                if (tablero.esCoordenadaValida(filaInicio, columnaInicio) &&
                        tablero.esCoordenadaValida(filaFin, columnaFin) &&
                        tablero.esPosicionLibre(filaInicio, columnaInicio, filaFin, columnaFin)) {

                    tablero.colocarBarco(filaInicio, columnaInicio, filaFin, columnaFin);
                    barcoColocado = true;
                } else {
                    System.out.println("Error: coordenadas inválidas o barco superpuesto. Intente nuevamente.");
                }
            }
        }
    }

    // Método para pedir al usuario las coordenadas de la celda a atacar
    private static int[] pedirCoordenadas(int N) {
        Scanner scanner = new Scanner(System.in);
        int[] coordenadas = new int[2];

        System.out.print("Ingrese la fila a atacar (0-" + (N - 1) + "): ");
        coordenadas[0] = scanner.nextInt();
        System.out.print("Ingrese la columna a atacar (0-" + (N - 1) + "): ");
        coordenadas[1] = scanner.nextInt();

        return coordenadas;
    }
}
