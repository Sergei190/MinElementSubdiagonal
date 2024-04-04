import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрос числа N у пользователя
        System.out.print("Введите число N (N >= 3, нечетное): ");
        int N = scanner.nextInt();

        // Проверка, что N >= 3 и N - нечетное
        while (N < 3 || N % 2 == 0) {
            System.out.println("Число должно быть не меньше 3 и быть нечетным.");
            System.out.print("Введите число N (N >= 3, нечетное): ");
            N = scanner.nextInt();
        }

        // Создание и заполнение массива NxN случайными числами
        int[][] array = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = (int) (Math.random() * 101); // Генерация случайных чисел от 0 до 100
            }
        }

        // Вывод массива в консоль
        System.out.println("Массив NxN:");
        printArray(array);

        // Нахождение минимального элемента побочной диагонали
        int minSubdiagonal = findMinSubdiagonal(array);

        // Вывод минимального элемента побочной диагонали
        System.out.println("Минимальный элемент побочной диагонали: " + minSubdiagonal);
    }

    // Метод для вывода массива в консоль
    public static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    // Метод для нахождения минимального элемента побочной диагонали
    public static int findMinSubdiagonal(int[][] array) {
        int min = array[0][array.length - 2]; // Инициализация минимального значения элемента побочной диагонали
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i][array.length - i - 2] < min) {
                min = array[i][array.length - i - 2];
            }
        }
        return min;
    }
}
