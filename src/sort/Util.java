package sort;

import java.util.*;

public class Util {

    private boolean ellipsisPrinted = false;
    private final int showDigitsFromStart = 9;
    private final int showDigitsFromEnd = 9;

    public List<Integer> initList() {
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

    public void printItem(int iteration, int listSize, int value) {

        if (iteration < showDigitsFromStart || iteration > listSize - showDigitsFromEnd) {
            System.out.printf(Locale.ITALY, "%,d   ", value);
        } else {
            if (!ellipsisPrinted) {
                System.out.print("... ");
                ellipsisPrinted = true;
            }
        }
    }

    public void printTotalTimeSeconds(long startMillis) {
        long sortingSeconds = (new Date().getTime() - startMillis) / 1000;
        System.out.printf("%n Сортировка заняла %d секунд", sortingSeconds);
    }

    public void printTotalTimeMillis(long startMillis) {
        long sortingSeconds = (new Date().getTime() - startMillis);
        System.out.printf("%n Сортировка заняла %d миллисекунд", sortingSeconds);
    }

    public void iterateList(List<Integer> sortedIntegers) {
        for (int i = 0; i < sortedIntegers.size(); i++) {
            printItem(i, sortedIntegers.size(), sortedIntegers.get(i));
        }
    }

    public void setEllipsisPrinted(boolean ellipsisPrinted) {
        this.ellipsisPrinted = ellipsisPrinted;
    }

}
