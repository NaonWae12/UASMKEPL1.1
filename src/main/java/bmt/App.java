package bmt;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Program Kalkulator Sederhana ===");
        System.out.println("Masukkan angka pertama:");
        String num1Str = scanner.nextLine();

        if (!NumberUtils.isCreatable(num1Str)) {
            System.out.println("Input tidak valid!");
            return;
        }

        double num1 = Double.parseDouble(num1Str);

        System.out.println("Masukkan angka kedua:");
        String num2Str = scanner.nextLine();

        if (!NumberUtils.isCreatable(num2Str)) {
            System.out.println("Input tidak valid!");
            return;
        }

        double num2 = Double.parseDouble(num2Str);

        System.out.println("Pilih operasi matematika:");
        System.out.println("1. Penjumlahan (+)");
        System.out.println("2. Pengurangan (-)");
        System.out.println("3. Perkalian (*)");
        System.out.println("4. Pembagian (/)");

        String choiceStr = scanner.nextLine();
        int choice = Integer.parseInt(choiceStr);

        double result = 0;

        switch (choice) {
            case 1:
                result = num1 + num2;
                break;
            case 2:
                result = num1 - num2;
                break;
            case 3:
                result = num1 * num2;
                break;
            case 4:
                result = num1 / num2;
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }

        System.out.println("Hasil: " + result);
    }
}
