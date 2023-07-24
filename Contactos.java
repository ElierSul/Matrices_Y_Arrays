import java.util.ArrayList;
import java.util.Scanner;
public class Contactos {
    // Atributos
    private String nombre;
    private String telefono;
    private String correo;

    // Constructor
    public Contactos(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Getter y Setter
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public String getCorreo() {return correo;}
    public void setCorreo(String correo) {this.correo = correo;}

    //Metodos
    public static void agregarContacto(String nombre,String telefono,String correo, ArrayList<Contactos> listaContactos){
        Contactos nuevoContacto = new Contactos(nombre, telefono, correo);
        listaContactos.add(nuevoContacto);
        System.out.println("Contacto agregado exitosamente");
    }

    public static void buscarContacto(String nombre, int opc, ArrayList<Contactos> listaContactos){
        boolean encontrado = false;
        for (Contactos contacto : listaContactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                encontrado = true;
                if (opc == 2){
                    mostrarContacto(contacto);
                }else if (opc == 3){
                    actualizarContacto(contacto);
                }else if (opc == 4){
                    eliminarContacto(contacto, listaContactos);
                    break;
                }
            }
        }
        if (!encontrado) {
            System.out.println("Contacto no encontrado.");
        }
    }
    public static void mostrarContacto(Contactos contacto){
        System.out.println("Contacto");
        System.out.println("Nombre: " + contacto.getNombre() + "\nTelefono: " + contacto.getTelefono() + "\nCorreo: " + contacto.getCorreo());
    }

    public static void actualizarContacto(Contactos contacto){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nuevo telefono");
        String nuevoTelefono = sc.nextLine();
        System.out.println("Ingrese el nuevo correo");
        String nuevoCorreo = sc.nextLine();

        contacto.setTelefono(nuevoTelefono);
        contacto.setCorreo(nuevoCorreo);
    }

    public static void eliminarContacto(Contactos contacto, ArrayList<Contactos> listaContactos){
        listaContactos.remove(contacto);
        System.out.println("Contacto eliminado exitosamente");
    }

    public static void mostrarListaContactos (ArrayList<Contactos> listaContactos){
        System.out.println("Contactos");
        int id = 1;
        for (Contactos contacto : listaContactos) {
            System.out.println(id + ".");
            System.out.println("  Nombre: " + contacto.getNombre() + "\n  Telefono: " + contacto.getTelefono() + "\n  Correo: " + contacto.getCorreo());
            id++;
            System.out.println("-----------------------------------");
        }
    }
}
