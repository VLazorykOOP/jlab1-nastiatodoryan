import java.util.Scanner;

public class LongestSequenceFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення розміру масиву
        System.out.print("Введiть кiлькiсть елементiв масиву (n ≤ 300): ");
        int n = scanner.nextInt();

        // Створюємо масив цілих чисел
        int[] A = new int[n];
        System.out.println("Введiть елементи масиву:");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        // Знаходження найдовшого ланцюжка однакових чисел
        int maxLength = 1;  // Довжина найдовшого ланцюжка
        int currentLength = 1;  // Довжина поточного ланцюжка
        int number = A[0];  // Число, яке повторюється в найдовшому ланцюжку

        for (int i = 1; i < n; i++) {
            if (A[i] == A[i - 1]) {
                currentLength++;  // Збільшуємо довжину поточного ланцюжка
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    number = A[i - 1];  // Запам'ятовуємо число з найдовшого ланцюга
                }
                currentLength = 1;  // Починаємо новий ланцюжок
            }
        }

        // Остання перевірка, якщо найдовший ланцюжок був у кінці масиву
        if (currentLength > maxLength) {
            maxLength = currentLength;
            number = A[n - 1];
        }

        // Виведення результату
        System.out.println("Найдовший ланцюжок складається з числа " + number + " i має довжину " + maxLength);
        
        scanner.close();
    }
}
