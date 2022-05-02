package sort;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Сортировка выбором осуществляется за счет итерации по несортированному списку и выбора из него наименьшего значения.
 * Это значение заносится в новый сортированный список, а из старого удаляется.
 * Проход по несортированному списку начинается снова с поиском наименьшего значения и его переносом в новый список.
 * Так продолжается до тех пор, пока несортированный список не опустеет.
 * Сложность алгоритма равняется O(n^2)
 */
public class SelectionSort {
    private static final Util util = new Util();

    public static void main(String[] args) {
        List<Integer> integers = util.initList();

        util.setEllipsisPrinted(false);

        selectionSort(integers);
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

            util.printItem(iteration, listSize, smallestInt);

            iteration++;
        }
        util.printTotalTimeSeconds(startMillis);
    }

}
