package ru.otus.abstractFabric.fabric;

import ru.otus.abstractFabric.IoC.IOC;
import ru.otus.abstractFabric.sorting.Sort;

public class FillSortingFactory implements AbstractFactory {

    @Override
    public int[] sorting(int[] array) {
        Sort fillSort = IOC.getFromSortingsIoc("fillSort");
        // передаем массив на сортировку в метод
        // получаем обратно отсортированный массив
        return fillSort.sort(array);
    }
}
