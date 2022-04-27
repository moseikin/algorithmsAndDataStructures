package sort;

import java.util.*;

/**
 * Сортировка выбором осуществляется за счет итерации по несортированному списку и выбора из него наименьшего значения.
 * Это значение заносится в новый сортированный список, а из старого удаляется.
 * Проход по несортированному списку начинается снова с поиском наименьшего значения и его переносом в новый список.
 * Так продолжается до тех пор, пока несортированный список не опустеет.
 * Сложность алгоритма равняется O(n^2)
 */
public class SelectionSort {
    private static boolean ellipsisPrinted = false;

    public static void main(String[] args) {
        List<Integer> integers = initList();

        ellipsisPrinted = false;

        selectionSort(integers);
    }

    private static List<Integer> initList() {
        Random random = new Random();
        List<Integer> integers = new ArrayList<>();
        int listSize = 100_000;

        for (int i = 0; i < listSize; i++) {
            int randomInt = random.nextInt(1_000_000);
            integers.add(randomInt);
            printItem(i, listSize, randomInt);
        }
        System.out.println();
        return integers;
    }

    private static void printItem(int iteration, int listSize, int value) {
        if (iteration < 3 || iteration > listSize - 4) {
            System.out.printf(Locale.ITALY, "%,d   ", value);
        } else {
            if (!ellipsisPrinted) {
                System.out.print("... ");
                ellipsisPrinted = true;
            }
        }
    }

    private static void selectionSort(List<Integer> integers) {
        List<Integer> sortedIntegers = new ArrayList<>();
        int listSize = integers.size();
        int iteration = 0;
        long startMillis = new Date().getTime();

        while (!integers.isEmpty()) {
            int index = 0;
            int smallestInt = integers.get(0);
            for (int i = 0; i < integers.size(); i++) {
                if (integers.get(i) < smallestInt) {
                    smallestInt = integers.get(i);
                    index = i;
                }
            }
            integers.remove(index);
            sortedIntegers.add(smallestInt);

            printItem(iteration, listSize, smallestInt);

            iteration++;
        }
        printTotalTime(startMillis);
    }

    private static void printTotalTime(long startMillis) {
        long sortingSeconds = (new Date().getTime() - startMillis) / 1000;
        System.out.printf("%n Сортировка заняла %d секунд", sortingSeconds);
    }
}
