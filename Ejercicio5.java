import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = new ArrayList<>();

        System.out.print("Ingrese la cantidad de números que desea ingresar: ");
        int numCount = scanner.nextInt();

        for (int i = 0; i < numCount; i++) {
            System.out.print("Ingrese el número " + (i + 1) + ": ");
            int num = scanner.nextInt();
            numbersList.add(num);
        }

        int largestNumber = findLargestNumber(numbersList);
        System.out.println("El número más grande encontrado es: " + largestNumber);

        scanner.close();
    }

    public static int findLargestNumber(List<Integer> numbersList) {
        if (numbersList.isEmpty()) {
            throw new IllegalArgumentException("La lista está vacía. No se puede encontrar el número más grande.");
        }

        int largest = numbersList.get(0);
        for (int num : numbersList) {
            if (num > largest) {
                largest = num;
            }
        }
        return largest;
    }
}
