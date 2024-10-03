import java.util.ArrayList;
import java.util.Scanner;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення тексту
        System.out.println("Введiть текст:");
        String text = scanner.nextLine();

        // Розділення тексту на слова
        String[] words = text.split("[\\s+.,!?;]+"); // Розділення за пробілами та розділовими знаками
        ArrayList<String> removedWords = new ArrayList<>();
        StringBuilder remainingText = new StringBuilder();

        // Обробка кожного слова
        for (String word : words) {
            if (containsDuplicateLetters(word)) {
                removedWords.add(word);
            } else {
                remainingText.append(word).append(" ");
            }
        }

        // Виведення результатів
        if (!removedWords.isEmpty()) {
            System.out.println("Слова з подвоєнням лiтер: " + String.join(" ", removedWords));
        } else {
            System.out.println("Немає слiв з подвоєнням літер.");
        }

        System.out.println("Текст, що залишився: " + remainingText.toString().trim());

        scanner.close();
    }

    // Метод для перевірки наявності подвоєних літер
    private static boolean containsDuplicateLetters(String word) {
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                return true; // Якщо знайдено подвоєння
            }
        }
        return false; // Немає подвоєння
    }
}
