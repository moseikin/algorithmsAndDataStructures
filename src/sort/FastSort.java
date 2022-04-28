package sort;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Быстрая сортировка.
 * 1. В качестве опорного элемента принимается любой элемент несортированного списка (в данном случае - из середины).
 * 2. Распределение элементов по двум спискам ("левому" и "правому") в зависимости от того, больше каждый опорного или нет.
 * 3. Каждый из новых списков проходит путь от п.1 до тех пор, пока размер каждого списка не станет равным 0 или 1.
 * 4. Списки проходят обратный путь, собираясь в один. При этом, меньшие элементы стоят первыми, затем опорные точки, в конце - большие элементы.
 * Скорость выполнения алгоритма O(n * log n)
 */
public class FastSort {

    private static final Util util = new Util();

    public static void main(String[] args) {
        List<Integer> integers = util.initList();

        util.setEllipsisPrinted(false);

        long startMillis = new Date().getTime();
        List<Integer> sortedIntegers = fastSort(integers);
        util.iterateList(sortedIntegers);
        util.printTotalTimeMillis(startMillis);
    }


    private static List<Integer> fastSort(List<Integer> integers) {
        if (integers.size() < 2) {
            return integers;
        } else {
            int supportElement = integers.get(integers.size() / 2);
            List<Integer> greaterValueUnsortedList = new ArrayList<>();
            List<Integer> lesserValueUnsortedList = new ArrayList<>();

            for (Integer integer : integers) {
                if (integer < supportElement) {
                    lesserValueUnsortedList.add(integer);
                } else if (integer > supportElement) {
                    greaterValueUnsortedList.add(integer);
                }
            }
            List<Integer> lesserValuesSortedList = fastSort(lesserValueUnsortedList);
            List<Integer> greaterValuesSortedList = fastSort(greaterValueUnsortedList);

            List<Integer> sorted = new ArrayList<>();
            sorted.addAll(lesserValuesSortedList);
            sorted.add(supportElement);
            sorted.addAll(greaterValuesSortedList);
            return sorted;
        }
    }


}
