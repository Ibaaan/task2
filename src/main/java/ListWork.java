//Задание №2. Работа со списками.

// Заполните список (тип “ArrayList<Double>”) случайным числами и
//отсортируйте его. Метод сортировки выбирается в соответствии с вашим
//вариантом. Сортировку необходимо реализовать вручную (не использовать
//встроенные возможности Java или сторонних библиотек).
//Варианты заданий.

//3. Пузырьковая сортировка (Bubble Sort).

//Входные данные: количество элементов в формируемом массиве n [0, ∞).
//Выходные данные: в консоль напечатаны исходный и отсортированный
//списки.

import java.util.*;

public class ListWork {
    public static void bubbleSort(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Must be >= 0");
        }

        Random rand = new Random();
        List<Double> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(rand.nextDouble());
        }
        System.out.println("Исходный: " + list);

        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++){
                if (list.get(i) > list.get(j)){
                    Collections.swap(list, i , j);
                }
            }
        }
        System.out.println("Отсортированный: " + list);
    }
}
