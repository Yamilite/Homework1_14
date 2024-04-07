import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Куранов Нурлан РИБО-05-22");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числа через ,");
        String input = scanner.nextLine();
        String[] numbers = input.split(",");

        Thread maxThread = new Thread(() -> {
            int max = Integer.MIN_VALUE;
            for (String number : numbers) {
                try {
                    int num = Integer.parseInt(number.trim());
                    if (num > max) {
                        max = num;
                    }
                } catch (NumberFormatException e) {
                    // Обработка исключения некорректного ввода числа
                }
            }
            System.out.println("Максимальное значение: " + max);
        });

        Thread minThread = new Thread(() -> {
            int min = Integer.MAX_VALUE;
            for (String number : numbers) {
                try {
                    int num = Integer.parseInt(number.trim());
                    if (num < min) {
                        min = num;
                    }
                } catch (NumberFormatException e) {

                }
            }
            System.out.println("Минимальное значение: " + min);
        });

        maxThread.start();
        minThread.start();

        try {
            maxThread.join();
            minThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}