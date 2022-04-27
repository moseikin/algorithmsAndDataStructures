package search;

import java.util.*;

/**
 * Алгоритм бинарного поиска работает только в отсортированных списках.
 * 1. При каждой итерации он делит список пополам.
 * 1.1 Если искомое число больше числа в середине списка, то первая часть списка отбрасывается.
 * 1.2 Если искомое число меньше числа в середине списка, то отбрасывается вторая часть.
 * 2. Повторяется п.1 до тех пор, пока ответ не будет найден.
 *
 * Таким образом, при каждой итерации пространство для поиска уменьшается в два раза.
 * Скорость работы алгоритма будет равна O(log n):
 * Список длиной 100 миллионов элементов будет обработан максимум за 27 итераций (~2^27)
 *
 * Тогда как поиск простым перебором работает со скоростью O(n).
 * То есть, количество итераций будет зависеть от позиции искомого числа в списке.
 * В частном случае, когда число будет находиться в начале списка, простой поиск сработает быстрее, за O(1)
 */

public class BinarySearch {
    private static final int RANGE = 100_000_000;
    private static int searchInt;
    private static final Random random = new Random();
    private static int binarySearchIterations;
    private static int simpleSearchIterations;

    public static void main(String[] args) {
        List<Integer> integers = initList();
        initRandomValue();

        System.out.println("Список от 0 до " + String.format("%,d", RANGE));
        System.out.println("Ищем это значение в списке: " + String.format("%,d", searchInt));

        startBinarySearch(integers);

        startSimpleSearch(integers);
    }

    private static void initRandomValue() {
        searchInt = random.nextInt(RANGE);
    }


    private static List<Integer> initList() {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < RANGE; i++) {
            integers.add(i);
        }
        return integers;
    }

    private static void startBinarySearch(List<Integer> integers){
        long startMillis = new Date().getTime();
        binarySearch(integers);
        long binarySearchMillis = new Date().getTime() - startMillis;
        System.out.printf("Бинарный поиск занял: %d миллисекунд и %d итераций%n", binarySearchMillis, binarySearchIterations);
    }

    private static void binarySearch(List<Integer> integers) {
        int number = integers.get(integers.size() / 2);
        binarySearchIterations++;
        if (number < searchInt) {
            binarySearch(integers.subList(integers.size() / 2, integers.size()));
        } else if (number > searchInt) {
            binarySearch(integers.subList(0, integers.size() / 2));
        } else {
            System.out.println("Ответ при бинарном поиске: " + String.format("%,d", number));
        }
    }

    private static void startSimpleSearch(List<Integer> integers) {
        long simpleSearchStartMillis = new Date().getTime();
        int simpleSearchResult = simpleSearch(integers);
        long simpleSearchMillis = new Date().getTime() - simpleSearchStartMillis;
        System.out.println("Простой поиск (проверка): " + String.format("%,d", simpleSearchResult));
        System.out.printf("Затрачено %d миллисекунд, %s итераций%n", simpleSearchMillis, String.format("%,d", simpleSearchIterations));
    }

    private static int simpleSearch(List<Integer> integers) {
        for (Integer integer : integers) {
            simpleSearchIterations++;
            if (integer == searchInt) {
                return searchInt;
            }
        }
        return -1;
    }


}
