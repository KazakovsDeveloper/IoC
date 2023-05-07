package ru.otus.abstractFabric.sorting;

public class FillSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        int j;
        for (int i = 1; i < array.length; i++) {
            int swap = array[i];
            for (j = i; j > 0 && swap < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = swap;
        }
        return array;
    }
}
