package ru.otus.abstractFabric.fabric;

import ru.otus.abstractFabric.IoC.IOC;
import ru.otus.abstractFabric.sorting.Sort;

public class MergeSortingFactory implements AbstractFactory {
    @Override
    public int[] sorting(int[] array) {
        Sort mergeSort = IOC.getFromSortingsIoc("mergeSort");
        // передаем массив на сортировку в метод
        // получаем обратно отсортированный массив
        return mergeSort.sort(array);
    }
}
