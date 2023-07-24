import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        ArrayList<Contactos> listaContactos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        while(opc !=6){
            System.out.println("1. Agregar contacto\n2. Buscar contacto\n3. Actualizar contacto\n4. Eliminar contacto\n5. Mostrar contactos\n6. Salir");
            opc = sc.nextInt();
            switch (opc){
                case 1:
                    sc.nextLine();
                    System.out.println("Ingrese el nombre del contacto");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese el telefono del contacto");
                    String telefono = sc.nextLine();
                    System.out.println("Ingrese el correo del contacto");
                    String correo = sc.nextLine();
                    Contactos.agregarContacto(nombre, telefono, correo, listaContactos);
                    break;
                case 2:
                case 3:
                case 4:
                    sc.nextLine();
                    System.out.println("Ingrese el nombre del contacto");
                    nombre = sc.nextLine();
                    Contactos.buscarContacto(nombre, opc, listaContactos);
                    break;
                case 5:
                    sc.nextLine();
                    Contactos.mostrarListaContactos(listaContactos);
                    break;
            }
        }
    }
}
