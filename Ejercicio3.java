import java.util.ArrayList;
import java.util.Scanner;
public class Ejercicio3 {
    public static void main(String[] args) {

        ArrayList<String> Pendientes = new ArrayList<>();
        ArrayList<String> Completadas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;
        while (opcion != 5) {
            System.out.println("------- Gestion de Tareas -------");
            System.out.println("1. Agregar tarea pendiente");
            System.out.println("2. Marcar tarea como completada");
            System.out.println("3. Mostrar tareas pendientes");
            System.out.println("4. Mostrar tareas completadas");
            System.out.println("5. Salir del programa");

            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese datos de la tarea pendiente: ");
                    String tareaPendiente = scanner.nextLine();
                    Pendientes.add(tareaPendiente);
                    System.out.println("la Tarea fue agregada correctamente.");
                    break;
                case 2:
                    System.out.println("Tareas pendientes:");
                    mostrarTareas(Pendientes);
                    System.out.print("Ingrese el índice de la tarea completada: ");
                    int indiceCompletado = scanner.nextInt();
                    if (indiceCompletado >= 0 && indiceCompletado < Pendientes.size()) {
                        String tareaCompletada = Pendientes.remove(indiceCompletado);
                        Completadas.add(tareaCompletada);
                        System.out.println("Tarea marcada como completada.");
                    } else {
                        System.out.println("Índice inválido. Inténtalo de nuevo.");
                    }
                    break;
                case 3:
                    System.out.println("Tareas pendientes:");
                    mostrarTareas(Pendientes);
                    break;
                case 4:
                    System.out.println("Tareas completadas:");
                    mostrarTareas(Completadas);
                    break;
                case 5:
                    System.out.println("Hasta la proxima");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }

    public static void mostrarTareas(ArrayList<String> tareas) {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas.");
        } else {
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println(i + ". " + tareas.get(i));
            }
        }
    }
}
