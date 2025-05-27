package org.comfortsoft;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {

    public static void main(String[] args) throws IOException {
        // Алгоритм сортировки массива слиянием с использованием рекурсии (на Java)
        // Автор реализации: Ткаченко Станислав
        // int[] arr = new int[] {38, 27, 43, 3, 9, 82, 10};
        // int[] arr = new int[] {27, 38, 43, 3, 9, 82, 10};
        // int[] arr = new int[] {10, 110, 433, 5, 12, 34};
        // int[] arr = new int[] {10, 110, 433, 5, 512, 534};
        //int[] arr = new int[] {5, 2, 4, 6, 1, 3, 2, 6};
        //sort(0, arr.length - 1, arr);
        //System.out.println(Arrays.toString(arr)); // Вывод результата в консоль

        int[] arr = loadData("C:\\Users\\Administrator\\Desktop\\Example.xlsx");
        sort(0, arr.length - 1, arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int first, int last, int... arr) {
        int half = 0;
        if (first < last) {
            half = (first + last) / 2; // Делим массив пополам, сортируем каждую половину
            sort(first, half, arr);
            sort(half + 1, last, arr);
            merge(first, half, last, arr); // Делаем слияние отсортированных половин
        }
    }

    static void merge(int first, int half, int last, int... input) {
        int[] merged = new int[last - first + 1]; // массив слияния
        int i = first;
        int j = half + 1;
        boolean iPassed = false;
        boolean jPassed = false;

        for (int taken = 0; taken < merged.length; taken++) { // число шагов == размер массива слияния
            // При финише j курсора, массив слияния дополняем остатками 1го массива
            if (jPassed) {
                merged[taken] = input[i];
                if (i < half) i++;
            }
            // При финише i курсора, массив слияния дополняем остатками 2го массива
            if (iPassed) {
                merged[taken] = input[j];
                if (j < last) j++;
            }
            // Идём курсорами i и j по каждому массиву, берём наименьшие значения на каждом шаге
            if (input[i] < input[j] && !iPassed) {
                merged[taken] = input[i];
                if (i < half) {
                    i++;
                } else {
                    iPassed = true;
                }
            } else if (input[i] >= input[j] && !jPassed) {
                merged[taken] = input[j];
                if (j < last) {
                    j++;
                } else {
                    jPassed = true;
                }
            }
        }
        // Помещаем массив слияния в исходный массив
        for (int k = 0; k < merged.length; k++) {
            input[first + k] = merged[k];
        }
        // System.out.println("first = " + first + ", half = " + half +
        //         ", last = " + last + ", input = " + Arrays.toString(input));
    }

    static int[] loadData(String filepath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filepath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0); //Первый лист
            //Row row = sheet.getRow(0);
            int maxRow = sheet.getLastRowNum(); //По последнюю строку
            int[] arr = new int[maxRow]; //Массив для входных данных

            for (int i = 0; i < maxRow; i++) {
                Cell cell = sheet.getRow(i).getCell(0);
                double cellValue = cell.getNumericCellValue();
                arr[i] = (int) cellValue;
                System.out.println(cell.getRowIndex() + " " + arr[i]);

            }
            System.out.println(Arrays.toString(arr));
            return arr;
        }
    }
}

