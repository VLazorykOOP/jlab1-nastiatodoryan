import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class EqualSumRowsColumns {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення розміру матриці
        System.out.print("Введiть розмiр матрицi (n ≤ 20): ");
        int n = scanner.nextInt();
        
        // Перевірка розміру матриці
        if (n > 20) {
            System.out.println("Розмiр матрицi не може перевищувати 20.");
            return;
        }

        // Створення матриці
        int[][] M = new int[n][n];
        System.out.println("Введiть елементи матрицi:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                M[i][j] = scanner.nextInt();
            }
        }

        // Обчислення сум рядків
        int[] rowSums = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSums[i] += M[i][j];
            }
        }

        // Обчислення сум стовпців
        int[] colSums = new int[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                colSums[j] += M[i][j];
            }
        }

        // Знаходження рядків та стовпців з однаковими сумами
        HashMap<Integer, ArrayList<Integer>> sumMap = new HashMap<>();

        // Додаємо суми рядків до мапи
        for (int i = 0; i < n; i++) {
            sumMap.computeIfAbsent(rowSums[i], k -> new ArrayList<>()).add(i + 1); // +1 для нумерації з 1
        }

        // Додаємо суми стовпців до мапи
        for (int j = 0; j < n; j++) {
            sumMap.computeIfAbsent(colSums[j], k -> new ArrayList<>()).add(-(j + 1)); // - для стовпців
        }

        // Виведення результату
        boolean found = false;
        for (var entry : sumMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                found = true;
                System.out.println("Сума " + entry.getKey() + " для:");
                for (int index : entry.getValue()) {
                    if (index > 0) {
                        System.out.println("Рядок " + index);
                    } else {
                        System.out.println("Стовпець " + (-index));
                    }
                }
            }
        }

        if (!found) {
            System.out.println("Немає рядкiв i стовпцiв з однаковими сумами.");
        }

        scanner.close();
    }
}
