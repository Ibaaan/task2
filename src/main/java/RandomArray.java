//Задание №1. Работа с массивом.

//Заполните массив (тип элементов “int”) случайными числами и
//выполните задание в соответствии со своим вариантом.

//Варианты задания.
//3. Найти среднее значение элементов в массиве.

//Входные данные: количество элементов в формируемом массиве n [0, ∞).
//Выходные данные: в консоль напечатаны массив и результат поиска в
//соответствии с заданием

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomArray {
    public static void avgElement(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Must be >= 0");
        }

        Random rand = new Random();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(rand.nextInt());
        }
        System.out.println("Исходный: " + list);

        int summ = 0;
        for (int i : list) {
            summ += i;
        }

        System.out.print("Среднее значение элементов в массиве: ");
        System.out.println((double) summ / list.size());
    }
}
