import java.util.Scanner;

public class Tablero {
    protected char[][] tablero;
    private int N;

    public Tablero(int size) {
        N = size;
        tablero = new char[N][N];
        initializeTablero();
    }

    // Método para inicializar el tablero con agua en todas las celdas
    private void initializeTablero() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tablero[i][j] = '~'; // '~' representa agua
            }
        }
    }

    // Método para verificar si las coordenadas están dentro del tablero
    public boolean esCoordenadaValida(int fila, int columna) {
        return fila >= 0 && fila < N && columna >= 0 && columna < N;
    }

    // Método para verificar si la posición está libre para colocar un barco
    public boolean esPosicionLibre(int filaInicio, int columnaInicio, int filaFin, int columnaFin) {
        // Verificar si alguna de las celdas está ocupada
        for (int i = filaInicio; i <= filaFin; i++) {
            for (int j = columnaInicio; j <= columnaFin; j++) {
                if (tablero[i][j] != '~') {
                    return false;
                }
            }
        }
        return true;
    }

    // Método para colocar un barco en el tablero
    public void colocarBarco(int filaInicio, int columnaInicio, int filaFin, int columnaFin) {
        for (int i = filaInicio; i <= filaFin; i++) {
            for (int j = columnaInicio; j <= columnaFin; j++) {
                tablero[i][j] = 'B'; // 'B' representa un barco
            }
        }
    }

    // Método para mostrar el tablero con los barcos ocultos
    public void mostrarTableroOculto() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 'B') {
                    System.out.print("~ "); // Mostrar agua en lugar de barcos ocultos
                } else {
                    System.out.print(tablero[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    // Método para mostrar el tablero con los barcos visibles
    public void mostrarTablero() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método para verificar si todos los barcos han sido hundidos
    public boolean todosLosBarcosHundidos() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 'B') {
                    return false; // Si hay al menos un barco en el tablero, aún no han sido hundidos todos.
                }
            }
        }
        return true; // Si no hay barcos en el tablero, todos han sido hundidos.
    }

    public char[][] getTablero() {
        return tablero;
    }
}
