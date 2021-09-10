package com.Geekbrains;

import java.io.IOException;
import java.io.PrintWriter;

/*  1.  Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
        при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
    2.  Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
        Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
        должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
    3.  В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException,
        и вывести результат расчета.
*/
public class Main {
    public static final int X_MAX = 4;
    public static final int Y_MAX = 4;

    public static void main(String[] args) {
        String[][] strArray = new String[4][4];
        strArray = fillArray(strArray);
        strArray[2][1] = "WrongCell";
        printArray(strArray);
        isRightArray(strArray);

    }
//==============================1======================================//
    private static void isRightArray(String[][] arr) {
        int x = arr[0].length, y = arr.length;  // Присваиваем размер передаваемого массива
        if (x > X_MAX || y > Y_MAX) {           //Ставим условие, ловим исключение
            try {
                throw new ArraySizeException("Размер должен быть 4x4", x, y);
            } catch (ArraySizeException e) {
                e.printStackTrace();
            }
        }

        //=======================2=========================================//

        int sum = 0;
        for (int i = 0; i < Y_MAX; i++) {
            for (int j = 0; j < X_MAX; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    System.out.println("Неверный тип переменной в ячейке - " + i + "," + j);
                }
            }
        }
        System.out.println("Сумма значений массива = " + sum);
    }

    private static String[][] fillArray (String[][] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                k++;
                arr[i][j] = Integer.toString(k);
            }
        }
        return arr;
    }

    private static void printArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

}


