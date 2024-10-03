import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Введення змінних
        System.out.print("Введiть a: ");
        double a = scanner.nextDouble();
        System.out.print("Введiть  b: ");
        double b = scanner.nextDouble();
        
        // Варіант 1: Вхідні дані дійсного типу, результат – дійсного
        double result1 = Math.pow(a + ((a + b - 1) / (Math.pow(a, 2) + 2)) - (a * b), 3);
        System.out.println("Результат (дiйснi числа, результат дiйсного типу): " + result1);
        
        // Варіант 2: Вхідні дані цілого типу, результат – дійсного
        int aInt = (int) a;
        int bInt = (int) b;
        double result2 = Math.pow(aInt + ((aInt + bInt - 1) / (Math.pow(aInt, 2) + 2)) - (aInt * bInt), 3);
        System.out.println("Результат (цiлi числа, результат дiйсного типу): " + result2);
        
        // Варіант 3: Вхідні дані дійсного типу, результат – цілого типу
        int result3 = (int) Math.round(Math.pow(a + ((a + b - 1) / (Math.pow(a, 2) + 2)) - (a * b), 3));
        System.out.println("Результат (дiйснi числа, результат цiлого типу): " + result3);
        
        scanner.close();
    }
}
